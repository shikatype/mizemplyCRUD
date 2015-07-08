package com.hitema.dao;

import java.util.List;

import com.hitema.model.User;

public interface UserDao {
	
	public void save(User user);
	
	public List<User> findAll();
	
	public User findByLogin(String login);
	
	public User findById(int idUser);
	
	
}
