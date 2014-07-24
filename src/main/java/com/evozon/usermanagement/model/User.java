package com.evozon.usermanagement.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username")
	private String userName;
	@Column(name = "email")
	private String email;
	@Column(name = "birthday")
	private Date birthdate;
	@Column(name = "phone")
	private String phone;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "password")
	private String password;
	
	
	
	public User() {
	
	}
	
	



	public User(String userName, String email, Date date, String phone,
			String firstName, String lastName, String password, boolean isAdmin) {
		super();
		
		this.userName = userName;
		this.email = email;
		this.birthdate = date;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;

	}


	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return id + "," + userName + "," + email + "," + new SimpleDateFormat("dd/MM/yyyy").format(birthdate) + "," +
				phone + "," + firstName + "," + lastName + "," + password + "," + "\n";
	}
	
}
