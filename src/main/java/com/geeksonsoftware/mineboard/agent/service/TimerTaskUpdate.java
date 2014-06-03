package com.geeksonsoftware.mineboard.agent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;

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
	private Client client;

	public TimerTaskUpdate(Configuration configuration) {
		client = ClientBuilder.newClient();
		// enable POJO mapping via Jackson
		client.register(JacksonFeature.class);

		this.configuration = configuration;
		url = StaticDataService.getWebsiteUrl()
				+ (StaticDataService.getWebsiteUrl().endsWith("/") ? configuration
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
					PostUpdate pu = new PostUpdate(false, miner.getSecret(),
							pus);
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
		try {
			Response response = client
					.target(url)
					.request(MediaType.APPLICATION_JSON)
					.post(Entity.entity(postUpdate, MediaType.APPLICATION_JSON));

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
				log.debug(res.getError());
			}
		} catch (Exception e) {
			log.error("Post update failed!", e);
		}
	}
}
