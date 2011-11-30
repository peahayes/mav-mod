package org.foo.persistence;

import java.util.ArrayList;
import java.util.List;

import org.foo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository ("userDaoInMem")
public class UserDaoInMemory implements UserDao {
	
	private User user;

	private static final Logger logger = LoggerFactory.getLogger (UserDaoInMemory.class);

	public User getById (Long id) 
	{
		logger.debug ("Returning user");
		return user;
	}

	public void add (User user) {
		logger.debug ("Adding user");
		this.user = user;
	}

	public List<User> getAll() 
	{
		List<User> users = new ArrayList<User>();
		users.add (user);
		return users;
	}

}
