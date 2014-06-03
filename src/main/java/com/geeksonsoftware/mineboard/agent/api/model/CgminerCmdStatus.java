package com.geeksonsoftware.mineboard.agent.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "STATUS", "SUMMARY", "id" })
public class CgminerCmdStatus {

	@JsonProperty("STATUS")
	private List<CgminerStatus> status = new ArrayList<CgminerStatus>();
	@JsonProperty("SUMMARY")
	private List<CgminerSummary> summary = new ArrayList<CgminerSummary>();
	@JsonProperty("id")
	private Integer id;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("STATUS")
	public List<CgminerStatus> getSTATUS() {
		return status;
	}

	@JsonProperty("STATUS")
	public void setSTATUS(List<CgminerStatus> sTATUS) {
		this.status = sTATUS;
	}

	@JsonProperty("SUMMARY")
	public List<CgminerSummary> getSUMMARY() {
		return summary;
	}

	@JsonProperty("SUMMARY")
	public void setSUMMARY(List<CgminerSummary> sUMMARY) {
		this.summary = sUMMARY;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
