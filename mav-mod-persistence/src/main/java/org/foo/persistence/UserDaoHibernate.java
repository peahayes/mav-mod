package org.foo.persistence;

import org.foo.domain.User;
import org.springframework.stereotype.Repository;

@Repository ("userDao")
public class UserDaoHibernate implements UserDao {

	public User getUser() {
		return null;
	}

	public void addUser(User user) {
		
	}

}
