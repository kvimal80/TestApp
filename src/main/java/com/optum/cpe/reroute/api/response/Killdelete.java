package com.optum.cpe.reroute.api.response;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.quarkus.runtime.annotations.RegisterForReflection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonbPropertyOrder({ "icn", "killdeletecode", "fln" })
@RegisterForReflection
public class Killdelete {

	@JsonbProperty("icn")
	private String icn;
	
	@JsonbProperty("killdeletecode")
	private String killdeletecode;
	
	@JsonbProperty("fln")
	private String fln;

	@JsonbProperty("payerID")
	private String payerID;
	
	@JsonbProperty("submitterID")
	private String submitterID;
	
	@JsonbProperty("DateReceived")
	private String dateReceived;
	
	@JsonbProperty("killDeleteStatus")
	private String killDeleteStatus;
	
	@JsonbProperty("icn")
	public String getIcn() {
		return icn;
	}

	@JsonbProperty("icn")
	public void setIcn(String icn) {
		this.icn = icn;
	}

	@JsonbProperty("killdeletecode")
	public String getKilldeletecode() {
		return killdeletecode;
	}

	@JsonbProperty("killdeletecode")
	public void setKilldeletecode(String killdeletecode) {
		this.killdeletecode = killdeletecode;
	}

	@JsonbProperty("fln")
	public String getFln() {
		return fln;
	}

	@JsonbProperty("fln")
	public void setFln(String fln) {
		this.fln = fln;
	}

	public String getPayerID() {
		return payerID;
	}

	public void setPayerID(String payerID) {
		this.payerID = payerID;
	}

	public String getSubmitterID() {
		return submitterID;
	}

	public void setSubmitterID(String submitterID) {
		this.submitterID = submitterID;
	}

	public String getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getKillDeleteStatus() {
		return killDeleteStatus;
	}

	public void setKillDeleteStatus(String killDeleteStatus) {
		this.killDeleteStatus = killDeleteStatus;
	}

}
