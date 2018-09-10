package com.aws.codestar.silkroute.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.aws.codestar.silkroute.service.*;

@Controller
@SessionAttributes("loggedIn")
public class IndexController {
	

		public IndexController() {
		
		}
		
		@GetMapping(value = "/")
		public ModelAndView indexController( ) {
			ModelAndView mav = new ModelAndView("index");
			
			return mav;
			
		}
		
		
		@GetMapping(value = "/home")
		public ModelAndView homeController( ) {
			ModelAndView mav = new ModelAndView("home");
			
			return mav;
			
		}
	}


