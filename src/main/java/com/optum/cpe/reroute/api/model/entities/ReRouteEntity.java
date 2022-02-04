package com.optum.cpe.reroute.api.model.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


/**
 * The persistent class for the chwy_prov_clm_pend_hst database table.
 * 
 */
@Entity
@Table(name="reroutes")
public class ReRouteEntity extends PanacheEntityBase {
	@Id
	@Column(name="rerouteID")
	private long rerouteID;

	@Column(name="originalICN")
	private String originalICN;

	@Column(name="reRouteICN")
	private String reRouteICN;

	@Column(name="originalCAE")
	private String originalCAE;

	@Column(name="rerouteCAE")
	private String rerouteCAE;

	@Column(name="fln")
	private String fln;

	@Column(name="claimType")
	private String claimType;

	@Column(name="payerID")
	private String payerID;

	@Column(name="submitterID")
	private String submitterID;

	@Column(name="groupNbr")
	private String groupNbr;

	@Column(name="eeID")
	private String eeID;

	@Column(name="divPayLoc")
	private String DivPayLoc;

	@Column(name="comments")
	private String comments;
	
	//@Temporal(TemporalType.Timestamp)
	@Column(name="createDate")
	private Timestamp createDate;

	//@Temporal(TemporalType.Timestamp)
	@Column(name="updateDate")
	private Timestamp updateDate;

	@Column(name="status")
	private String status;

	@Column(name="processStatus")
	private String processStatus;
	
	@Column(name="traceNumber")
	private String traceNumber;
	
	@Column(name="claimSubmitTypeCd")
	private String claimSubmitTypeCd;

	public long getRerouteID() {
		return rerouteID;
	}

	public void setRerouteID(long rerouteID) {
		this.rerouteID = rerouteID;
	}

	public String getoriginalICN() {
		return originalICN;
	}

	public void setoriginalICN(String orignalICN) {
		this.originalICN = orignalICN;
	}

	public String getReRouteICN() {
		return reRouteICN;
	}

	public void setReRouteICN(String reRouteICN) {
		this.reRouteICN = reRouteICN;
	}

	public String getOriginalCAE() {
		return originalCAE;
	}

	public void setOriginalCAE(String originalCAE) {
		this.originalCAE = originalCAE;
	}

	public String getRerouteCAE() {
		return rerouteCAE;
	}

	public void setRerouteCAE(String rerouteCAE) {
		this.rerouteCAE = rerouteCAE;
	}

	public String getFln() {
		return fln;
	}

	public void setFln(String fln) {
		this.fln = fln;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
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

	public String getGroupNbr() {
		return groupNbr;
	}

	public void setGroupNbr(String groupNbr) {
		this.groupNbr = groupNbr;
	}

	public String getEeID() {
		return eeID;
	}

	public void setEeID(String eeID) {
		this.eeID = eeID;
	}

	public String getDivPayLoc() {
		return DivPayLoc;
	}

	public void setDivPayLoc(String divPayLoc) {
		DivPayLoc = divPayLoc;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public String getClaimSubmitTypeCd() {
		return claimSubmitTypeCd;
	}

	public void setClaimSubmitTypeCd(String claimSubmitTypeCd) {
		this.claimSubmitTypeCd = claimSubmitTypeCd;
	}

}