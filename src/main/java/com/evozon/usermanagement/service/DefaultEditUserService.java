package com.evozon.usermanagement.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
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

	@Autowired
	private ListUtils listUtils;

	private List<User> list;

	
	//verifica daca parola introdusa coincide cu cea a utilizatorului curent
	public boolean validateCurrentPassword(User user, String currentPass) {
		if (user.getPassword().equals(currentPass)) {
			return true;
		}
		return false;
	}
	
	//verifica compatibilitatea newPass, confirmPass
	public boolean validatePasswordsMatching(String newPass, String confirmPass) {
		if (newPass.equals(confirmPass)) {
			return true;
		}
		return false;
	}
	
	//verifica daca avem campuri goale
	public boolean validateEmptyPasswords(String currentPass, String newPass, String confirmPass) {
		if (currentPass.equals("") || newPass.equals("") || confirmPass.equals("")) {
			return false;
		}
		return true;
	}

	@Override
	//returneaza un string gol daca validarile sunt ok
	//returneaza un string cu erorile aferente greselilor	
	
	public String changePassword(User user, String currentPass, String newPass, String confirmPass) {

		List<User> list = dao.getAllUsers();
		int index = listUtils.findUserIndex(user, list);
		String errors = "";
		
		if (index != -1){
			if (!(validateEmptyPasswords(currentPass, newPass, confirmPass))) {
				errors += "You must complete all the fields!" + "\n";
			} else {
				if (!(validateCurrentPassword(user, currentPass))) {
					errors += "Invalid current password!" + "\n";
				}
				if (!(validatePasswordsMatching(newPass, confirmPass))) {
					errors += "New password and confirm password do not match!" + "\n";
				}
			}
		} else  {
			errors += "User cannot be found!" + "\n";
		}
		
		if (errors.equals("")) {
			user.setPassword(newPass);
		    list.set(index, user);
		    dao.updateUsers(list);
		}
		return errors;
	}

	@Override
	public boolean editUserInfo(User user) {

		list = dao.getAllUsers();
		if((validateFields(user) && validateDate(user.getBirthdate()))) {
			for(User dest : list ) {
				if( user.getUserName().equals(dest.getUserName())) {
					dest.setEmail(user.getEmail());
					dest.setBirthdate(user.getBirthdate());
					dest.setPhone(user.getPhone());
					dest.setFirstName(user.getFirstName());
					dest.setLastName(user.getLastName());
				}
			}
			
			dao.updateUsers(list);
			return true;
		}
		return false;
		
	}

	@Override
	public User findUserByUsername(String username) {
		
		list = dao.getAllUsers();

		for(User dest : list ) {
			if(username.equals(dest.getUserName())) {
				return dest;

			}
		}
		return null;
	}

	@Override
	public boolean validateDate(Date birthdateOfUser) {
		
		Date date = new Date();
		if(birthdateOfUser == null || birthdateOfUser.after(date)) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean validateFields(User srcUser) {
		
		if((srcUser.getEmail().equals("") || srcUser.getFirstName().equals("")
				|| srcUser.getLastName().equals("") || srcUser.getPhone().equals(""))){
			return false;
		}
		
		return true;
	}

	@Override
	public User findUserByEmail(String email) {
		list = dao.getAllUsers();

		for(User dest : list ) {
			if(email.equals(dest.getEmail())) {
				return dest;

			}
		}
		return null;
	}

	//verifica daca un camp este gol
	public boolean validateEmptyField(String field){
		if (field.equals("")) {
			return false;
		}
		return true;
	}
		
	//verifica daca email-ul contine @ sau nu
	//returneaza true daca totul e in regulsa si fals altfel
	public boolean validateEmail(String email) {
		if (email.contains("@")) {
			return true;
		}
		return false;
	}
		
	public String generatePassword() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(64, random).toString(32);
	}

	//returneaza un string gol daca validarile sunt ok
	//returneaza un string cu erorile aferente greselilor	
	//daca e ok reseteaza parola
	@Override
	public String resetPassword(String email) {
		List<User> list = dao.getAllUsers();
		String errors = "";
		User user = findUserByEmail(email);
		
		if (!validateEmptyField(email)) {
			errors += "Complete the email field!";
		} else {
			if (!validateEmail(email)) {
				errors += "The email must contain @!";
			} else {	
				if (user == null) {
					errors += "This email cannot be found!";	
				}
			}
			
			if (errors.equals("")) {
				int index = listUtils.findUserIndex(user, list);
				user.setPassword(generatePassword());
				list.set(index, user);
				dao.updateUsers(list);
			}
		}
		return errors; 
	}

}
