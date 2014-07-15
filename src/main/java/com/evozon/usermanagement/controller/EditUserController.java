
package com.evozon.usermanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.service.EditUserService;

/**
 * @author alexandrabara
 *
 */

@Controller
public class EditUserController {

	@Autowired	
	EditUserService service;
	
	
	@RequestMapping(value = "/login/succes/edit", method = RequestMethod.GET)
	public String getEditForm( User userA,Model model) {
		User user = new User();
		//model.addAttribute("user",user);
		//System.out.println("email"+ userA.getEmail());
		return "edit";	
	}
	
	@RequestMapping(value = "/login/succes/edit", method = RequestMethod.POST)
	public String editUserInformation(@ModelAttribute  User user,Model model) {
		//String mail,birthday,phone,firstName,lastName;
		//mail = user.getEmail();
		//System.out.println(destinationUser.getEmail());
		//System.out.println(user.getUserName());
		//birthday = user.getBirthdate();
		//phone = user.getPhone();
		//firstName = user.getFirstName();
		//lastName = user.getLastName();
		//model.addAttribute("mail",mail);
		service.editUserInfo(user);
		return "edit";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String Save() {
		return "changePassword";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String loginSubmit(@RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String confirmPassword, HttpServletRequest request) {
	
		
		HttpSession ses = request.getSession();
		String userName = (String) ses.getAttribute("userName");
		String password = (String) ses.getAttribute("password");
		
		System.out.println(password);
		System.out.println(userName);
		System.out.println(currentPassword);
		System.out.println(newPassword);
		System.out.println(confirmPassword);
		
		String page = "login";
//		if( service.changePassword(user, currentPass, newPass, confirmPass) == true ) {
//			page="sucess";
//		} else {
//			model.addAttribute("fail", 0);
//		}
				
		//User user = new User("samuel", null, null, null, null, null, "samuel", false);
		return "sucess";
	}
	
}
