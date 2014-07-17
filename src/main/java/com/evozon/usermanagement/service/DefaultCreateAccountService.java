package com.evozon.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.evozon.usermanagement.dao.file.FileDAO;
import com.evozon.usermanagement.model.User;

public class DefaultCreateAccountService implements CreateAccountService {
	
	@Autowired
	FileDAO fDAO;

	@Override
	public void addUser(User u) {
		fDAO.addUser(u);
	}
	
	
}
