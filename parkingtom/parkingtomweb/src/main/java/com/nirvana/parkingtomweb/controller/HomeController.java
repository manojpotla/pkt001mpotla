package com.nirvana.parkingtomweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nirvana.parkingtomweb.beans.LoginBean;

@Controller
public class HomeController {

	String message = "Welcome to Parking Tom ";

	@RequestMapping("/login")
	public String showLoginPage(Model model, @ModelAttribute("loginBean") @Validated
			LoginBean loginBean) {

		model.addAttribute("message", message);
		
		return "login";
	}

}
