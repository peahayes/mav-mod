package org.foo.web;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.foo.domain.User;
import org.foo.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

@RunWith (MockitoJUnitRunner.class)
public class TestUserController {
	
	private User user = new User (1L);
	
	@Mock Model model;
	@Mock UserService userService;
	
	@InjectMocks UserController controller = new UserController();

	@Before
	public void setUp() throws Exception {
		
		user.setFirst ("Test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUser() 
	{
		doNothing().when (userService).addUser (eq (user));
		
		String path = controller.addUser (Locale.getDefault(), model);
		
		assertEquals ("index", path);
		
		verify (model).addAttribute (eq ("user"), isA (User.class));
		verify (model).addAttribute (eq ("action"), eq ("added"));
	}

	@Test
	public void testGetUser() 
	{
		when (userService.retrieveUser()).thenReturn (user);
		
		String path = controller.getUser (Locale.getDefault(), model);
		
		assertEquals ("index", path);
		
		verify (model).addAttribute (eq ("user"), isA (User.class));
		verify (model).addAttribute (eq ("action"), eq ("got"));
	}

}
