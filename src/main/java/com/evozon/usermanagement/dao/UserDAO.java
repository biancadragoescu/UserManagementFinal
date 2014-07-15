package com.evozon.usermanagement.dao;

import java.util.List;

import com.evozon.usermanagement.model.User;

public interface UserDAO {

	public List<User> getAllUsers();
	
	public void writeUsersToFile(List<User> usersList);
	
	public void addUser(User u);
}
