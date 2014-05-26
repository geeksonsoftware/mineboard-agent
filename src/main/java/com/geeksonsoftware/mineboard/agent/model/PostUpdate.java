package com.geeksonsoftware.mineboard.agent.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostUpdate {
	private boolean error;
	private PostUpdateSummary summary;
	private String name;

	@JsonProperty("devices")
	private List<DeviceUpdate> devices = new ArrayList<DeviceUpdate>();

	public PostUpdate(boolean error, String name, PostUpdateSummary summary) {
		super();
		this.error = error;
		this.name = name;
		this.summary = summary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
