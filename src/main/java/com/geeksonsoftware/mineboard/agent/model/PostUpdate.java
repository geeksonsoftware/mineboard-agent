package com.geeksonsoftware.mineboard.agent.model;

public class PostUpdate {
	private boolean error;
	private PostUpdateSummary summary;

	public PostUpdate(boolean error, PostUpdateSummary summary) {
		super();
		this.error = error;
		this.summary = summary;
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
