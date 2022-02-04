package com.optum.cpe.reroute.api.request;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonbPropertyOrder({ "icn", "fln", "Type" })
public class RerouteKilDelRequest {

	@JsonbProperty("icn")
	private String icn;

	@JsonbProperty("fln")
	private String fln;

	@JsonbProperty("Type")
	private String type;

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

	@JsonbProperty("Type")
	public String getType() {
		return type;
	}

	@JsonbProperty("Type")
	public void setType(String type) {
		this.type = type;
	}

}