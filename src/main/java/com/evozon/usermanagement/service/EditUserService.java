package com.evozon.usermanagement.service;

import java.util.Date;

import com.evozon.usermanagement.model.User;

public interface EditUserService {

	public boolean editUserInfo(User user);
	public User findUserByUsername(String username);
	public boolean validateDate(Date dateSrc);
	public boolean validateFields(User srcUser);
	public boolean validatePassword(User user, String currentPass, String newPass, String confirmPass);
	public boolean changePassword(User user, String currentPass,String newPass, String confirmPass);

}
