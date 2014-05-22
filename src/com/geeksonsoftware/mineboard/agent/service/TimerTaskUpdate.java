package com.geeksonsoftware.mineboard.agent.service;

import java.util.TimerTask;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.geeksonsoftware.mineboard.agent.model.Configuration;
import com.geeksonsoftware.mineboard.agent.model.PostUpdate;

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
		PostUpdate data = new PostUpdate(false, "Test Message!");

		ResteasyClient client = new ResteasyClientBuilder().build();

		ResteasyWebTarget target = client.target(url);

		Response response = target.request().post(
				Entity.entity(data, "application/json"));

		if (response.getStatus() != 200) {
			log.error("Webserver replied code " + response.getStatus()
					+ " instead of OK 200");
		}

		log.debug("Server response:");
		log.debug(response.readEntity(String.class));
		response.close();

	}
}
