package com.hitema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Demande;
import com.hitema.model.Role;

@Repository
public class DemandeDaoImpl implements DemandeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(Demande demande) {
		sessionFactory.getCurrentSession().saveOrUpdate(demande);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Demande> findAll() {
		List<Demande> demandes = sessionFactory.getCurrentSession().createCriteria(Demande.class).list();
		return demandes;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Demande> findByRole(Role role) {
		List<Demande> demandes = sessionFactory.getCurrentSession().createCriteria(Demande.class).add(Restrictions.eq("role",role)).list();
		return demandes;
	}

	@Transactional
	public Demande findById(int idDemande) {
		return (Demande) sessionFactory.getCurrentSession().get(Demande.class, idDemande);
	}

}
