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
	
	@Autowired
	EditUserService editUserService;

	@Override
	public String addUser(User user) {
		String errors;
		String userName = user.getUserName();
		if(editUserService.findUserByUsername(userName) == null) {
			errors = validator.validate(user);
			if( errors.equals("")) {
				uDAO.addUser(user);
			}
		} else {
			System.out.println("null");
			errors = "The given username is already in use,";
		}
		
		return errors;
	}
}
