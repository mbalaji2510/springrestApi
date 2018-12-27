package com.hexa.webapp.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.hexa.webapp.restapi.model.Employee;
import com.hexa.webapp.restapi.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	 private static final AtomicLong counter = new AtomicLong();
	 
	 private static List<Employee> employees ;
	 
	 static {
		 employees = populateDummyEmp();
	 }

	@Override
	public void saveEmployee(Employee emp) {
		emp.setId(counter.incrementAndGet());
		employees.add(emp);
		
	}

	private static List<Employee> populateDummyEmp() {

		List<Employee> emps = new ArrayList<Employee>();
		// adding dummy employees here
		emps.add(new Employee(counter.incrementAndGet(), "Balu", "M", "dev"));
		emps.add(new Employee(counter.incrementAndGet(), "Deepak", "M", "QA"));
		emps.add(new Employee(counter.incrementAndGet(), "Test1", "M", "QA"));
		emps.add(new Employee(counter.incrementAndGet(), "Test2", "M", "QA"));
		return emps;
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}
	 
	
	 
	 

}
