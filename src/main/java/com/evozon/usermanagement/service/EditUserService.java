package com.evozon.usermanagement.service;

import com.evozon.usermanagement.model.User;

public interface EditUserService {

	public void editUserInfo(User user);
	public User findUserByUsername(String username);
	public boolean validatePassword(User user, String currentPass, String newPass, String confirmPass);
	public boolean changePassword(User user, String currentPass,String newPass, String confirmPass);

}
