package com.hexa.webapp.restapi.service;

import java.util.List;

import com.hexa.webapp.restapi.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee emp);
	List<Employee> findAllEmployees();
}
