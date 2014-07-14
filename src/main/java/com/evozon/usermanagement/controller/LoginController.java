package com.evozon.usermanagement.controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.evozon.usermanagement.service.LoginService;
import com.evozon.usermanagement.service.User;

@Controller	//adauga un bean in spring container
public class LoginController {
	
	@Autowired	//declare a constructor
	LoginService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(Locale locale, Model model) {
		
		User user=new User();
		model.addAttribute("user", user );
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute  User user,Model model) {
		
		String page="login";
		if( service.sucessLogin(user) == true ) {
			page="sucess";
		} else {
			model.addAttribute("fail", 0);
		}
				
		return page;
	}
	
}
