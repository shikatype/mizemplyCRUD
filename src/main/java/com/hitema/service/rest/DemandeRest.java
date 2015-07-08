package com.hitema.service.rest;

import java.util.ArrayList;
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

import com.hitema.dao.DemandeDao;
import com.hitema.dao.RoleDao;
import com.hitema.dao.UserDao;
import com.hitema.model.Demande;
import com.hitema.model.Role;

@Component
@Path("/demandeDao")
public class DemandeRest {
	@Autowired
	private UserDao userDao;
	@Autowired
	DemandeDao demandeDao;
	@Autowired
	RoleDao roleDao;

	@GET
	@Produces("application/json")
	@Path("/findAllDemandes")
	public List<Demande> findAllDemandes() {
		List<Demande> demandes = demandeDao.findAll();
		return demandes;
	}

	@POST
	@Path("/findByRole")
	@Consumes("application/json")
	@Produces("application/json")
	public Response findByRole(Role role) {
		List<Demande> demandes = demandeDao.findByRole(role);
		if (demandes != null) {
			Response.status(201).entity(new ArrayList<Demande>()).build();
		}
		return Response.status(201).entity(demandes).build();
	}

	@GET
	@Path("/recupDemandeParRoleName/{roleName}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response findByRoleName(@PathParam("roleName") String roleName) {
		Role role=roleDao.findByNom(roleName);
		List<Demande> demandes = demandeDao.findByRole(role);
		if (demandes != null) {
			Response.status(201).entity(new ArrayList<Demande>()).build();
		}
		return Response.status(201).entity(demandes).build();
	}
	
	@GET
	@Path("/recupDemandeParId/{idDemande}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response findById(@PathParam("idDemande") String idDemande) {
		Demande demandes = demandeDao.findById(Integer.parseInt(idDemande));
		if (demandes != null) {
			Response.status(201).entity(new ArrayList<Demande>()).build();
		}
		return Response.status(201).entity(demandes).build();
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Demande demande) {
		demandeDao.save(demande);
		return Response.status(201).build();
	}
}
