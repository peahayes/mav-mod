package org.foo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.foo.domain.User;
import org.foo.persistence.UserDaoInMemory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith (MockitoJUnitRunner.class)
public class TestUserService {
	
	private User user = new User();
	
	@Mock UserDaoInMemory userDao;
	
	@InjectMocks
	private UserServiceImpl userService = new UserServiceImpl();

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAndRetrieveUser() {
		
		assertNull (userService.retrieveUser());
		
		when (userDao.getUser()).thenReturn (user);
		
		userService.addUser (user);

		assertNotNull (userService.retrieveUser());
	}
}
