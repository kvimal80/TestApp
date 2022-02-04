package com.optum.cpe.reroute.api.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.optum.cpe.reroute.api.model.common.CpeException;
import com.optum.cpe.reroute.api.model.common.RerouteKildelConstants;
import com.optum.cpe.reroute.api.model.entities.KillDeleteDao;
import com.optum.cpe.reroute.api.model.entities.KilldeleteEntity;
import com.optum.cpe.reroute.api.model.entities.ReRouteEntity;
import com.optum.cpe.reroute.api.model.entities.RepricedDao;
import com.optum.cpe.reroute.api.model.entities.RepricedEntity;
import com.optum.cpe.reroute.api.model.entities.RerouteKilDelDao;
import com.optum.cpe.reroute.api.request.RerouteKilDelRequest;
import com.optum.cpe.reroute.api.response.Killdelete;
import com.optum.cpe.reroute.api.response.Repriced;
import com.optum.cpe.reroute.api.response.Reroute;
import com.optum.cpe.reroute.api.response.RerouteKilDelResponse;
import com.optum.cpe.reroute.api.response.RerouteKilldelete;
import com.optum.cpe.reroute.api.util.DateUtility;

import io.quarkus.runtime.util.ExceptionUtil;

@ApplicationScoped
public class RerouteKilDelServiceImpl implements RerouteKilDelService {
	private final Logger log = LoggerFactory.getLogger(RerouteKilDelServiceImpl.class);
	@Inject
	RerouteKilDelDao reRouteDao;
	
	@Inject
	KillDeleteDao killDeleteDao;

	@Inject
	RepricedDao repricedDao;
	
	@Inject
	DateUtility dateUtility;

