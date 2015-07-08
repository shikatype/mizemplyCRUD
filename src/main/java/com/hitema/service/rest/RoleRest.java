package com.hitema.service.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hitema.dao.RoleDao;
import com.hitema.model.Role;

@Component
@Path("/roleDao")
public class RoleRest {

	@Autowired
	private RoleDao roleDao; 
	
	@GET
	@Produces("application/json")
	@Path("/findAllRoles")
	public List<Role> findAllRoles() {
		 List<Role> roles = roleDao.findAll();	
		 return roles;
	}
	
	@GET
	@Produces("application/json")
	@Path("/findByNom/{nom}")
	public Role findByNom(@PathParam("nom") String nom) {
		 Role role = roleDao.findByNom(nom);
		 if(role != null){
			 return role;
		 }
		 return new Role(); 
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Role role) {
		roleDao.save(role);
		return Response.status(201).build();
	}
}
