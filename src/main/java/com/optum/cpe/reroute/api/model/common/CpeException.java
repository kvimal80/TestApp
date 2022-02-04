package com.optum.cpe.reroute.api.model.common;

public class CpeException  extends Exception{
    private static final long serialVersionUID = 1L;
	String message;

    public CpeException(String message) {
    	this.message=message;
    }
    public String toString(){
        return ("CpeException Occurred: "+message) ;
    }
}