	@Override
	public RerouteKilDelResponse getRerouteDetails(RerouteKilDelRequest apiRequest) throws CpeException {
		RerouteKilldelete rerouteKillDel = null;
		try {
			if (isVlaidRequest(apiRequest)) {
				Reroute reroute = getReroute(apiRequest);
				Killdelete killdelete = getKillDelete(apiRequest);
				if (reroute == null && killdelete == null) {
					rerouteKillDel = new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVC_CD_NOT_FOUND,	RerouteKildelConstants.GET_RRKIlDEL_NOT_FOUND_MSG);
				}else if(isRerouteReqType(apiRequest.getType()) && reroute == null){
					rerouteKillDel = new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVC_CD_NOT_FOUND,	RerouteKildelConstants.GET_RRKIlDEL_NOT_FOUND_MSG);
				}else if(isKillDelReqType(apiRequest.getType()) && killdelete == null){
					rerouteKillDel = new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVC_CD_NOT_FOUND,	RerouteKildelConstants.GET_RRKIlDEL_NOT_FOUND_MSG);
				}else {
					rerouteKillDel = new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.GET_RRKIlDEL_SUCCESS_MSG);
					rerouteKillDel.setReroute(reroute);
					rerouteKillDel.setKilldelete(killdelete);
				}
				return new RerouteKilDelResponse(rerouteKillDel);
			} else {
				return new RerouteKilDelResponse(new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVC_CD_INVALID_REQUEST,
						RerouteKildelConstants.INVALID_REQUEST_MSG));
			}
		} catch (Exception e) {
			String stackTrace = ExceptionUtil.rootCauseFirstStackTrace(e);
			log.error("Error ocured for icn " + apiRequest.getIcn() + " Error: " + stackTrace);
			return new RerouteKilDelResponse(new RerouteKilldelete(apiRequest.getIcn(),
					RerouteKildelConstants.CUSTOM_SVC_CD_ERROR, stackTrace.substring(0,
							!stackTrace.contains("\n") ? stackTrace.length() : stackTrace.indexOf("\n"))));
		}
	}
	
	@Override
	public RerouteKilDelResponse getRerouteRepricedDetails(RerouteKilDelRequest apiRequest) throws CpeException {
		RerouteKilldelete rerouteKillDel = null;
		try {
			if (isVlaidRequest(apiRequest) && isValidRepricedType(apiRequest)) {
				Reroute reroute = getReroute(apiRequest);
				Killdelete killdelete = getKillDelete(apiRequest);
				Repriced repriced = getRepriced(apiRequest);
				
				if (reroute == null && killdelete == null && repriced == null) {
					rerouteKillDel = new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVC_CD_NOT_FOUND,	RerouteKildelConstants.GET_RRKIlDEL_NOT_FOUND_MSG);
				}else {
					rerouteKillDel = new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.GET_RRKIlDEL_SUCCESS_MSG);
					rerouteKillDel.setReroute(reroute);
					rerouteKillDel.setKilldelete(killdelete);
					rerouteKillDel.setRepriced(repriced);
				}
				return new RerouteKilDelResponse(rerouteKillDel);
			} else {
				return new RerouteKilDelResponse(new RerouteKilldelete(apiRequest.getIcn(), RerouteKildelConstants.CUSTOM_SVC_CD_INVALID_REQUEST,
						RerouteKildelConstants.INVALID_REQUEST_MSG));
			}
		} catch (Exception e) {
			String stackTrace = ExceptionUtil.rootCauseFirstStackTrace(e);
			log.error("Error ocured for icn " + apiRequest.getIcn() + " Error: " + stackTrace);
			return new RerouteKilDelResponse(new RerouteKilldelete(apiRequest.getIcn(),
					RerouteKildelConstants.CUSTOM_SVC_CD_ERROR, stackTrace.substring(0,
							!stackTrace.contains("\n") ? stackTrace.length() : stackTrace.indexOf("\n"))));
		}
	}
	
	private Reroute getReroute(RerouteKilDelRequest apiRequest) {
		Reroute reroute = null;
		if(apiRequest.getType().contains(RerouteKildelConstants.REQ_TYPE_R)){
			ReRouteEntity reRouteEntity = null;
			if (apiRequest.getIcn() != null && !apiRequest.getIcn().isEmpty()) {
				reRouteEntity = reRouteDao.findByOriginalIcn(apiRequest.getIcn());
				if (reRouteEntity == null) {
					reRouteEntity = reRouteDao.findByReRouteIcn(apiRequest.getIcn());
				}
			} else if (null != apiRequest.getFln()) {
				reRouteEntity = reRouteDao.findByFln(apiRequest.getFln());
			}
			if (null != reRouteEntity) {
				reroute = new Reroute();
				reroute.setClaimType(reRouteEntity.getClaimType());
				reroute.setClaimTypeCd(reRouteEntity.getClaimSubmitTypeCd());
				reroute.setFln(reRouteEntity.getFln());
				reroute.setDivPayLoc(reRouteEntity.getDivPayLoc());
				reroute.setGroupNbr(reRouteEntity.getGroupNbr());
				reroute.setMemberId(reRouteEntity.getEeID());
				reroute.setOriginalCae(reRouteEntity.getOriginalCAE());
				reroute.setOriginalIcn(reRouteEntity.getoriginalICN());
				reroute.setPayerID(reRouteEntity.getPayerID());
				reroute.setRerouteCae(reRouteEntity.getRerouteCAE());
				reroute.setRerouteIcn(reRouteEntity.getReRouteICN());
				reroute.setReRouteDate(dateUtility.yymmddFormatFromTimestamp(reRouteEntity.getUpdateDate()));

			}
		}
		
		return reroute;
	}
	
	private Killdelete getKillDelete(RerouteKilDelRequest apiRequest) {
		Killdelete killdelete = null;
		if(apiRequest.getType().contains(RerouteKildelConstants.REQ_TYPE_K)){
			KilldeleteEntity killdeleteEntity = null;
			if (apiRequest.getIcn() != null && !apiRequest.getIcn().isEmpty()) {
				killdeleteEntity = killDeleteDao.findByOriginalIcn(apiRequest.getIcn());
			}else if (null != apiRequest.getFln()) {
				killdeleteEntity = killDeleteDao.findByFln(apiRequest.getFln());
			}
			if (null != killdeleteEntity) {
				killdelete = new Killdelete();
				killdelete.setIcn(killdeleteEntity.getIcn());
				killdelete.setFln(killdeleteEntity.getFln());
				killdelete.setDateReceived(killdeleteEntity.getDateRecvd());
				killdelete.setPayerID(killdeleteEntity.getPayerId());
				killdelete.setKillDeleteStatus(killdeleteEntity.getStatus());
				killdelete.setSubmitterID(killdeleteEntity.getSubmitterId());
				killdelete.setKilldeletecode(killdeleteEntity.getKilldeleteCd());

			}
		}
		return killdelete;
	}
	
	private Repriced getRepriced(RerouteKilDelRequest apiRequest) {
		Repriced repriced = null;
		if(apiRequest.getType().contains(RerouteKildelConstants.REQ_TYPE_P)){
			RepricedEntity repricedEntity = null;
			if (apiRequest.getIcn() != null && !apiRequest.getIcn().isEmpty()) {
				repricedEntity = repricedDao.findByOriginalIcn(apiRequest.getIcn());
			}
			if (null != repricedEntity) {
				repriced = new Repriced();
				repriced.setIcn(repricedEntity.getIcn());
				repriced.setFln(repricedEntity.getFln());
				repriced.setVendorCode(repricedEntity.getVendorCode());
				
				String pattern = "yyyy-MM-dd HH:mm:SS";
			    DateFormat df = new SimpleDateFormat(pattern);
			    String repricedDate = df.format(repricedEntity.getRepricedDate());
			    
				repriced.setRepricedDate(repricedDate);

			}
		}
		return repriced;
	}
	
	private boolean doPululateResp(String apiReqType, String reqType) {
		boolean doPouplateResp = false;
		if(apiReqType == null || apiReqType.isEmpty() ||  apiReqType.equals(RerouteKildelConstants.REQ_TYPE_RK) || apiReqType.equals(reqType)){
			doPouplateResp = true;
		}
		return doPouplateResp;
	}
	
	private boolean isRerouteReqType(String apiReqType) {
		boolean isRerouteReq = false;
		if(apiReqType != null && apiReqType.equals(RerouteKildelConstants.REQ_TYPE_R)){
			return isRerouteReq;
		} 
		return isRerouteReq;
	}
	
	private boolean isKillDelReqType(String apiReqType) {
		boolean isKilDelReq = false;
		if(apiReqType != null && apiReqType.equals(RerouteKildelConstants.REQ_TYPE_K)){
			return isKilDelReq;
		}
		return isKilDelReq;
	}

	private boolean isVlaidRequest(RerouteKilDelRequest rerouteApiRequest) {
		boolean isVlaid = false;
		if (rerouteApiRequest.getIcn() != null && rerouteApiRequest.getIcn().length() >= 10 && rerouteApiRequest.getIcn().length() <= 20) {
			isVlaid = true;
		} else if (rerouteApiRequest.getFln() != null && rerouteApiRequest.getFln().length() == 15) {
			isVlaid = true;
		}
		return isVlaid;
	}
	
	private boolean isValidRepricedType(RerouteKilDelRequest rerouteApiRequest) {
		boolean isValid = false;
		//Check for claim type for RKP
		if(null != rerouteApiRequest.getType() && rerouteApiRequest.getType().length() <= 0) {
			return false;
		}
		
		//Pattern is case sensitive
		Pattern pattern = Pattern.compile("[^RKP]");
	    Matcher matcher = pattern.matcher(rerouteApiRequest.getType());
	    boolean matchFound = matcher.find();
	    
		if(!matchFound) {
			isValid = true;
		}
		
		return isValid;
	}
	
}
