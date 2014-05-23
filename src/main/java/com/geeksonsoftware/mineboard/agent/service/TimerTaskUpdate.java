package com.geeksonsoftware.mineboard.agent.service;

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
import com.geeksonsoftware.mineboard.agent.api.model.CgminerStatus;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerSummary;
import com.geeksonsoftware.mineboard.agent.model.Configuration;
import com.geeksonsoftware.mineboard.agent.model.MiningSoftware;
import com.geeksonsoftware.mineboard.agent.model.PostUpdate;
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
			switch (miner.getName()) {
			case CGMINER:
			case BFGMiner:
				CgminerAPI cgApi = new CgminerAPI(miner.getIp(),
						miner.getPort());
				CgminerCmdStatus cmdStatus = cgApi.getStatus();
				CgminerCmdDevs cmdDevs = cgApi.getDevices();
				CgminerStatus status = cmdStatus.getSTATUS().get(0);
				CgminerSummary summary = cmdStatus.getSUMMARY().get(0);

				if (status != null && summary != null && cmdDevs != null) {
					PostUpdateSummary pus = new PostUpdateSummary(status
							.getSTATUS().equals("S"), summary.getTotal_MH(),
							cmdDevs.getDEVS().size(),
							summary.getHardware_Errors());
					PostUpdate pu = new PostUpdate(false, pus);
					sendUpdate(pu);
				} else {
					log.error(String.format(
							"Unable to retrieve mining information for %s",
							miner.getName().getLabel()));
				}
				break;
			default:
				log.error(String.format("Miner %s is not known or supported yet!", miner
						.getName().getLabel()));
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

			log.debug("Server response:");
			log.debug(response.readEntity(String.class));
			response.close();
		} catch (Exception e) {
			log.error("Webserver connection cannot be established!", e);
		}
	}
}
