package com.optum.cpe.reroute.api.model.common;

public class ServiceResponse {
	private String errorMessage;
	private boolean sucsResp;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public boolean isSucsResp() {
		return sucsResp;
	}
	public void setSucsResp(boolean sucsResp) {
		this.sucsResp = sucsResp;
	}
}
