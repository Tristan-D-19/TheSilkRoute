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
	
	



    @RequestMapping("{id}")
    public ModelAndView handleRequestById (@PathVariable("id") long id) {
//        model.addAttribute("msg", "user request received for the id : " + id);
//        LOGGER.info(model.toString());
    	ModelAndView mav = new ModelAndView("user-profile");
    	User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = userService.findUserById(id);
    	if(loggedInUser.getUserId() == id)
    		return mav;
    	else 
    	return new ModelAndView("unauthorized");
    			
    	
       
    }
    
   
    @GetMapping("all")
    public ModelAndView nonAdminGetAllUsers() {
    	ModelAndView mav = new ModelAndView("all-users");
    	
    	return mav;
    }
    
   
}
