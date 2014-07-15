/**
 * 
 */
package com.evozon.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.dao.file.FileDAO;
import com.evozon.usermanagement.model.User;

/**
 * @author alexandrabara
 *
 */

@Service
public class DefaultUserService implements EditUserService {

	@Autowired
	private UserDAO dao;
	private List<User> list;

	@Override
	public void editUserInfo(User user) {
		
		list = dao.getAllUsers();

		for(User dest : list ) {
			if( user.getUserName().equals(dest.getUserName())) {
				dest.setEmail(user.getEmail());
				dest.setBirthdate(user.getBirthdate());
				dest.setPhone(user.getPhone());
				dest.setFirstName(user.getFirstName());
				dest.setLastName(user.getLastName());
			}
		}
		
		
	}

	@Override
	public User findUserByUsername(String username) {
		list = dao.getAllUsers();
		User user = new User();
		for(User dest : list ) {
			if(username.equals(dest.getUserName())) {
				user = dest;
				break;
			}
		}
		return user;
	}

}
