package com.optum.cpe.reroute.api.response;

import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.inject.Inject;

@RegisterForReflection
public class Status {

	public String icn;
	public String customServiceCode;
	public String statusMessage;

	public Status(String icn, String customServiceCode, String statusMessage) {
		this.icn = icn;
		this.customServiceCode = customServiceCode;
		this.statusMessage = statusMessage;
	}
	
	public Status(String icn, String statusMessage) {
		this.icn = icn;
		this.customServiceCode = "";
		this.statusMessage = statusMessage;
	}

	@Inject
	public Status() {
	}

	@Override
	public String toString() {
		return "Status{" +
				"icn='" + icn + '\'' +
				", customServiceCode='" + customServiceCode + '\'' +
				", statusMessage='" + statusMessage + '\'' +
				'}';
	}
}