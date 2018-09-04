package com.aws.codestar.silkroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.DAO.*;

@Controller
@RequestMapping(value="/login", method= RequestMethod.POST )
public class LoginController {

	
	public LoginController() {
		
		
	}

	public ModelAndView authorize_user(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("Market");
		mav.addObject(email);
		mav.addObject(password);
		
		return mav;
	}
}
