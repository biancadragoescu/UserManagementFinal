package com.evozon.usermanagement.service;

import com.evozon.usermanagement.model.User;

public interface EditUserService {

	public void editUserInfo(User user);
	public User findUserByUsername(String username);
	
}
