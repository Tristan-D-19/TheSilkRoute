package com.aws.codestar.silkroute.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.Application;
import com.aws.codestar.silkroute.DAO.*;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.service.SecurityService;
import com.aws.codestar.silkroute.service.UserService;
import com.aws.codestar.silkroute.validator.UserValidator;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private UserValidator userValidator;
    
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
	private SecurityService securityService;

    @Resource(name="authenticationManager")
    private AuthenticationManager authManager;
	
	
	public AuthController() {
		
		
	}

    @GetMapping({"/login", "/authenticate"})
    public ModelAndView login(String error, String logout) {
    	 ModelAndView mav = new ModelAndView("login");
    	 mav.addObject("user", new User());
        if (error != null)
            mav.addObject("error", "Your username and password is invalid.");

        if (logout != null)
        	 mav.addObject("message", "You have been logged out successfully.");

        return mav;
    }
	
    
	public ModelAndView authorize_user(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("market");
		mav.addObject(email);
		mav.addObject(password);
		
		return mav;
	}
	
	
	@PostMapping({"/registration", "/register"})
    public ModelAndView registration( @ModelAttribute("newUser") User newUser, BindingResult bindingResult) {
        userValidator.validate(newUser, bindingResult);
        
        ModelAndView reg = new ModelAndView("registration");
        ModelAndView home = new ModelAndView("user_home");
        ModelAndView login = new ModelAndView("login");	
        
        User userExists = userService.findUserByEmail(newUser.getEmail());
        log.trace("User value", newUser);
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        
        if (bindingResult.hasErrors()) { //error return to registration
            return reg;
        }
        
            userService.createUser(newUser);
            
            reg.addObject("successMessage", "User has been registered successfully");
            reg.addObject("user", new User());
            reg.setViewName("registration");
            if(securityService.autologin(newUser.getEmail(), newUser.getPassword()))
            return home;
            else
            	return login;
      

    }
	
	 @PostMapping("/login")
	    public ModelAndView loginUser(@ModelAttribute("user") User user, final HttpServletRequest request) {    	
		        
		 	UsernamePasswordAuthenticationToken authReq =
		            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		        Authentication auth = authManager.authenticate(authReq);
		       
		        SecurityContext sc = SecurityContextHolder.getContext();
		        sc.setAuthentication(auth);
		        HttpSession session = request.getSession(true);
		        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
		        session.setAttribute("user", user);
		 ModelAndView mav = new ModelAndView();
	    	

	    			mav.setViewName("user_home");

	    	return mav;
	    }
	 
	    @GetMapping({"registration", "register"})
	    
	    public ModelAndView registration(String error) {
			
	    	ModelAndView mav = new ModelAndView("registration");
	    	 mav.addObject("newUser", new User());
	         if (error != null)
	             mav.addObject("error", "Please check your credentials");
	    	
	    	
	    	return mav;
	    }
	   
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            HttpSession session = request.getSession();
	            session.removeAttribute("user");
	        }
	        return "redirect:/login?logout";
	    }  
}
