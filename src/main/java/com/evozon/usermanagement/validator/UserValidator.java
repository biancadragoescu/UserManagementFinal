package com.evozon.usermanagement.validator;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.evozon.usermanagement.model.User;

@Component
public class UserValidator implements Validator<User>{
	
	private StringBuffer errors = new StringBuffer();

	@Override
	public String validate(User user) {
		clearErrors();
		validateUserName(user.getUserName());
		validateEmail(user.getEmail());
		//validateBirthdate(user.getBirthdate());
		validatePhone(user.getPhone());
		validateSimpleField(user.getFirstName());
		validateSimpleField(user.getLastName());
		validateSimpleField(user.getPassword());
		return errors.toString();
	}
	
	private void clearErrors(){
		errors.setLength(0);
	}
	
	private void validateUserName(String userName) {
		if(userName.equals("")){
			errors.append("Username field cannot be empty\n");
		}
	}
	
	private void validateEmail(String email) {
		if(email.equals("")) {
			errors.append("Email field cannot be empty\n");
		} else {
			if(!email.contains("@")) {
				errors.append("Email should contain the @ symbol\n");
			}
		}
	}
	
	private void validateBirthdate(Date birthdate){
		Date currentTime = Calendar.getInstance().getTime();
		if(currentTime.compareTo(birthdate) < 0){
			errors.append("The chosen birthdate should be before today date\n");
		}
	}
	
	private void validatePhone(String phone){
		if(phone.equals("")){
			errors.append("The phone field should not be empty\n");
		} else {
			if(!phone.matches("[0-9]*")){
				errors.append("The phone field should not contain only digits (0-9)\n");
			}
		}
	}
	
	private void validateSimpleField(String field){
		if(field.equals("")){
			errors.append("There should not exist empty fields\n");
		}
	}
}
