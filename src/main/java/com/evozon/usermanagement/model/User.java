package com.evozon.usermanagement.model;


public class User {
	
	private static int ID;
	private String userName;
	private String email;
	private String birthdate;
	private String phone;
	private String firstName;
	private String lastName;
	private String password;
	private boolean isAdmin;
	
	public User() {
	
	}
	
	
	public User(String userName, String email, String simpleDateFormat, String phone,
			String firstName, String lastName, String password, boolean isAdmin) {
		super();
		User.ID++;
		this.userName = userName;
		this.email = email;
		this.birthdate = simpleDateFormat;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.isAdmin = isAdmin;
	}


	public int getID() {
		return ID;
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
		return ID + "," + userName + "," + email + "," + birthdate + "," +
				phone + "," + firstName + "," + lastName + "," + password + "," + isAdmin + "\n";
	}

	
}