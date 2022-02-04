package com.optum.cpe.reroute.api.model.common;

/**
 * Created by jpayne20 on 4/25/20.
 */
public interface RerouteKildelConstants {
    String GET_RRKIlDEL_SUCCESS_MSG = "reroute or killdelete found successfully";

    String GET_RRKIlDEL_NOT_FOUND_MSG = "no reroute, killdelete or repriced found for icn";
  
    String GET_KIlDEL_NOT_FOUND_MSG = "no killdelete found for icn";

    String INVALID_REQUEST_MSG = "request is not valid";
    
    String INVALID_STS_CD = "invalid stsCD";

    String INVALID_DESC_CD = "invalid descCD";

    String CUSTOM_SVC_CD_ERROR = "1001";

    String CUSTOM_SVC_CD_BAD_STS_OR_DESC_CD = "1002";

    String CUSTOM_SVC_CD_NOT_FOUND = "404";

    String CUSTOM_SVS_CD_EXCEPTION = "500";
    
    String CUSTOM_SVC_CD_INVALID_REQUEST = "400";
    
    String PEC_E = "E";
	String REROTE_IND_R = "R";
	String DATE_FORMAT = "HIPPA";
	
	String CLM_TYPE_837P = "837P";
	String CLM_TYPE_837I = "837I";
	String CLM_TYPE_NSF = "NSF";
	String CLM_TYPE_UB92 = "UB92";
	String REQ_TYPE_RK = "RK";
	String REQ_TYPE_R = "R";
	String REQ_TYPE_K = "K";
	String REQ_TYPE_P = "P";
}
