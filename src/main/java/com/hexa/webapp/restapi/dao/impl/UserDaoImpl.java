package com.hexa.webapp.restapi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import com.hexa.webapp.restapi.dao.UserDao;
import com.hexa.webapp.restapi.model.User;




@Repository
public class UserDaoImpl implements UserDao {
	
	public static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	
	public void createUser(User user) {
		em.persist(user);
		em.flush();
		
		
	}

	@Override
	public List<User> retriveAllUsrs() {
		logger.info("retriveAllUsrs:: Started");
		Query query = em.createQuery("select  u  from User u");
		List<User> usrList = query.getResultList();
		logger.info("retriveAllUsrs:: End "+usrList.size());
		return usrList;
	}

	@Override
	public void updateUser(User user) {
		
		logger.info("updateUser:: Started");
		em.merge(user);
		logger.info("updateUserdetails:: successfully"+user.getId());
		
	}

	@Override
	public User findUser(long id) {
		User user = em.find(User.class, id);
		return user;
	}

	@Override
	public void removeUser(User user) {
		em.remove(user);
		
	}
	
	

}
