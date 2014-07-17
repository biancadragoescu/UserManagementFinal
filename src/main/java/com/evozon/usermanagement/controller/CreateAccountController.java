package com.evozon.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.service.CreateAccountService;

public class CreateAccountController {
	
	@Autowired
	CreateAccountService createAccountService;
	
	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	 public String newAccount(Model model) {
	  
	  User user=new User();
	  model.addAttribute("user",user);
	  
	  return "newAccount";
	 }
	
	@RequestMapping(value = "/newAccount", method = RequestMethod.POST)
	public String submitNewAccount(@ModelAttribute  User user, Model model){
		createAccountService.addUser(user);
		return "emailConfirmation";
	}
	
	
}
