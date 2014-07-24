package com.evozon.usermanagement.dao;

import java.util.List;

import com.evozon.usermanagement.model.User;

public interface UserDAO {

	public List<User> getAllUsers();
	public void updateUsers(List<User> usersList,int index);
	public void addUser(User u);
  
}
