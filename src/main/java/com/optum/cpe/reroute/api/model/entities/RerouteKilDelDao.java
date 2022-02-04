package com.optum.cpe.reroute.api.model.entities;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class RerouteKilDelDao implements PanacheRepository<ReRouteEntity> {
	private final Logger log = LoggerFactory.getLogger(RerouteKilDelDao.class);

	@Transactional
	public ReRouteEntity findByOriginalIcn(String icn) throws IllegalStateException {
		ReRouteEntity reRouteEntity = null;
		try {
			reRouteEntity = ReRouteEntity.find("originalICN", icn).singleResult();
		} catch (NoResultException e) {
			log.error("Record not found OriginalICN : " + icn);
		}
		return reRouteEntity;
	}

	@Transactional
	public ReRouteEntity findByReRouteIcn(String icn) throws IllegalStateException {
		ReRouteEntity reRouteEntity = null;
		try {
			reRouteEntity = ReRouteEntity.find("reRouteICN", icn).singleResult();
		} catch (NoResultException e) {
			log.error("Record not found RerouteIcn : " + icn);
		}
		return reRouteEntity;
	}

	@Transactional
	public ReRouteEntity findByFln(String fln) throws IllegalStateException {
		ReRouteEntity reRouteEntity = null;
		try {
			reRouteEntity = ReRouteEntity.find("fln", fln).singleResult();
		} catch (NoResultException e) {
			log.error("Record not found fln : " + fln);
		}
		return reRouteEntity;
	}
}
