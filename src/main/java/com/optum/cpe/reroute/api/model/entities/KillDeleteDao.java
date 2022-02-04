package com.optum.cpe.reroute.api.model.entities;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;


import com.optum.cpe.reroute.api.model.common.CpeException;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class KillDeleteDao implements PanacheRepository<KilldeleteEntity>{
	
	@Transactional
	public KilldeleteEntity findById(long id) throws CpeException {
		try {
			return KilldeleteEntity.findById(id);
		} catch (Exception exc) {
			throw new CpeException(exc.getMessage());	
		}
	}
	
	@Transactional
	public KilldeleteEntity findByFln(String fln) throws IllegalStateException {
		try {
			return find("fln", fln).singleResult();
		}catch(NoResultException nrExc) {}
		return null;
	}
	
	@Transactional
	public KilldeleteEntity findByOriginalIcn(String icn) throws IllegalStateException {
		try {
			return find("icn", icn).singleResult();
		}catch(NoResultException nrExc) {}
		return null;
	}
	
	
	@Transactional
	public List<KilldeleteEntity> findAllOriginalIcn(String icn) throws IllegalStateException {
		return find("icn", icn).list();
	}
}