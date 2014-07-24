package com.evozon.usermanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.service.CreateAccountService;

@Controller
public class CreateAccountController {
	
	@Autowired
	CreateAccountService createAccountService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 dateFormat.setLenient(false);
	 webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }
	
	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	 public String newAccount(Model model) {
	  
	  User user=new User();
	  model.addAttribute("user",user);
	  
	  return "newAccount";
	 }
	
	
	@RequestMapping(value = "/newAccount", method = RequestMethod.POST)
	public String submitNewAccount(@ModelAttribute  User user, Model model){
		String errors = createAccountService.addUser(user);

		if ( errors.equals("") ) {
			model.addAttribute("successfulAccount", true);
			return "redirect:/login";
		} else {
			String[] parts = errors.split(",");
			model.addAttribute("errors",parts);
			model.addAttribute("fail",0);
			return "newAccount";
		}
	}
}
