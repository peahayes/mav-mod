package org.foo.persistence;

import org.foo.domain.User;

public interface UserDao {

	public User getUser();
	
	public void addUser (User user);
}
