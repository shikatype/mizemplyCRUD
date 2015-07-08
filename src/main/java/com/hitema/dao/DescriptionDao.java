package com.hitema.dao;

import java.util.List;

import com.hitema.model.Demande;
import com.hitema.model.Description;

public interface DescriptionDao {
	
	public void save(Description description);
	
	public List<Description> findAll();
	
	public List<Description> findByDemande(Demande demande);
	
	public Description findById(int idDescription);
	
	
}
