package com.evozon.usermanagement.service;

import com.evozon.usermanagement.model.User;

public interface EditUserService {
	public boolean successChangePassword(User user, String currentPassword, String newPassword, String confirmPassword);
}
