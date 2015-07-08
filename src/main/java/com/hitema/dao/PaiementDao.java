package com.hitema.dao;

import java.util.List;

import com.hitema.model.Demande;
import com.hitema.model.Paiement;

public interface PaiementDao {
	
	public void save(Paiement paiement);
	
	public List<Paiement> findAll();
	
	public List<Paiement> findByDemande(Demande demande);
	
	public Paiement findById(int idPaiement);
	
	
}
