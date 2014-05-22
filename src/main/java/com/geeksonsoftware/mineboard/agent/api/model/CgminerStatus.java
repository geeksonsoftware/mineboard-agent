package com.geeksonsoftware.mineboard.agent.api.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "STATUS", "When", "Code", "Msg", "Description" })
public class CgminerStatus {

	@JsonProperty("STATUS")
	private String sTATUS;
	@JsonProperty("When")
	private Integer when;
	@JsonProperty("Code")
	private Integer code;
	@JsonProperty("Msg")
	private String msg;
	@JsonProperty("Description")
	private String description;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("STATUS")
	public String getSTATUS() {
		return sTATUS;
	}

	@JsonProperty("STATUS")
	public void setSTATUS(String sTATUS) {
		this.sTATUS = sTATUS;
	}

	@JsonProperty("When")
	public Integer getWhen() {
		return when;
	}

	@JsonProperty("When")
	public void setWhen(Integer when) {
		this.when = when;
	}

	@JsonProperty("Code")
	public Integer getCode() {
		return code;
	}

	@JsonProperty("Code")
	public void setCode(Integer code) {
		this.code = code;
	}

	@JsonProperty("Msg")
	public String getMsg() {
		return msg;
	}

	@JsonProperty("Msg")
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("Description")
	public void setDescription(String description) {
		this.description = description;
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
