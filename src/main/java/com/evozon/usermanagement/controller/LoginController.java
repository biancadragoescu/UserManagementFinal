package com.evozon.usermanagement.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.service.EditUserService;
import com.evozon.usermanagement.service.LoginService;

@Controller	//adauga un bean in spring container
@SessionAttributes({"userName","password"})
public class LoginController {

	@Autowired	//declare a constructor
	LoginService service;
	
	@Autowired
	EditUserService editService;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(@RequestParam(required = false) Boolean successfulAccount,Locale locale, Model model) {

		User user = new User();
		model.addAttribute("user", user );
		model.addAttribute("successfulAccount", successfulAccount);

		return "login";
	}



	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute  User user, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("password", user.getPassword());

		String page = "login";

		if( service.sucessLogin(user)) {
			model.asMap().clear();
			page="redirect:/sucess";		

		} else {
			model.addAttribute("fail", 0);
		}

		return page;
	}
}
