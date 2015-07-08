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
import com.hitema.dao.PaiementDao;
import com.hitema.dao.UserDao;
import com.hitema.model.Demande;
import com.hitema.model.Paiement;

@Component
@Path("/paiementDao")
public class PaiementRest {

	@Autowired
	private PaiementDao paiementDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	DemandeDao demandeDao;

	@GET
	@Produces("application/json")
	@Path("/findAllPaiements")
	public List<Paiement> findAllPaiements() {
		List<Paiement> paiements = paiementDao.findAll();
		return paiements;
	}

	@POST
	@Path("/findByDemande")
	@Consumes("application/json")
	@Produces("application/json")
	public Response findByDemande(Demande demande) {
		List<Paiement> paiements = paiementDao.findByDemande(demande);
		if (paiements != null) {
			Response.status(201).entity(new ArrayList<Paiement>()).build();
		}
		return Response.status(201).entity(paiements).build();
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Paiement paiement) {
		paiementDao.save(paiement);
		return Response.status(201).build();
	}
}
