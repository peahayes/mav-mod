package org.foo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

	private Long id;
	
	private String first;
	private String last;
	
	private static final Logger logger = LoggerFactory.getLogger (User.class);

	public User() {
		logger.debug ("Created a new user");
	}
	
	public User (Long id) {
		logger.debug ("Created a new user with id " + id);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		if (this == obj)
			return true;
		
		if (!obj.getClass().equals (this.getClass()))
			return false;
		
		User that = (User) obj;
		
		if ((this.id != null && this.id.equals (that.id)) &&
			(this.first != null && this.first.equals (that.first)) &&
			(this.last != null && this.last.equals (that.last)))
			return true;
		
		return false;
	}
}
