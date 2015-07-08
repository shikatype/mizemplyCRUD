package com.hitema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> findAll() {
		List<User> users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return users;
	}

	@Override
	@Transactional
	public User findByLogin(String login) {
		User user = (User) sessionFactory.getCurrentSession().
				createCriteria(User.class).
				add(Restrictions.eq("login", login)).uniqueResult();
		return user;
	}
	
	@Transactional
	public User findById(int idUser) {
		return (User) sessionFactory.getCurrentSession().get(User.class, idUser);
	}

}
