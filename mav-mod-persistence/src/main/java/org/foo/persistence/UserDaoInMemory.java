package org.foo.persistence;

import org.foo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository ("userDaoInMem")
public class UserDaoInMemory implements UserDao {
	
	private User user;

	private static final Logger logger = LoggerFactory.getLogger (UserDaoInMemory.class);

	public User getUser() {
		logger.debug ("Returning user");
		return user;
	}

	public void addUser (User user) {
		logger.debug ("Adding user");
		this.user = user;
	}

}
