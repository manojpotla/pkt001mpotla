package com.nirvana.parkingtomweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nirvana.parkingtomweb.beans.LoginBean;
import com.nirvana.parkingtomweb.service.LoginService;

@Controller

public class LoginController {
	
	@Autowired
	LoginService loginService;
	@RequestMapping("/home")
	public String showHomePage(Model model, @ModelAttribute("loginBean") @Validated
			LoginBean loginBean) {	
		String userName = loginBean.getUsername();
		String password = loginBean.getPassword();
		if(loginService.loginUser(loginBean)){
			model.addAttribute("userName", userName);
			return "home";

		}else{
			return "login";
		}
	}
}
