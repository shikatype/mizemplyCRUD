package com.hitema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Role> findAll() {
		List<Role> roles = sessionFactory.getCurrentSession().createCriteria(Role.class).list();
		return roles;
	}

	@Transactional
	public Role findById(int idRole) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, idRole);
	}

	@Transactional
	public Role findByNom(String nom) {
		Role role = (Role) sessionFactory.getCurrentSession().
				createCriteria(Role.class).
				add(Restrictions.eq("nom", nom)).uniqueResult();
		return role;
	}

}
