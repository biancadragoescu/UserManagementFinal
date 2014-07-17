package com.evozon.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuccessPageController {
	
	@RequestMapping(value = "/sucess", method = RequestMethod.GET)
	public String requestSuccessPage(@RequestParam(required = false) Integer isOk, Model model){
		model.addAttribute("isOk", isOk);
		return "sucess";
	}
}
