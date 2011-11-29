package org.foo;

import static org.junit.Assert.*;

import org.foo.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUser {
	
	private User user = new User();
	private User user2 = new User();
	private User user3 = new User();

	@Before
	public void setUp() throws Exception {
		
		user.setId (1L);
		user.setFirst ("Sandy");
		user.setLast ("Smith");

		user2.setId (2L);
		user2.setFirst ("Joe Bob");
		user2.setLast ("Smith");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEqualsObject() 
	{
		assertFalse (user.equals (user2));
		assertTrue (user.equals (user));
		assertFalse (user.equals (3L));
		assertFalse (user3.equals (user));
	}

}
