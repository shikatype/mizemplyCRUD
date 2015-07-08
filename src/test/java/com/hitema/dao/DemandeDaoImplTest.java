package com.hitema.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Demande;
import com.hitema.model.Description;
import com.hitema.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-DemandeDao-test.xml" })
@Transactional
public class DemandeDaoImplTest {

	@Autowired
	private DemandeDao demandeDao;
	
	@Autowired
	private UserDao userDao; 
	
	@Autowired
	private DescriptionDao descriptionDao; 
	
	@Test
	public void testSave() {
		Demande demande = new Demande(); 
		demande.setAdresse("adresse");
		demande.setDate(new Date().toString());
		Role role = userDao.findByLogin("riverain").getRole();
		demande.setRole(role);
		demande.setOpen(true);
		demande.setTitre("titre");
		HashSet<Description> descriptions = new HashSet<Description>();
		Description description = new Description(); 
		description.setUser(userDao.findByLogin("riverain"));
		description.setDescription("decription");
		descriptions.add(description);
		demande.setDescriptions(descriptions);
		demandeDao.save(demande);
		List<Demande> demandeExpected = demandeDao.findAll();
		assertThat(demandeExpected.size()).isEqualTo(2);
		assertThat(descriptionDao.findAll().size()).isEqualTo(2);
	}

	@Test
	public void testFindAll() {
		List<Demande> demandes = demandeDao.findAll();
		assertThat(demandes.size()).isEqualTo(1);
	}

	@Test
	public void testFindByRole() {
		Role role = userDao.findByLogin("riverain").getRole();
		List<Demande> roles = demandeDao.findByRole(role);
		assertThat(roles.size()).isEqualTo(1);
	}

	@Test
	public void testFindById() {
		assertThat(demandeDao.findById(1)).isNotNull();
	}

}
