package com.hitema.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hitema.model.Demande;
import com.hitema.model.Paiement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-DemandeDao-test.xml" })
@Transactional
public class PaiementDaoTest {


	@Autowired
	private PaiementDao paiementDao; 
	@Autowired
	private UserDao userDao;
	@Autowired
	private DemandeDao demandeDao; 

	@Test
	public void testSave() {
		Paiement paiement = new Paiement();
		paiement.setDate(new Date().toString());
		paiement.setMontant(500);
		paiement.setUser(userDao.findByLogin("riverain"));
		paiementDao.save(paiement);
		assertThat(paiement.getIdPaiement()).isNotNull();
	}

	@Test
	public void testFindAll() {
		List<Paiement> paiements = paiementDao.findAll();
		assertThat(paiements.size()).isEqualTo(1); 
	}

	@Test
	public void testFindByDemande() {
		Demande demande = demandeDao.findAll().get(0);
		assertThat(demande).isNotNull();
		List<Paiement> paiements = paiementDao.findByDemande(demande);
		assertThat(paiements.size()).isEqualTo(1); 
	}

	@Test
	public void testFindById() {
		assertThat(paiementDao.findById(1)).isNotNull();
	}

}
