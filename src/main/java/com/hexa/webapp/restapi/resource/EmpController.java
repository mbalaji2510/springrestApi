package com.hexa.webapp.restapi.resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hexa.webapp.restapi.model.Employee;
import com.hexa.webapp.restapi.service.EmployeeService;

import java.util.List;

import org.slf4j.Logger;

@RestController
@RequestMapping("/employees")
public class EmpController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	// save the emplooyee data
	@RequestMapping(value="/emp/", method=RequestMethod.POST )
	public ResponseEntity<?> createEmployee (@RequestBody Employee emp , UriComponentsBuilder ucBuilder) {
		logger.info("Creating Empl : {}", emp);
		employeeService.saveEmployee(emp);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("//employees/emp/{id}").buildAndExpand(emp.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/emp/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllUsers() {
        List<Employee> users = employeeService.findAllEmployees();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Employee>>(users, HttpStatus.OK);
    }
 

}
