package com.evozon.usermanagement.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evozon.usermanagement.service.EditUserService;

@Controller
public class EditUserController {
	
	@Autowired	//declare a constructor
	EditUserService service;
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String Save() {
		return "changePassword";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String loginSubmit(@RequestParam String userName, @RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String confirmPassword) {
	
		
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
				
		return "sucess";
	}
}
