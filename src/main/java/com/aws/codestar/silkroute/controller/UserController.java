package com.aws.codestar.silkroute.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.service.SecurityService;
import com.aws.codestar.silkroute.service.UserService;
import com.aws.codestar.silkroute.validator.UserValidator;

@RestController
public class UserController {

	@Autowired
    private UserService userService;

//    @Autowired
//    private SecurityService securityService;
    
    @Autowired
    private UserValidator userValidator;
    
    
    @GetMapping("/registration")
    public ModelAndView registration() {
		
    	ModelAndView mav = new ModelAndView("registration");
    	
    	mav.addObject("newUser", new User()); //add empty user to form 
    	
    	return mav;
    }
    
    @PostMapping("/registration")
    public ModelAndView registration(@Valid @ModelAttribute("user") User newUser, BindingResult bindingResult) {
        userValidator.validate(newUser, bindingResult);

        ModelAndView reg = new ModelAndView("registration");
        ModelAndView home = new ModelAndView("home");
        
        User userExists = userService.findUserByEmail(newUser.getEmail());
        
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        
        if (bindingResult.hasErrors()) { //error return to registration
            return reg;
        }

        else {
            userService.createUser(newUser);
            reg.addObject("successMessage", "User has been registered successfully");
            reg.addObject("user", new User());
            reg.setViewName("registration");
            return reg;
        }   

        //login user
//        securityService.autologin(newUser.getEmail(), newUser.getPasswordConfirm());

//        return home;
    }
    
    @GetMapping("/login")
    public ModelAndView login(String error, String logout) {
    	 ModelAndView mav = new ModelAndView("login");
    	 mav.addObject("user", new User());
        if (error != null)
            mav.addObject("error", "Your username and password is invalid.");

        if (logout != null)
        	 mav.addObject("message", "You have been logged out successfully.");

        return mav;
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping(value = {"/silk/home"})
    public ModelAndView home( ) {
    	ModelAndView home = new ModelAndView("home");
        return home;
    }
    
}
