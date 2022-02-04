package com.optum.cpe.reroute.api.response;

import javax.inject.Inject;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import io.quarkus.runtime.annotations.RegisterForReflection;

@JsonbPropertyOrder({ "rerouteKilldelete"})
@RegisterForReflection
public class RerouteKilDelResponse {

	@JsonbProperty("rerouteKilldelete")
	public RerouteKilldelete rerouteKilldelete ;

	public RerouteKilDelResponse(RerouteKilldelete rerouteKilldelete) {
		this.rerouteKilldelete = rerouteKilldelete;
	}

	@Inject
	public RerouteKilDelResponse() {
	}

	public RerouteKilldelete getRerouteKilldelete() {
		return rerouteKilldelete;
	}

	public void setRerouteKilldelete(RerouteKilldelete rerouteKilldelete) {
		this.rerouteKilldelete = rerouteKilldelete;
	}
}