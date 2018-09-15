package com.aws.codestar.silkroute.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.User;

@RequestMapping(value = "/admin")
@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

	

	@GetMapping(value = "/admin/home")
	public ModelAndView admninHome() {
		ModelAndView adminHome = new ModelAndView("admin-home");
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	     User user = userService.findUserByEmail(auth.getName());
//	        adminHome.addObject("userName", "Welcome " + user.getName() + " (" + user.getEmail() + ")");
//	        adminHome.addObject("adminMessage","Content Available Only for Users with Admin Role");
//	       
//	        return mav;
		return adminHome;
	}
	
	@GetMapping("/users")
	public ModelAndView adminGetUsers(){
	ModelAndView mav = new ModelAndView("admin-all-users");
		return mav;
	}
}
