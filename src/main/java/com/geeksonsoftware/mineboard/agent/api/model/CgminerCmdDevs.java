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
@JsonPropertyOrder({ "STATUS", "DEVS", "id" })
public class CgminerCmdDevs {

	@JsonProperty("STATUS")
	private List<CgminerStatus> sTATUS = new ArrayList<CgminerStatus>();
	@JsonProperty("DEVS")
	private List<CgminerDevice> dEVS = new ArrayList<CgminerDevice>();
	@JsonProperty("id")
	private Integer id;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("STATUS")
	public List<CgminerStatus> getSTATUS() {
		return sTATUS;
	}

	@JsonProperty("STATUS")
	public void setSTATUS(List<CgminerStatus> sTATUS) {
		this.sTATUS = sTATUS;
	}

	@JsonProperty("DEVS")
	public List<CgminerDevice> getDEVS() {
		return dEVS;
	}

	@JsonProperty("DEVS")
	public void setDEVS(List<CgminerDevice> dEVS) {
		this.dEVS = dEVS;
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
