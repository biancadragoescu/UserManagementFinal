package com.evozon.usermanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evozon.usermanagement.model.User;
import com.evozon.usermanagement.service.EditUserService;

@Controller
public class EditUserController {

	@Autowired	
	EditUserService service;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 dateFormat.setLenient(false);
	 webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEditForm(Model model , HttpServletRequest request) {
		HttpSession ses = request.getSession();
		String userName = (String) ses.getAttribute("userName");
		User destUser = service.findUserByUsername(userName);
		
		model.addAttribute("destUser", destUser);
		
		return "edit";	
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUserInformation(@ModelAttribute User destUser, Model model, HttpServletRequest request) {
		
		HttpSession ses = request.getSession();
		String userName = (String) ses.getAttribute("userName");
		String password = (String) ses.getAttribute("password");
		
		destUser.setUserName(userName);
		destUser.setPassword(password);
		
		String page = "edit";
	
		String errors = service.editUserInfo(destUser);
		if( errors.equals("") ) {
			model.addAttribute("isOk", 1);
			page =  "redirect:/sucess";
		}
		else {
			String[] parts = errors.split(",");
			model.addAttribute("destUser", destUser);
			model.addAttribute("errors", parts);
			model.addAttribute("fail",0);
		}		
		
		return page;

	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String getChangePasswordForm() {
		return "changePassword";
		
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePasswordSubmit(@RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String confirmPassword,Model model, HttpServletRequest request) {

		HttpSession ses = request.getSession();
		String userName = (String) ses.getAttribute("userName");
		User user = service.findUserByUsername(userName);
		String page = "changePassword";
		String errors = service.changePassword(user, currentPassword, newPassword, confirmPassword);

		if (errors.equals("")) {
			model.addAttribute("isOk", 0);
			page = "redirect:/sucess";
		} else {
			model.addAttribute("fail", 0);
			model.addAttribute("errors", errors);
		}

		return page;

	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	 public String getResetPasswordForm(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "resetPassword";
	 }
	
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetPasswordSubmit(Model model, @RequestParam String email, @ModelAttribute User user){

		String page = "resetPassword";
		String errors = service.resetPassword(email);
		//System.out.println(email);

		if (errors.equals("")) {
			User userByEmail = service.findUserByEmail(email);
			page = "resetPasswordOk";
			model.addAttribute("newPassword", userByEmail.getPassword());
			model.addAttribute("newPassword", service.getParolaGenerata());
		} else {
			model.addAttribute("fail", 0);
			model.addAttribute("errors", errors);
		}

		return page;
	}


}
