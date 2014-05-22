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
@JsonPropertyOrder({ "CPU", "Name", "ID", "Enabled", "Status",
		"Device Elapsed", "MHS av", "MHS 5s", "Accepted", "Rejected",
		"Hardware Errors", "Utility", "Stale", "Last Share Pool",
		"Last Share Time", "Total MH", "Diff1 Work", "Work Utility",
		"Difficulty Accepted", "Difficulty Rejected", "Difficulty Stale",
		"Last Valid Work", "Device Hardware%", "Device Rejected%" })
public class CgminerDevice {

	@JsonProperty("CPU")
	private Integer cPU;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("ID")
	private Integer iD;
	@JsonProperty("Enabled")
	private String enabled;
	@JsonProperty("Status")
	private String status;
	@JsonProperty("Device Elapsed")
	private Integer device_Elapsed;
	@JsonProperty("MHS av")
	private Double mHS_av;
	@JsonProperty("MHS 5s")
	private Double mHS_5s;
	@JsonProperty("Accepted")
	private Integer accepted;
	@JsonProperty("Rejected")
	private Integer rejected;
	@JsonProperty("Hardware Errors")
	private Integer hardware_Errors;
	@JsonProperty("Utility")
	private Double utility;
	@JsonProperty("Stale")
	private Integer stale;
	@JsonProperty("Last Share Pool")
	private Integer last_Share_Pool;
	@JsonProperty("Last Share Time")
	private Integer last_Share_Time;
	@JsonProperty("Total MH")
	private Double total_MH;
	@JsonProperty("Diff1 Work")
	private Integer diff1_Work;
	@JsonProperty("Work Utility")
	private Double work_Utility;
	@JsonProperty("Difficulty Accepted")
	private Double difficulty_Accepted;
	@JsonProperty("Difficulty Rejected")
	private Double difficulty_Rejected;
	@JsonProperty("Difficulty Stale")
	private Double difficulty_Stale;
	@JsonProperty("Last Valid Work")
	private Integer last_Valid_Work;
	@JsonProperty("Device Hardware%")
	private Double device_Hardware_;
	@JsonProperty("Device Rejected%")
	private Double device_Rejected_;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("CPU")
	public Integer getCPU() {
		return cPU;
	}

	@JsonProperty("CPU")
	public void setCPU(Integer cPU) {
		this.cPU = cPU;
	}

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("ID")
	public Integer getID() {
		return iD;
	}

	@JsonProperty("ID")
	public void setID(Integer iD) {
		this.iD = iD;
	}

	@JsonProperty("Enabled")
	public String getEnabled() {
		return enabled;
	}

	@JsonProperty("Enabled")
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("Status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("Device Elapsed")
	public Integer getDevice_Elapsed() {
		return device_Elapsed;
	}

	@JsonProperty("Device Elapsed")
	public void setDevice_Elapsed(Integer device_Elapsed) {
		this.device_Elapsed = device_Elapsed;
	}

	@JsonProperty("MHS av")
	public Double getMHS_av() {
		return mHS_av;
	}

	@JsonProperty("MHS av")
	public void setMHS_av(Double mHS_av) {
		this.mHS_av = mHS_av;
	}

	@JsonProperty("MHS 5s")
	public Double getMHS_5s() {
		return mHS_5s;
	}

	@JsonProperty("MHS 5s")
	public void setMHS_5s(Double mHS_5s) {
		this.mHS_5s = mHS_5s;
	}

	@JsonProperty("Accepted")
	public Integer getAccepted() {
		return accepted;
	}

	@JsonProperty("Accepted")
	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	@JsonProperty("Rejected")
	public Integer getRejected() {
		return rejected;
	}

	@JsonProperty("Rejected")
	public void setRejected(Integer rejected) {
		this.rejected = rejected;
	}

	@JsonProperty("Hardware Errors")
	public Integer getHardware_Errors() {
		return hardware_Errors;
	}

	@JsonProperty("Hardware Errors")
	public void setHardware_Errors(Integer hardware_Errors) {
		this.hardware_Errors = hardware_Errors;
	}

	@JsonProperty("Utility")
	public Double getUtility() {
		return utility;
	}

	@JsonProperty("Utility")
	public void setUtility(Double utility) {
		this.utility = utility;
	}

	@JsonProperty("Stale")
	public Integer getStale() {
		return stale;
	}

	@JsonProperty("Stale")
	public void setStale(Integer stale) {
		this.stale = stale;
	}

	@JsonProperty("Last Share Pool")
	public Integer getLast_Share_Pool() {
		return last_Share_Pool;
	}

	@JsonProperty("Last Share Pool")
	public void setLast_Share_Pool(Integer last_Share_Pool) {
		this.last_Share_Pool = last_Share_Pool;
	}

	@JsonProperty("Last Share Time")
	public Integer getLast_Share_Time() {
		return last_Share_Time;
	}

	@JsonProperty("Last Share Time")
	public void setLast_Share_Time(Integer last_Share_Time) {
		this.last_Share_Time = last_Share_Time;
	}

	@JsonProperty("Total MH")
	public Double getTotal_MH() {
		return total_MH;
	}

	@JsonProperty("Total MH")
	public void setTotal_MH(Double total_MH) {
		this.total_MH = total_MH;
	}

	@JsonProperty("Diff1 Work")
	public Integer getDiff1_Work() {
		return diff1_Work;
	}

	@JsonProperty("Diff1 Work")
	public void setDiff1_Work(Integer diff1_Work) {
		this.diff1_Work = diff1_Work;
	}

	@JsonProperty("Work Utility")
	public Double getWork_Utility() {
		return work_Utility;
	}

	@JsonProperty("Work Utility")
	public void setWork_Utility(Double work_Utility) {
		this.work_Utility = work_Utility;
	}

	@JsonProperty("Difficulty Accepted")
	public Double getDifficulty_Accepted() {
		return difficulty_Accepted;
	}

	@JsonProperty("Difficulty Accepted")
	public void setDifficulty_Accepted(Double difficulty_Accepted) {
		this.difficulty_Accepted = difficulty_Accepted;
	}

	@JsonProperty("Difficulty Rejected")
	public Double getDifficulty_Rejected() {
		return difficulty_Rejected;
	}

	@JsonProperty("Difficulty Rejected")
	public void setDifficulty_Rejected(Double difficulty_Rejected) {
		this.difficulty_Rejected = difficulty_Rejected;
	}

	@JsonProperty("Difficulty Stale")
	public Double getDifficulty_Stale() {
		return difficulty_Stale;
	}

	@JsonProperty("Difficulty Stale")
	public void setDifficulty_Stale(Double difficulty_Stale) {
		this.difficulty_Stale = difficulty_Stale;
	}

	@JsonProperty("Last Valid Work")
	public Integer getLast_Valid_Work() {
		return last_Valid_Work;
	}

	@JsonProperty("Last Valid Work")
	public void setLast_Valid_Work(Integer last_Valid_Work) {
		this.last_Valid_Work = last_Valid_Work;
	}

	@JsonProperty("Device Hardware%")
	public Double getDevice_Hardware_() {
		return device_Hardware_;
	}

	@JsonProperty("Device Hardware%")
	public void setDevice_Hardware_(Double device_Hardware_) {
		this.device_Hardware_ = device_Hardware_;
	}

	@JsonProperty("Device Rejected%")
	public Double getDevice_Rejected_() {
		return device_Rejected_;
	}

	@JsonProperty("Device Rejected%")
	public void setDevice_Rejected_(Double device_Rejected_) {
		this.device_Rejected_ = device_Rejected_;
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
