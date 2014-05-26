package com.geeksonsoftware.mineboard.agent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.geeksonsoftware.mineboard.agent.api.CgminerAPI;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerCmdDevs;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerCmdStatus;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerDevice;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerStatus;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerSummary;
import com.geeksonsoftware.mineboard.agent.model.Configuration;
import com.geeksonsoftware.mineboard.agent.model.DeviceUpdate;
import com.geeksonsoftware.mineboard.agent.model.MiningSoftware;
import com.geeksonsoftware.mineboard.agent.model.PostUpdate;
import com.geeksonsoftware.mineboard.agent.model.PostUpdateResponse;
import com.geeksonsoftware.mineboard.agent.model.PostUpdateSummary;

/**
 * This class is responsible to collect data from miners (via API) and submit to mineboard server
 * 
 * @author wizche
 *
 */
public class TimerTaskUpdate extends TimerTask {
	private static Logger log = Logger.getLogger(TimerTaskUpdate.class);
	private Configuration configuration;
	private String url;

	public TimerTaskUpdate(Configuration configuration) {
		this.configuration = configuration;
		url = StaticDataService.WEBSITE_URL
				+ (StaticDataService.WEBSITE_URL.endsWith("/") ? configuration
						.getDashboardId() : "/"
						+ configuration.getDashboardId());
	}

	@Override
	public void run() {
		for (MiningSoftware miner : configuration.getMiners()) {
			switch (miner.getType()) {
			case CGMINER:
			case BFGMiner:
				CgminerAPI cgApi = new CgminerAPI(miner.getIp(),
						miner.getPort());
				CgminerCmdStatus cmdStatus = cgApi.getStatus();
				CgminerCmdDevs cmdDevs = cgApi.getDevices();

				CgminerStatus status = null;
				if (cmdStatus != null && cmdStatus.getSTATUS() != null) {
					status = cmdStatus.getSTATUS().get(0);
				}

				CgminerSummary summary = null;
				if (cmdStatus != null && cmdStatus.getSUMMARY() != null) {
					summary = cmdStatus.getSUMMARY().get(0);
				}

				if (status != null && summary != null && cmdDevs != null) {
					PostUpdateSummary pus = new PostUpdateSummary(status
							.getSTATUS().equals("S"), summary.getTotal_MH(),
							cmdDevs.getDEVS().size(),
							summary.getHardware_Errors());

					List<DeviceUpdate> devices = new ArrayList<DeviceUpdate>();
					for (CgminerDevice dev : cmdDevs.getDEVS()) {
						devices.add(new DeviceUpdate(dev.getName()
								+ dev.getID(), dev.getMHS_av()));
					}
					PostUpdate pu = new PostUpdate(false, miner.getName(), pus);
					pu.setDevices(devices);
					sendUpdate(pu);
				} else {
					log.error(String.format(
							"Unable to retrieve mining information for %s",
							miner.getType().getLabel()));
				}
				break;
			default:
				log.error(String.format(
						"Miner %s is not known or supported yet!", miner
								.getType().getLabel()));
				break;
			}
		}

	}

	private void sendUpdate(PostUpdate postUpdate) {

		ResteasyClient client = new ResteasyClientBuilder().build();

		ResteasyWebTarget target = client.target(url);

		try {
			Response response = target.request().post(
					Entity.entity(postUpdate, "application/json"));

			if (response.getStatus() != 200) {
				log.error("Webserver replied code " + response.getStatus()
						+ " instead of OK 200");
			}

			PostUpdateResponse res = response
					.readEntity(PostUpdateResponse.class);

			if (res != null && res.isOk()) {
				log.debug("Update submitted!");
			} else {
				log.error("Failed to submit the update!");
				log.debug(response.readEntity(String.class));
			}
			response.close();
		} catch (Exception e) {
			log.error("Webserver connection cannot be established!", e);
		}
	}
}
