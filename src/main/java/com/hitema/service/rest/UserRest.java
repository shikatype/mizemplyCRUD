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

import com.hitema.dao.UserDao;
import com.hitema.model.User;

@Component
@Path("/userDao")
public class UserRest {
	
	@Autowired
	private UserDao userDao; 
	
	@GET
	@Produces("application/json")
	@Path("/findAllUsers")
	public List<User> findAllUsers() {
		 List<User> users = userDao.findAll();	
		 return users;
	}
	
	@GET
	@Produces("application/json")
	@Path("/findByLogin/{login}")
	public User findByLogin(@PathParam("login") String login) {
		 User user = userDao.findByLogin(login);
		 if(user != null){
			 return user;
		 }
		 return new User(); 
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(User user) {
		userDao.save(user);
		return Response.status(201).build();
	}
	
}
