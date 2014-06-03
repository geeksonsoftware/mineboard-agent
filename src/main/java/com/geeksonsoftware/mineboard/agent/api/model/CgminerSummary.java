package com.geeksonsoftware.mineboard.agent.api.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "Elapsed", "Algorithm", "MHS av", "MHS 5s",
		"Found Blocks", "Getworks", "Accepted", "Rejected", "Hardware Errors",
		"Utility", "Discarded", "Stale", "Get Failures", "Local Work",
		"Remote Failures", "Network Blocks", "Total MH", "Diff1 Work",
		"Work Utility", "Difficulty Accepted", "Difficulty Rejected",
		"Difficulty Stale", "Best Share", "Device Hardware%",
		"Device Rejected%", "Pool Rejected%", "Pool Stale%" })
public class CgminerSummary {

	@JsonProperty("Elapsed")
	private Integer elapsed;
	@JsonProperty("Algorithm")
	private String algorithm;
	@JsonProperty("MHS av")
	private Double mHS_av;
	@JsonProperty("MHS 5s")
	private Double mHS_5s;
	@JsonProperty("Found Blocks")
	private Integer found_Blocks;
	@JsonProperty("Getworks")
	private Integer getworks;
	@JsonProperty("Accepted")
	private Integer accepted;
	@JsonProperty("Rejected")
	private Integer rejected;
	@JsonProperty("Hardware Errors")
	private Integer hardware_Errors;
	@JsonProperty("Utility")
	private Double utility;
	@JsonProperty("Discarded")
	private Integer discarded;
	@JsonProperty("Stale")
	private Integer stale;
	@JsonProperty("Get Failures")
	private Integer get_Failures;
	@JsonProperty("Local Work")
	private Integer local_Work;
	@JsonProperty("Remote Failures")
	private Integer remote_Failures;
	@JsonProperty("Network Blocks")
	private Integer network_Blocks;
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
	@JsonProperty("Best Share")
	private Integer best_Share;
	@JsonProperty("Device Hardware%")
	private Double device_Hardware_;
	@JsonProperty("Device Rejected%")
	private Double device_Rejected_;
	@JsonProperty("Pool Rejected%")
	private Double pool_Rejected_;
	@JsonProperty("Pool Stale%")
	private Double pool_Stale_;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Elapsed")
	public Integer getElapsed() {
		return elapsed;
	}

	@JsonProperty("Elapsed")
	public void setElapsed(Integer elapsed) {
		this.elapsed = elapsed;
	}

	@JsonProperty("Algorithm")
	public String getAlgorithm() {
		return algorithm;
	}

	@JsonProperty("Algorithm")
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
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

	@JsonProperty("Found Blocks")
	public Integer getFound_Blocks() {
		return found_Blocks;
	}

	@JsonProperty("Found Blocks")
	public void setFound_Blocks(Integer found_Blocks) {
		this.found_Blocks = found_Blocks;
	}

	@JsonProperty("Getworks")
	public Integer getGetworks() {
		return getworks;
	}

	@JsonProperty("Getworks")
	public void setGetworks(Integer getworks) {
		this.getworks = getworks;
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

	@JsonProperty("Discarded")
	public Integer getDiscarded() {
		return discarded;
	}

	@JsonProperty("Discarded")
	public void setDiscarded(Integer discarded) {
		this.discarded = discarded;
	}

	@JsonProperty("Stale")
	public Integer getStale() {
		return stale;
	}

	@JsonProperty("Stale")
	public void setStale(Integer stale) {
		this.stale = stale;
	}

	@JsonProperty("Get Failures")
	public Integer getGet_Failures() {
		return get_Failures;
	}

	@JsonProperty("Get Failures")
	public void setGet_Failures(Integer get_Failures) {
		this.get_Failures = get_Failures;
	}

	@JsonProperty("Local Work")
	public Integer getLocal_Work() {
		return local_Work;
	}

	@JsonProperty("Local Work")
	public void setLocal_Work(Integer local_Work) {
		this.local_Work = local_Work;
	}

	@JsonProperty("Remote Failures")
	public Integer getRemote_Failures() {
		return remote_Failures;
	}

	@JsonProperty("Remote Failures")
	public void setRemote_Failures(Integer remote_Failures) {
		this.remote_Failures = remote_Failures;
	}

	@JsonProperty("Network Blocks")
	public Integer getNetwork_Blocks() {
		return network_Blocks;
	}

	@JsonProperty("Network Blocks")
	public void setNetwork_Blocks(Integer network_Blocks) {
		this.network_Blocks = network_Blocks;
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

	@JsonProperty("Best Share")
	public Integer getBest_Share() {
		return best_Share;
	}

	@JsonProperty("Best Share")
	public void setBest_Share(Integer best_Share) {
		this.best_Share = best_Share;
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

	@JsonProperty("Pool Rejected%")
	public Double getPool_Rejected_() {
		return pool_Rejected_;
	}

	@JsonProperty("Pool Rejected%")
	public void setPool_Rejected_(Double pool_Rejected_) {
		this.pool_Rejected_ = pool_Rejected_;
	}

	@JsonProperty("Pool Stale%")
	public Double getPool_Stale_() {
		return pool_Stale_;
	}

	@JsonProperty("Pool Stale%")
	public void setPool_Stale_(Double pool_Stale_) {
		this.pool_Stale_ = pool_Stale_;
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
