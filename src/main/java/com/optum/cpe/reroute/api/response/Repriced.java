package com.optum.cpe.reroute.api.response;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.quarkus.runtime.annotations.RegisterForReflection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonbPropertyOrder({ "icn", "fln" })
@RegisterForReflection
public class Repriced {

	@JsonbProperty("icn")
	private String icn;
	
	@JsonbProperty("fln")
	private String fln;

	@JsonbProperty("vendorCode")
	private String vendorCode;
	
	@JsonbProperty("repricedDate")
	private String repricedDate;
	
	@JsonbProperty("icn")
	public String getIcn() {
		return icn;
	}

	@JsonbProperty("icn")
	public void setIcn(String icn) {
		this.icn = icn;
	}

	@JsonbProperty("fln")
	public String getFln() {
		return fln;
	}

	@JsonbProperty("fln")
	public void setFln(String fln) {
		this.fln = fln;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getRepricedDate() {
		return repricedDate;
	}

	public void setRepricedDate(String repricedDate) {
		this.repricedDate = repricedDate;
	}
	
}
