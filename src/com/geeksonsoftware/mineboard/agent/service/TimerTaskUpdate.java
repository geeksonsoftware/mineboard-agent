package com.geeksonsoftware.mineboard.agent.service;

import java.util.TimerTask;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

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

	private Configuration configuration;
	private String url = "http://localhost:3000/api/update/";

	public TimerTaskUpdate(Configuration configuration) {
		this.configuration = configuration;
		url += configuration.getDashboardId();
	}

	@Override
	public void run() {
		PostUpdate data = new PostUpdate(false, "Test Message!");

		ResteasyClient client = new ResteasyClientBuilder().build();

		ResteasyWebTarget target = client.target(url);

		Response response = target.request().post(
				Entity.entity(data, "application/json"));

		if (response.getStatus() != 200) {

			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());

		}

		System.out.println("Server response : \n");

		System.out.println(response.readEntity(String.class));

		response.close();

	}
}
