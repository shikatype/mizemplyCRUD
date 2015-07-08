package com.hitema.dao;

import java.util.List;

import com.hitema.model.Demande;
import com.hitema.model.Role;

public interface DemandeDao {
	
	public void save(Demande demande);
	
	public List<Demande> findAll();
	
	public List<Demande> findByRole(Role role);
	
	public Demande findById(int idDemande);
	
	
}
