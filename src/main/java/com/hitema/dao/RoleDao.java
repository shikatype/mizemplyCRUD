package com.hitema.dao;

import java.util.List;

import com.hitema.model.Role;

public interface RoleDao {

	public void save(Role role);
	
	public List<Role> findAll();
	
	public Role findById(int idRole);
	
	public Role findByNom(String nom);
	
}
