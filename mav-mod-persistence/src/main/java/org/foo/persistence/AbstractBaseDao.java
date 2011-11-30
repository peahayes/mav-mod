package org.foo.persistence;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBaseDao {

	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger (AbstractBaseDao.class);

	protected Session getSession() 
	{
		logger.debug ("Current session object of Hibernate managed by Spring container is asked.");
		return sessionFactory.getCurrentSession();
	}
	
	@Inject @Named ("sessionFactory")
	protected void setSessionFactory(SessionFactory sessionFactory) 
	{
		logger.debug ("Hibernate session factory is injected by Spring.");
		this.sessionFactory = sessionFactory;
	}
	
	protected Criteria getCriteria (Class clazz)
	{
		logger.debug ("Creating the criteria object from Hibernate session.");
		return getSession().createCriteria (clazz);
	}

}
