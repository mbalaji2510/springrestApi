package com.hexa.webapp.restapi.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.webapp.restapi.dao.UserDao;
import com.hexa.webapp.restapi.model.User;
import com.hexa.webapp.restapi.service.UserService;



@Service
@Transactional
public class UserServiceImpl implements UserService{
	
public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);	
@Autowired
UserDao userDao;
	@Override
	
	public void createUser(User user) {
	
		logger.info("started createUser" +user.getFirstName());
		
		userDao.createUser(user);
		
	}

	@Override
	public List<User> retriveAllUsrs() {
		
		return userDao.retriveAllUsrs();
	}

	@Override
	public void updateUser(User usr) {
		
		userDao.updateUser(usr);
	}

	@Override
	public User findUser(long id) {
		
		return userDao.findUser(id);
	}

	@Override
	public void removeUser(User user) {
		userDao.removeUser(user);
		
		
	}

}
