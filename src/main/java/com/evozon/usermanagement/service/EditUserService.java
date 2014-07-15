package com.evozon.usermanagement.service;

import com.evozon.usermanagement.model.User;

public interface EditUserService {
	
	public boolean validatePassword(User user, String currentPass, String newPass, String confirmPass);
	public boolean changePassword(User user, String currentPass,String newPass, String confirmPass);
	
}
