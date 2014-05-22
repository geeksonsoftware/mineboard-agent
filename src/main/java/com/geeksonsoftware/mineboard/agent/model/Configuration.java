package com.geeksonsoftware.mineboard.agent.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geeksonsoftware.mineboard.agent.service.StaticDataService;

public class Configuration {
	private String dashboardId;

	private int intervalSeconds;

	private List<MiningSoftware> miners;

	public List<MiningSoftware> getMiners() {
		return miners;
	}

	public void setMiners(List<MiningSoftware> miners) {
		this.miners = miners;
	}

	public String getDashboardId() {
		return dashboardId;
	}

	public void setDashboardId(String dashboardId) {
		this.dashboardId = dashboardId;
	}

	@JsonIgnore
	public void addMiner(MiningSoftware miningSoftware) {
		if (miners == null)
			miners = new ArrayList<>();
		miners.add(miningSoftware);
	}

	public int getIntervalSeconds() {
		return intervalSeconds > 0 ? intervalSeconds
				: StaticDataService.DEFAULT_TIME_INTERVAL;
	}

	public void setIntervalSeconds(int intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Configuration");
		builder.append(System.getProperty("line.separator"));
		builder.append("-------------");
		builder.append(System.getProperty("line.separator"));
		builder.append("Dashboard Id: ");
		builder.append(getDashboardId());
		builder.append(System.getProperty("line.separator"));
		builder.append("Interval in seconds: ");
		builder.append(getIntervalSeconds());
		builder.append(System.getProperty("line.separator"));
		builder.append(System.getProperty("line.separator"));
		builder.append("Configured miners:");
		builder.append(System.getProperty("line.separator"));
		for (MiningSoftware m : miners) {
			builder.append(m.toString());
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}

}
