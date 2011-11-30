package org.foo.persistence;

import java.util.List;

import org.foo.domain.User;

public interface UserDao {

	public User getById (Long id);
	
	public void add (User user);
	
	public List<User> getAll();
}
