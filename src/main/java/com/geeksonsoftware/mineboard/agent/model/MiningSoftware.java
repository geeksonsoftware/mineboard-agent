package com.geeksonsoftware.mineboard.agent.model;

public class MiningSoftware {

	private MiningSoftwareName type;
	private String ip;
	private int port;
	private String secret;

	public MiningSoftware(String secret,MiningSoftwareName type, String ip, int port) {
		this.secret = secret;
		this.type = type;
		this.ip = ip;
		this.port = port;
	}

	public MiningSoftware() {
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Secret: ");
		builder.append(secret);
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
