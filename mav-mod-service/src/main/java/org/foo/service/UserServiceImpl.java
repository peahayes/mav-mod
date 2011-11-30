package org.foo.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.foo.domain.User;
import org.foo.persistence.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service ("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Inject @Named ("userDaoInMem") // @Named ("userDao")
	private UserDao userDao;

	private static final Logger logger = LoggerFactory.getLogger (UserServiceImpl.class);

//	@Transactional (propagation = Propagation.REQUIRED)
	public void addUser (User user) 
	{
		logger.debug ("Adding user");
		userDao.add (user);
	}

//	@Transactional (readOnly = true, propagation = Propagation.REQUIRED)
	public User retrieveUser (Long id) 
	{
		logger.debug ("Retrieved user");
		return userDao.getById (id);
	}
	
//	@Transactional (readOnly = true, propagation = Propagation.REQUIRED)
	public List<User> getAll()
	{
		logger.debug ("Retrieving all Users");
		return userDao.getAll();
	}

}
