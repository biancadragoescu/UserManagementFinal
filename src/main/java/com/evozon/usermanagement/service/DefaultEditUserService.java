package com.evozon.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.model.User;

public class DefaultEditUserService implements EditUserService{

	@Autowired	// declare a constructor
	private UserDAO dao;
	
	@Override
	public boolean successChangePassword(User user, String currentPassword,
			String newPassword, String confirmPassword) {
		
		if (!(user.getPassword().equals(currentPassword)) || !(currentPassword.equals(confirmPassword)))
			return false;
		
		return true;
	}

}
