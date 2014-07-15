package com.evozon.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.dao.file.FileDAO;
import com.evozon.usermanagement.model.User;

@Service
public class DefaultCreateAccountService implements CreateAccountService {
	
	@Autowired
	UserDAO uDAO;

	@Override
	public void addUser(User u) {
		uDAO.addUser(u);
	}
	
}
