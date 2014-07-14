package com.evozon.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.UserDAO;

@Service
public class DefaultLoginService implements LoginService {
	@Autowired	// declare a constructor
	private UserDAO dao;
	private List<User> list;
	
	public boolean sucessLogin(User user) {
		boolean userFound= false;
		list= dao.getAllUsers();
			
		for(User dest : list ) {
			if( user.getUserName().equals(dest.getUserName()) && user.getPassword().equals(dest.getPassword()) ) {
				userFound = true;
				break;
			}
		}
		return userFound;
	}
}
