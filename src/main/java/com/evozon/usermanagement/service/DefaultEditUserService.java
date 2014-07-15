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

}
