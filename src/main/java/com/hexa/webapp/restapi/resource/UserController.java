package com.hexa.webapp.restapi.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.hexa.webapp.restapi.model.User;
import com.hexa.webapp.restapi.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	// save the User data
		@RequestMapping(value="/user/", method=RequestMethod.POST )
		public ResponseEntity<?> createUser (@RequestBody User user , UriComponentsBuilder ucBuilder) {
			logger.info("Creating User ::createUser {}", user);
			userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("//api/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
			
		}
		
		// Retrive the all user details 
		@RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<User>> listAllUsers() {
	        List<User> users = userService.retriveAllUsrs();
	        logger.info("Creating User ::createUser {}", users.size());
	        if (users.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	    }
		
		// Update the user details 
		
		@RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateUser(@PathVariable("id") long id,@RequestBody User user) {
			
			User currentUser = userService.findUser(id);
			
			if (currentUser == null) {
				logger.info("updateUser ::user with id not availabel {}", id);
				
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			
			currentUser.setFirstName(user.getFirstName());
			currentUser.setLastName(user.getLastName());
			currentUser.setDept(user.getDept());
			currentUser.setEmailId(user.getEmailId());
			userService.updateUser(currentUser);
			return new ResponseEntity<User>(currentUser, HttpStatus.OK);
			
		}
			
		@RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> removeUser(@PathVariable("id") long id) {
			User user = userService.findUser(id);
			if (user == null) {
	            logger.error("Unable to delete. User with id {} not found.", id);
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
			userService.removeUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
			
		
		}
			
		@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
			User user = userService.findUser(id);
			if (user == null) {
	            logger.error("Unable to delete. User with id {} not found.", id);
	            return new ResponseEntity(HttpStatus.NOT_FOUND);
	        }
			
			return new ResponseEntity<User>(user, HttpStatus.OK);
			
		
		}	
		
}

