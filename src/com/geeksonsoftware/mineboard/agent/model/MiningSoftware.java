package com.geeksonsoftware.mineboard.agent.model;

public class MiningSoftware {

	private MiningSoftwareName name;
	private String ip;
	private int port;

	public MiningSoftware(MiningSoftwareName name, String ip, int port) {
		this.name = name;
		this.ip = ip;
		this.port = port;
	}

	public MiningSoftware() {
	}

	public MiningSoftwareName getName() {
		return name;
	}

	public void setName(MiningSoftwareName name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIP(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ");
		builder.append(name.getLabel());
		builder.append(System.getProperty("line.separator"));
		builder.append("IP: ");
		builder.append(ip);
		builder.append(System.getProperty("line.separator"));
		builder.append("Port: ");
		builder.append(port);
		builder.append(System.getProperty("line.separator"));
		return builder.toString();
	}

}
