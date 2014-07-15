package com.evozon.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.utils.ListUtils;

@Service
public class DefaultEditUserService implements EditUserService{

	@Autowired	// declare a constructor
	private UserDAO dao;
	private ListUtils listUtils;
	private List<User> list;

	@Override
	public boolean validatePassword(User user, String currentPass,String newPass, String confirmPass) {
		
		if (!(user.getPassword().equals(currentPass)) || !(currentPass.equals(confirmPass)))
			return false;
		
		return true;
	}

	@Override
	public boolean changePassword(User user, String currentPass,String newPass, String confirmPass) {
		
		List<User> list = dao.getAllUsers();
		int index = listUtils.findUserIndex(user, list);
		boolean isOk = true;
		
		if (index != -1){
			if (validatePassword(user, currentPass, newPass, confirmPass)) {
				user.setPassword(newPass);
				list.set(index, user);
				dao.updateUsers(list);
			} else {
				isOk = false;
			}
		} else  {
			isOk = false;
		}
		
		return isOk;
	}
	
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
