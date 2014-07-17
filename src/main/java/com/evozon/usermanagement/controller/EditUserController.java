
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

import scala.annotation.meta.getter;

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
	public String editUserInformation(@ModelAttribute  User destUser,Model model, HttpServletRequest request) {
		
		HttpSession ses = request.getSession();
		String userName = (String) ses.getAttribute("userName");
		String password = (String) ses.getAttribute("password");
		
		destUser.setUserName(userName);
		destUser.setPassword(password);
	
		if( service.editUserInfo(destUser) ) {
			return "sucess";
		}
		else {
			model.addAttribute("destUser", destUser);
			model.addAttribute("no",0);
			return "edit";
		}		

	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String getChangePasswordForm() {

		return "changePassword";
		
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePasswordSubmit(Model model, @ModelAttribute User user, @RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String confirmPassword, HttpServletRequest request) {

		HttpSession ses = request.getSession();
		String userName = (String) ses.getAttribute("userName");
		user = service.findUserByUsername(userName);
		String page = "changePassword";
		
		if (service.changePassword(user, currentPassword, newPassword, confirmPassword)) {
			page = "sucess";
			model.addAttribute("isOk", 0);
		} else {
			model.addAttribute("fail", 0);
		}

		return page;

	}

}
