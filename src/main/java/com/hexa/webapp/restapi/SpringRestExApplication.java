package com.hexa.webapp.restapi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*ComponentScan(basePackages = {
        "com.hexa.webapp.restapi.dao","com.hexa.webapp.restapi.dao.impl"
    })*/
public class SpringRestExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExApplication.class, args);
	}
	
	

}

