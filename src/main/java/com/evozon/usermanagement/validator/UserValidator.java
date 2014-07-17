package com.evozon.usermanagement.validator;

import java.util.Calendar;
import java.util.Date;
import com.evozon.usermanagement.model.User;

public class UserValidator implements Validator<User> {

	private StringBuffer errors;

	@Override
	public String validate(User user) {
		clearErrors();
		if(!validateEmptyField(user.getUserName()).equals("") || !validateEmptyField(user.getEmail()).equals("")
			|| !validateEmptyField(user.getPhone()).equals("") || !validateEmptyField(user.getFirstName()).equals("")
			|| !validateEmptyField(user.getLastName()).equals("") || !validateEmptyField(user.getPassword()).equals("")
			|| user.getBirthdate() != null)
				validateEmail(user.getEmail());
				validateBirthdate(user.getBirthdate());
				validatePhone(user.getPhone());
		return errors.toString();
	}

	private void clearErrors() {
		errors.setLength(0);
	}

	private void validateEmail(String email) {
		if (!email.contains("@")) {
			errors.append("Email should contain the @ symbol\n");
		}
	}

	private void validateBirthdate(Date birthdate) {
		Date currentTime = Calendar.getInstance().getTime();
		if (currentTime.compareTo(birthdate) < 0) {
			errors.append("The chosen birthdate should be before today date\n");
		}
	}

	private void validatePhone(String phone) {

		if (!phone.matches("[0-9]*")) {
			errors.append("The phone field should not contain only digits (0-9)\n");
		}
	}

	private String validateEmptyField(String field) {
		if (field.equals("")) {
			errors.append("There should not exist empty fields\n");
			return "";
		}
		
		return field;
	}
}
