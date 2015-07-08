package com.hitema.service.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hitema.dao.DemandeDao;
import com.hitema.dao.DescriptionDao;
import com.hitema.dao.UserDao;
import com.hitema.model.Demande;
import com.hitema.model.Description;

@Component
@Path("/descriptionDao")
public class DescriptionRest {

	@Autowired
	private DescriptionDao descriptionDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	DemandeDao demandeDao;

	@GET
	@Produces("application/json")
	@Path("/findAllDescriptions")
	public List<Description> findAllDescriptions() {
		List<Description> descriptions = descriptionDao.findAll();
		return descriptions;
	}

	@POST
	@Path("/findByDemande")
	@Consumes("application/json")
	@Produces("application/json")
	public Response findByDemande(Demande demande) {
		demande = demandeDao.findById(1);
		List<Description> descriptions = descriptionDao.findByDemande(demande);
		if (descriptions != null) {
			Response.status(201).entity(new ArrayList<Description>()).build();
		}
		return Response.status(201).entity(descriptions).build();
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Description description) {
		descriptionDao.save(description);
		return Response.status(201).build();
	}
}
