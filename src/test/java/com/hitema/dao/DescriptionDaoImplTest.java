package com.hitema.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Demande;
import com.hitema.model.Description;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-DemandeDao-test.xml" })
@Transactional
public class DescriptionDaoImplTest {

	@Autowired
	private DescriptionDao descriptionDao; 
	@Autowired
	private DemandeDao demandeDao; 
	@Autowired
	private UserDao userDao; 
	
	@Test
	public void testSave(){
		Description description = new Description();
		description.setDescription("description");
		description.setUser(userDao.findByLogin("riverain"));
		descriptionDao.save(description);
		assertThat(description.getIdDescription()).isNotNull();
	}
	
	@Test
	public void testFindAll() {
		List<Description> descriptions = descriptionDao.findAll();
		assertThat(descriptions.size()).isEqualTo(1); 
	}
	
	@Test
	public void testFindByDemande() {
		Demande demande = demandeDao.findAll().get(0);
		assertThat(demande).isNotNull();
		List<Description> descriptions = descriptionDao.findByDemande(demande);
		assertThat(descriptions.size()).isEqualTo(1); 
	}

	@Test
	public void testFindById() {
		assertThat(descriptionDao.findById(1)).isNotNull();
	}

}
