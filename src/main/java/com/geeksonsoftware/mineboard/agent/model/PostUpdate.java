package com.geeksonsoftware.mineboard.agent.model;

public class PostUpdate {
	private boolean error;
	private String message;

	public PostUpdate(boolean error, String message) {
		super();
		this.error = error;
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
