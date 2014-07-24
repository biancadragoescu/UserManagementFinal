package com.evozon.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.model.User;

@Service
public class DefaultLoginService implements LoginService {
	@Autowired
	private UserDAO dao;
	private List<User> list;
	
//	public boolean sucessLogin(User user) {
//		boolean userFound= false;
//		list= dao.getAllUsers();
//			
//		for(User dest : list ) {
//			if( user.getUserName().equals(dest.getUserName()) && user.getPassword().equals(dest.getPassword()) ) {
//				userFound = true;
//				break;
//			}
//		}
//		return userFound;
//	}
	
	public boolean sucessLogin(User user) {
		boolean userFound= false;
		list= dao.getAllUsers();
			
		for(User dest : list ) {
			if( user.getUserName().equals(dest.getUserName()) && BCrypt.checkpw(user.getPassword(), dest.getPassword())) {
				userFound = true;
				break;
			}
		}
		return userFound;
	}
}
