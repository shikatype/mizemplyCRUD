package com.hitema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Demande;
import com.hitema.model.Description;

@Repository
public class DescriptionDaoImpl implements DescriptionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(Description description) {
		sessionFactory.getCurrentSession().saveOrUpdate(description);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Description> findAll() {
		List<Description> descriptions = sessionFactory.getCurrentSession().createCriteria(Description.class).list();
		return descriptions;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Description> findByDemande(Demande demande) {
		List<Description> descriptions = sessionFactory.getCurrentSession().createCriteria(Description.class).add(Restrictions.eq("demande",demande)).list();
		return descriptions;
	}
	
	@Transactional
	public Description findById(int idDescription) {
		return (Description) sessionFactory.getCurrentSession().get(Description.class, idDescription);
	}

}
