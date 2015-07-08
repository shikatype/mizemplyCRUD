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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-DemandeDao-test.xml" })
@Transactional
public class RoleDaoTest {

	@Autowired
	private RoleDao roleDao;
	
	@Test
	public void testSave() {
		Role role = new Role();
		role.setNom("comptable");
		roleDao.save(role);
	}

	@Test
	public void testFindAll() {
		List<Role> roles = roleDao.findAll();
		assertThat(roles.size()).isEqualTo(1);
	}

	@Test
	public void testFindById() {
		assertThat(roleDao.findById(1)).isNotNull();
	}
	
	@Test
	public void testFindByNom() {
		assertThat(roleDao.findByNom("riverain")).isNotNull();
	}
}
