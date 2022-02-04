package com.optum.cpe.reroute.api.model.entities;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class RepricedDao implements PanacheRepository<RepricedEntity>{

	@Transactional
	public RepricedEntity findByOriginalIcn(String icn) throws IllegalStateException {
		try {
			return find("icn", icn).singleResult();
		}catch(NoResultException nrExc) {}
		return null;
	}
	
	@Transactional
	public List<RepricedEntity> findAllOriginalIcn(String icn) throws IllegalStateException {
		return find("icn", icn).list();
	}
	
	@Transactional
	public RepricedEntity findByFln(String fln) throws IllegalStateException {
		try {
			return find("fln", fln).singleResult();
		}catch(NoResultException nrExc) {}
		return null;
	}
}
