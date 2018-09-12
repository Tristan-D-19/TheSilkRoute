package com.aws.codestar.silkroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

	public IndexController() {
		
	}
	
	@RequestMapping("/")
public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
		}

}
