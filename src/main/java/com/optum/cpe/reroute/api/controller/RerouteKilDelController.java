package com.optum.cpe.reroute.api.controller;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.links.Link;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.optum.cpe.reroute.api.model.common.CpeException;
import com.optum.cpe.reroute.api.model.common.RerouteKildelConstants;
import com.optum.cpe.reroute.api.request.RerouteKilDelRequest;
import com.optum.cpe.reroute.api.response.RerouteKilDelResponse;
import com.optum.cpe.reroute.api.response.RerouteKilldelete;
import com.optum.cpe.reroute.api.service.RerouteKilDelService;

import io.quarkus.runtime.util.ExceptionUtil;

@Path("/claim-adjudication-route-engines")
public class RerouteKilDelController{
	private final Logger log = LoggerFactory.getLogger(RerouteKilDelController.class);
	RerouteKilDelService rerouteApiService;
	
	@GET
    @Path("/v1/ping")
	public String pingReroute() {
		return "RrKillDelete API is Active";
	}

	@Inject
	public RerouteKilDelController(RerouteKilDelService rerouteApiService) {
		this.rerouteApiService = rerouteApiService;
	}
	
	@POST
	@Path("/v1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "400", name = "PostRerouteResponseBadRequest", description = "Bad Request", links = {@Link(ref = "#/components/schemas/PostRerouteResponse"), @Link(ref = "#/components/responses/PostRerouteResponseBadRequest")})
    @APIResponse(responseCode = "200", name = "PostRerouteResponseSuccess", links = {@Link(ref = "#/components/schemas/PostRerouteResponse"), @Link(ref = "#/components/responses/PostRerouteResponseSuccess")})
	@Timed
	public Response readRerouteKilldelete(RerouteKilDelRequest rerouteApiRequest) {
		RerouteKilDelResponse rerouteApiResponse =  null;
		try {
			rerouteApiResponse = rerouteApiService.getRerouteDetails(rerouteApiRequest);
			if (rerouteApiResponse.rerouteKilldelete.customServiceCode.isEmpty()) {
			return Response
					.status(Response.Status.OK)
					.entity(rerouteApiResponse)
					.build();
			} else {
				switch (rerouteApiResponse.rerouteKilldelete.customServiceCode) {
					case RerouteKildelConstants.CUSTOM_SVC_CD_NOT_FOUND:
						log.info("Responding RRKilDel details for icn : {} : {}", rerouteApiRequest.getIcn(), RerouteKildelConstants.GET_RRKIlDEL_NOT_FOUND_MSG);
						return Response
								.status(Response.Status.OK)
								.entity(rerouteApiResponse)
								.build();
					case RerouteKildelConstants.CUSTOM_SVC_CD_ERROR:
						return Response
								.status(Response.Status.INTERNAL_SERVER_ERROR)
								.entity(rerouteApiResponse)
								.build();
					default:
						return Response
								.status(Response.Status.INTERNAL_SERVER_ERROR)
								.entity(rerouteApiResponse)
								.build();
				}
			}
		}catch (CpeException e) {
			log.error("Error to find reroute information for ICN : " + rerouteApiRequest.getIcn());
			String stackTrace = ExceptionUtil.rootCauseFirstStackTrace(e);
			log.error(stackTrace);
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new RerouteKilldelete(rerouteApiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVS_CD_EXCEPTION, "Internal Server Error"))
					.build();
		}
	}
	
	@POST
	@Path("/v2")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "400", name = "PostRerouteResponseBadRequest", description = "Bad Request", links = {@Link(ref = "#/components/schemas/PostRerouteResponse"), @Link(ref = "#/components/responses/PostRerouteResponseBadRequest")})
    @APIResponse(responseCode = "200", name = "PostRerouteResponseSuccess", links = {@Link(ref = "#/components/schemas/PostRerouteResponse"), @Link(ref = "#/components/responses/PostRerouteResponseSuccess")})
	@Timed
	public Response readRerouteKilldeleteRepriced(RerouteKilDelRequest rerouteApiRequest) {
		RerouteKilDelResponse rerouteApiResponse =  null;
		try {
			rerouteApiResponse = rerouteApiService.getRerouteRepricedDetails(rerouteApiRequest);
			if (rerouteApiResponse.rerouteKilldelete.customServiceCode.isEmpty()) {
			return Response
					.status(Response.Status.OK)
					.entity(rerouteApiResponse)
					.build();
			} else {
				switch (rerouteApiResponse.rerouteKilldelete.customServiceCode) {
					case RerouteKildelConstants.CUSTOM_SVC_CD_NOT_FOUND:
						log.info("Responding RRKilDel details for icn : {} : {}", rerouteApiRequest.getIcn(), RerouteKildelConstants.GET_RRKIlDEL_NOT_FOUND_MSG);
						return Response
								.status(Response.Status.OK)
								.entity(rerouteApiResponse)
								.build();
					case RerouteKildelConstants.CUSTOM_SVC_CD_ERROR:
						return Response
								.status(Response.Status.INTERNAL_SERVER_ERROR)
								.entity(rerouteApiResponse)
								.build();
					default:
						return Response
								.status(Response.Status.INTERNAL_SERVER_ERROR)
								.entity(rerouteApiResponse)
								.build();
				}
			}
		}catch (CpeException e) {
			log.error("Error to find reroute information for ICN : " + rerouteApiRequest.getIcn());
			String stackTrace = ExceptionUtil.rootCauseFirstStackTrace(e);
			log.error(stackTrace);
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new RerouteKilldelete(rerouteApiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVS_CD_EXCEPTION, "Internal Server Error"))
					.build();
		}
	}
	
}
