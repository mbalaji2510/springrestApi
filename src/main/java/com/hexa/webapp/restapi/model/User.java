package com.hexa.webapp.restapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="user")
public class User implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
		
	}

/*public User(long id, String firstName, String lastName, String dept, String emailId) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dept = dept;
	this.emailId = emailId;
}
*/


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@Column(name = "firstname")
private String firstName;

@Column(name = "lastname")
private String lastName;

@Column(name = "dept")
private String dept;

@Column(name = "email")
private String emailId;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
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

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept + ", emailId="
			+ emailId + "]";
}



}
