package com.hexa.webapp.restapi.model;

public class Employee {
	
	private long id;
	private String firstname;
	private String lastName;
	private String dept;
	
	public Employee() {
		
	}
	
	public Employee(long id, String firstname, String lastName, String dept) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastName = lastName;
		this.dept = dept;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", dept=" + dept + "]";
	}
	
	
	

}
