package org.foo.web;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import org.foo.domain.User;
import org.foo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value = "/")
public class UserController {
	
	@Inject @Named ("userService")
	private UserService userService;
	
	private Long id = 1L;

	private static final Logger logger = LoggerFactory.getLogger (UserController.class);

	@RequestMapping (value = "/add", method = RequestMethod.GET)
//	@Transactional (propagation = Propagation.REQUIRED)
	public String addUser (Locale locale, Model model) 
	{
		logger.debug ("Adding sample user");
		
		User user = new User (id);
		user.setFirst ("Sample");
		user.setLast ("User" + id);
		
		id++;
		
		model.addAttribute ("user", user);
		model.addAttribute ("action", "added");
		
		userService.addUser (user);
		
		return "index";
	}

	@RequestMapping (value = "/get", method = RequestMethod.GET)
//	@Transactional (readOnly = true, propagation = Propagation.REQUIRED)
	public String getUser (Locale locale, Model model) 
	{
		logger.debug ("Getting cached user");
		
		List<User> users = userService.getAll();

		model.addAttribute ("action", "got");
		model.addAttribute ("user", users.get(0));
		
		return "index";
	}
}

