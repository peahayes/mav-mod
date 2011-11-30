package org.foo.service;

import java.util.List;

import org.foo.domain.User;


public interface UserService {
	
	public void addUser (User user);
	
	public User retrieveUser (Long id);
	
	public List<User> getAll();

}
