package com.geeksonsoftware.mineboard.agent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostUpdateSummary {

	@JsonProperty("alive")
	private boolean alive;

	@JsonProperty("TotalMh")
	private Double total_MH;

	@JsonProperty("deviceCount")
	private int deviceCount;

	@JsonProperty("hwErrors")
	private Integer hardware_Errors;

	public PostUpdateSummary(boolean alive, Double totalAvgMh, int deviceCount,
			Integer hardware_Errors) {
		this.alive = alive;
		this.total_MH = totalAvgMh;
		this.deviceCount = deviceCount;
		this.hardware_Errors = hardware_Errors;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Double getTotal_MH() {
		return total_MH;
	}

	public void setTotal_MH(Double total_MH) {
		this.total_MH = total_MH;
	}

	public int getDeviceCount() {
		return deviceCount;
	}

	public void setDeviceCount(int deviceCount) {
		this.deviceCount = deviceCount;
	}

	public Integer getHardware_Errors() {
		return hardware_Errors;
	}

	public void setHardware_Errors(Integer hardware_Errors) {
		this.hardware_Errors = hardware_Errors;
	}
}
