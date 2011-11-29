package org.foo.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.foo.domain.User;
import org.foo.persistence.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service ("userService")
public class UserServiceImpl implements UserService {
	
	@Inject @Named ("userDaoInMem")
	private UserDao userDao;

	private static final Logger logger = LoggerFactory.getLogger (UserServiceImpl.class);

	public void addUser (User user) 
	{
		logger.debug ("Adding user");
		userDao.addUser (user);
	}

	public User retrieveUser() 
	{
		logger.debug ("Retrieved user");
		return userDao.getUser();
	}

}
