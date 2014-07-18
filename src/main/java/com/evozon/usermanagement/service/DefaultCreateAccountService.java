package com.evozon.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.validator.Validator;

@Service
public class DefaultCreateAccountService implements CreateAccountService {
	
	@Autowired
	UserDAO uDAO;
	
	@Autowired
	Validator<User> validator;

	@Override
	public String addUser(User u) {

		String errors = validator.validate(u);
		if( errors.equals("")) {
			uDAO.addUser(u);
		} 
		
		return errors;
	}
}
