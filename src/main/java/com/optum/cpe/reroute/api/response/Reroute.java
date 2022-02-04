package com.optum.cpe.reroute.api.response;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import io.quarkus.runtime.annotations.RegisterForReflection;


@JsonbPropertyOrder({ "originalIcn", "rerouteIcn", "originalCae", "rerouteCae", "fln", "reRouteDate", "payerID",
		"claimType", "claimTypeCd", "groupNbr", "memberId", "divPayLoc", "comments" })
@RegisterForReflection
public class Reroute {

	@JsonbProperty("originalIcn")
	private String originalIcn;

	@JsonbProperty("rerouteIcn")
	private String rerouteIcn;

	@JsonbProperty("originalCae")
	private String originalCae;

	@JsonbProperty("rerouteCae")
	private String rerouteCae;

	@JsonbProperty("fln")
	private String fln;

	@JsonbProperty("reRouteDate")
	private String reRouteDate;

	@JsonbProperty("payerID")
	private String payerID;

	@JsonbProperty("claimType")
	private String claimType;

	@JsonbProperty("claimTypeCd")
	private String claimTypeCd;

	@JsonbProperty("groupNbr")
	private String groupNbr;

	@JsonbProperty("memberId")
	private String memberId;

	@JsonbProperty("divPayLoc")
	private String divPayLoc;

	@JsonbProperty("comments")
	private String comments;

	@JsonbProperty("originalIcn")
	public String getOriginalIcn() {
		return originalIcn;
	}

	@JsonbProperty("originalIcn")
	public void setOriginalIcn(String originalIcn) {
		this.originalIcn = originalIcn;
	}

	@JsonbProperty("rerouteIcn")
	public String getRerouteIcn() {
		return rerouteIcn;
	}

	@JsonbProperty("rerouteIcn")
	public void setRerouteIcn(String rerouteIcn) {
		this.rerouteIcn = rerouteIcn;
	}

	@JsonbProperty("originalCae")
	public String getOriginalCae() {
		return originalCae;
	}

	@JsonbProperty("originalCae")
	public void setOriginalCae(String originalCae) {
		this.originalCae = originalCae;
	}

	@JsonbProperty("rerouteCae")
	public String getRerouteCae() {
		return rerouteCae;
	}

	@JsonbProperty("rerouteCae")
	public void setRerouteCae(String rerouteCae) {
		this.rerouteCae = rerouteCae;
	}

	@JsonbProperty("fln")
	public String getFln() {
		return fln;
	}

	@JsonbProperty("fln")
	public void setFln(String fln) {
		this.fln = fln;
	}

	@JsonbProperty("reRouteDate")
	public String getReRouteDate() {
		return reRouteDate;
	}

	@JsonbProperty("reRouteDate")
	public void setReRouteDate(String reRouteDate) {
		this.reRouteDate = reRouteDate;
	}

	@JsonbProperty("payerID")
	public String getPayerID() {
		return payerID;
	}

	@JsonbProperty("payerID")
	public void setPayerID(String payerID) {
		this.payerID = payerID;
	}

	@JsonbProperty("claimType")
	public String getClaimType() {
		return claimType;
	}

	@JsonbProperty("claimType")
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@JsonbProperty("claimTypeCd")
	public String getClaimTypeCd() {
		return claimTypeCd;
	}

	@JsonbProperty("claimTypeCd")
	public void setClaimTypeCd(String claimTypeCd) {
		this.claimTypeCd = claimTypeCd;
	}

	@JsonbProperty("groupNbr")
	public String getGroupNbr() {
		return groupNbr;
	}

	@JsonbProperty("groupNbr")
	public void setGroupNbr(String groupNbr) {
		this.groupNbr = groupNbr;
	}

	@JsonbProperty("memberId")
	public String getMemberId() {
		return memberId;
	}

	@JsonbProperty("memberId")
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@JsonbProperty("divPayLoc")
	public String getDivPayLoc() {
		return divPayLoc;
	}

	@JsonbProperty("divPayLoc")
	public void setDivPayLoc(String divPayLoc) {
		this.divPayLoc = divPayLoc;
	}

	@JsonbProperty("comments")
	public String getComments() {
		return comments;
	}

	@JsonbProperty("comments")
	public void setComments(String comments) {
		this.comments = comments;
	}

}