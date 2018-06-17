package com.niit.eCartBackEnd.dao;

import java.util.List;

import com.niit.eCartBackEnd.model.User;

public interface UserDAO 
{
	
	public List<User> list();
	
	public User getUser(String id);
	
	public User validateUser(String id, String password);
	
	public boolean addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(String id);
}
