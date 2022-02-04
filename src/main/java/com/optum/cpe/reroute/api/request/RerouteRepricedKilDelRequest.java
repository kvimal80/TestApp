package com.optum.cpe.reroute.api.request;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonbPropertyOrder({ "icn", "fln", "Type" })
public class RerouteRepricedKilDelRequest {

	@JsonbProperty("icn")
	private String icn;

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

	@JsonbProperty("Type")
	public String getType() {
		return type;
	}

	@JsonbProperty("Type")
	public void setType(String type) {
		this.type = type;
	}

}