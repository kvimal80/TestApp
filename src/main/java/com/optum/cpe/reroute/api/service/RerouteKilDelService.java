package com.optum.cpe.reroute.api.service;

import javax.enterprise.context.ApplicationScoped;

import com.optum.cpe.reroute.api.model.common.CpeException;
import com.optum.cpe.reroute.api.request.RerouteKilDelRequest;
import com.optum.cpe.reroute.api.response.RerouteKilDelResponse;

@ApplicationScoped
public interface RerouteKilDelService {

	public RerouteKilDelResponse getRerouteDetails(RerouteKilDelRequest rerouteApiRequest) throws CpeException;
	
	public RerouteKilDelResponse getRerouteRepricedDetails(RerouteKilDelRequest rerouteApiRequest) throws CpeException;
}
