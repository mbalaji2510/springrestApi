package com.hexa.webapp.restapi.service;

import java.util.List;

import com.hexa.webapp.restapi.model.User;


public interface UserService {
	
	void createUser(User usr);
	
	List<User> retriveAllUsrs();
	
	void updateUser(User user);
	
	User findUser (long id);
	
	void removeUser(User user);

	

}
