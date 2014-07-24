package com.evozon.usermanagement.service;

import com.evozon.usermanagement.model.User;

public interface EditUserService {

	public String editUserInfo(User user);
	public User findUserByUsername(String username);
	public String changePassword(User user, String currentPass,String newPass, String confirmPass);
	public User findUserByEmail(String email);
	public String resetPassword(String email);
	public String getParolaGenerata();

}
