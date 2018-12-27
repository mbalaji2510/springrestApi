package com.hexa.webapp.SpringRestEx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hexa.webapp.restapi.SpringRestExApplication;
import com.hexa.webapp.restapi.model.User;
import com.hexa.webapp.restapi.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringRestExApplication.class) 
public class SpringRestExApplicationTests {
	
	@Autowired
	private UserService UserService;

	@Test
	public void createUser() {
		
		// test the create user persist
		
		User user = new User();
		user.setFirstName("Junit_TestCase");
		user.setLastName("0001");
		user.setDept("Test");
		user.setEmailId("Test@gmail.com");
		
		UserService.createUser(user);
		
		
	}

}

