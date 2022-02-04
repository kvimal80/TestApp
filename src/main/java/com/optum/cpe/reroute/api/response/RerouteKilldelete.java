package com.optum.cpe.reroute.api.response;

import javax.inject.Inject;
import javax.json.bind.annotation.JsonbPropertyOrder;

import io.quarkus.runtime.annotations.RegisterForReflection;

@JsonbPropertyOrder({"icn","customServiceCode","statusMessage", "reroute", "killdelete", "repriced" })
@RegisterForReflection
public class RerouteKilldelete {
	
	public String icn;
	public String customServiceCode;
	public String statusMessage;
	private Reroute reroute;
	private Killdelete killdelete;
	private Repriced repriced;
	
	@Inject
	public RerouteKilldelete() {
		
	}
	
	public RerouteKilldelete(String icn, String statusMessage) {
		this.icn = icn;
		this.customServiceCode = "";
		this.statusMessage = statusMessage;
	}
	
	public RerouteKilldelete(String icn, String customServiceCode, String statusMessage) {
		this.icn = icn;
		this.customServiceCode = customServiceCode;
		this.statusMessage = statusMessage;
	}
	
	public Reroute getReroute() {
		return reroute;
	}
	public void setReroute(Reroute reroute) {
		this.reroute = reroute;
	}
	public Killdelete getKilldelete() {
		return killdelete;
	}
	public void setKilldelete(Killdelete killdelete) {
		this.killdelete = killdelete;
	}
	
	public Repriced getRepriced() {
		return repriced;
	}

	public void setRepriced(Repriced repriced) {
		this.repriced = repriced;
	}

	public String getIcn() {
		return icn;
	}
	public void setIcn(String icn) {
		this.icn = icn;
	}
	public String getCustomServiceCode() {
		return customServiceCode;
	}
	public void setCustomServiceCode(String customServiceCode) {
		this.customServiceCode = customServiceCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
