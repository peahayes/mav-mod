package org.foo.persistence;

import java.util.List;

import org.foo.domain.User;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository ("userDao")
public class UserDaoHibernate extends AbstractBaseDao implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger (UserDaoHibernate.class);

	/**
	 * Retrieves the entity object by primary key value
	 * @param id Primary key value of the object
	 * @return The User with unique identifier id
	 */
	public User getById (Long id)
	{
		logger.debug ("Starting to execute the getById method.");
		// Use Hibernate load() method if exception is needed to be thrown when object is not found. get() method returns null when the object is not found in either cache or in db.
		// If the class is mapped with a proxy, load() method may return an uninitialized proxy instead of the object, get() never returns a proxy. However, load() may not throw exception when object does not exist until the proxy object is accessed.
		return (User) getSession().get (User.class, id);
	}

	public void add (User user) 
	{
		logger.debug ("add is called.");
		getSession().save (user);
	}

	/**
	 * Retrieves all the distinct entities.
	 * @return All the persistent objects in the database specified by TEntity type argument
	 */
	@Transactional (readOnly=true)
	public List<User> getAll()
	{
		logger.debug("Starting to execute the getAll method.");
		return getCriteria (User.class).setResultTransformer (Criteria.DISTINCT_ROOT_ENTITY) //If eager fetching for child collection of parent is turned on then the parents will be duplicated in the object result set. Distinct result set transformer would prevent that.
				   .list();
	}
}
