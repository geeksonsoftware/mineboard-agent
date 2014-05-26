package com.geeksonsoftware.mineboard.agent.model;

public class DeviceUpdate {

	private String id;
	private double averageMh;
	
	public DeviceUpdate(String id, double averageMh) {
		this.id = id;
		this.averageMh = averageMh;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAverageMh() {
		return averageMh;
	}
	public void setAverageMh(double averageMh) {
		this.averageMh = averageMh;
	}
	
	
}
