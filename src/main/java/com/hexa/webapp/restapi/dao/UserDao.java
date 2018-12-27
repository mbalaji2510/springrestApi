package com.hexa.webapp.restapi.dao;

import java.util.List;

import com.hexa.webapp.restapi.model.User;



public interface UserDao {

	void createUser(User usr);

	List<User> retriveAllUsrs();

	void updateUser(User usr);

	User findUser(long id);
	
	void removeUser(User usr);
}
