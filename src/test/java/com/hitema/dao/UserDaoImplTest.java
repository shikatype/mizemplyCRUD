package com.hitema.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Role;
import com.hitema.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-DemandeDao-test.xml" })
@Transactional
public class UserDaoImplTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSave() {
		User user = new User(); 
		user.setLogin("mairie");
		user.setPassword("password");
		Role role = userDao.findByLogin("riverain").getRole();
		user.setRole(role);
		userDao.save(user);
		assertThat(userDao.findByLogin("mairie")).isNotNull();
	}

	@Test
	public void testFindAll() {
		List<User> users = userDao.findAll();
		assertThat(users.size()).isEqualTo(1);
	}

	@Test
	public void testFindByLogin() {
		assertThat(userDao.findByLogin("riverain")).isNotNull();
	}

	@Test
	public void testFindById() {
		assertThat(userDao.findById(1)).isNotNull();
	}
	

}
