package com.aws.codestar.silkroute.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.Application;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.service.SecurityService;
import com.aws.codestar.silkroute.service.UserService;
import com.aws.codestar.silkroute.validator.UserValidator;

@RestController
@RequestMapping("users")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
    private UserService userService;
	
	



    @GetMapping("/profile")
    public ModelAndView getUserProfile (HttpSession session, String error, @ModelAttribute("user") User user, BindingResult bindingResult) {
//        model.addAttribute("msg", "user request received for the id : " + id);
//        LOGGER.info(model.toString());
    	user = (User) session.getAttribute("user");
    	ModelAndView mav = new ModelAndView("profile");
        if (error != null)
            mav.addObject("error", "Error loading profile");
   	
        if (bindingResult.hasErrors()) { //error return to registration
            mav.setViewName("index");
        	return mav;
        }
   	
//    	User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	mav.addObject("user", user);
    		return mav;
 	
       
    }
    
   
    @GetMapping("all")
    public ModelAndView nonAdminGetAllUsers() {
    	ModelAndView mav = new ModelAndView("all-users");
    	
    	return mav;
    }
    
   
}
