package com.geeksonsoftware.mineboard.agent.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Configuration {
	private String dashboardId;
	
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

}
