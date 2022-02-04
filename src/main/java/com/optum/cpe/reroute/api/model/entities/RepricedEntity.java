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
@Table(name="repriced")
public class RepricedEntity extends PanacheEntityBase {

	@Id
	@Column(name="id")
	private long id;

	@Column(name="icn")
	private String icn;

	@Column(name="fln")
	private String fln;

	@Column(name="vendorCode")
	private String vendorCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="repricedDate")
	private Date repricedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createDate")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updateDate")
	private Date updateDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIcn() {
		return icn;
	}

	public void setIcn(String icn) {
		this.icn = icn;
	}

	public String getFln() {
		return fln;
	}

	public void setFln(String fln) {
		this.fln = fln;
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
	
	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public Date getRepricedDate() {
		return repricedDate;
	}

	public void setRepricedDate(Date repricedDate) {
		this.repricedDate = repricedDate;
	}
}