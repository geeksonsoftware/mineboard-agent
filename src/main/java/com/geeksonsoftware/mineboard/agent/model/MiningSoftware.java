package com.geeksonsoftware.mineboard.agent.model;

public class MiningSoftware {

	private String name;
	private MiningSoftwareName type;
	private String ip;
	private int port;

	public MiningSoftware(String name, MiningSoftwareName type, String ip, int port) {
		this.name = name;
		this.type = type;
		this.ip = ip;
		this.port = port;
	}

	public MiningSoftware() {
	}

	public MiningSoftwareName getType() {
		return type;
	}

	public void setType(MiningSoftwareName type) {
		this.type = type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ");
		builder.append(name);
		builder.append(System.getProperty("line.separator"));
		builder.append("Type: ");
		builder.append(type.getLabel());
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
