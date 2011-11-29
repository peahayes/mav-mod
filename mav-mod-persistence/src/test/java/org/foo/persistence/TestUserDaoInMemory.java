package org.foo.persistence;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.foo.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserDaoInMemory {
	
	private User user = new User (1L);
	
	private UserDaoInMemory userDao = new UserDaoInMemory();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAndGetUser() 
	{
		assertNull (userDao.getUser());
		
		userDao.addUser (user);

		assertEquals (user, userDao.getUser());
	}

}
