package com.geeksonsoftware.mineboard.agent.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonProperty;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class PostUpdate {
	private boolean error;
	private PostUpdateSummary summary;
	private String secret;

	@JsonProperty("devices")
	private List<DeviceUpdate> devices = new ArrayList<DeviceUpdate>();

	public PostUpdate(boolean error, String secret, PostUpdateSummary summary) {
		super();
		this.error = error;
		this.secret = secret;
		this.summary = summary;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@JsonProperty("devices")
	public List<DeviceUpdate> getDevices() {
		return devices;
	}

	@JsonProperty("devices")
	public void setDevices(List<DeviceUpdate> devices) {
		this.devices = devices;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public PostUpdateSummary getSummary() {
		return summary;
	}

	public void setSummary(PostUpdateSummary summary) {
		this.summary = summary;
	}
}
