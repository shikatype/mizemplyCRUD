package com.hitema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Demande;
import com.hitema.model.Paiement;

@Repository
public class PaiementDaoImpl implements PaiementDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void save(Paiement paiement) {
		sessionFactory.getCurrentSession().saveOrUpdate(paiement);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Paiement> findAll() {
		List<Paiement> paiements = sessionFactory.getCurrentSession().createCriteria(Paiement.class).list();
		return paiements;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Paiement> findByDemande(Demande demande) {
		List<Paiement> paiements = sessionFactory.getCurrentSession().createCriteria(Paiement.class).add(Restrictions.eq("demande",demande)).list();
		return paiements;
	}
	
	@Transactional
	public Paiement findById(int idPaiement) {
		return (Paiement) sessionFactory.getCurrentSession().get(Paiement.class, idPaiement);
	}

}
