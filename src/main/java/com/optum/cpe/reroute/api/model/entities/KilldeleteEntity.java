package com.optum.cpe.reroute.api.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="killdelete")
public class KilldeleteEntity extends PanacheEntityBase {

	@Id
	@Column(name="killdeleteId")
	private long killdeleteId;

	@Column(name="fln")
	private String fln;

	@Column(name="icn")
	private String icn;

	@Column(name="killdeleteCd")
	private String killdeleteCd;

	@Column(name="PEC")
	private String PEC;
	
	@Column(name="cae")
	private String cae;

	@Column(name="payerId")
	private String payerId;

	@Column(name = "claimTypeCd")
	private String claimTypeCd;
	
	@Column(name="submitterId")
	private String submitterId;

	@Column(name="dateRecvd")
	private String dateRecvd;

	@Column(name="status")
	private String status;

	@Column(name="processStatus")
	private String processStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name="createDate")
	private Date createDate;

	@Temporal(TemporalType.DATE)
	@Column(name="updateDate")
	private Date updateDate;

	public String getFln() {
		return fln;
	}

	public void setFln(String fln) {
		this.fln = fln;
	}

	public String getIcn() {
		return icn;
	}

	public void setIcn(String icn) {
		this.icn = icn;
	}

	public String getKilldeleteCd() {
		return killdeleteCd;
	}

	public void setKilldeleteCd(String killdeleteCd) {
		this.killdeleteCd = killdeleteCd;
	}

	public String getPEC() {
		return PEC;
	}

	public void setPEC(String pEC) {
		PEC = pEC;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getClaimTypeCd() {
		return claimTypeCd;
	}

	public void setClaimTypeCd(String claimTypeCd) {
		this.claimTypeCd = claimTypeCd;
	}

	public String getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}

	public String getDateRecvd() {
		return dateRecvd;
	}

	public void setDateRecvd(String dateRecvd) {
		this.dateRecvd = dateRecvd;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public long getKilldeleteId() {
		return killdeleteId;
	}

	public String getCae() {
		return cae;
	}

	public void setCae(String cae) {
		this.cae = cae;
	}
}
