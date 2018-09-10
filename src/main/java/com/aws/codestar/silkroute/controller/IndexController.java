package com.aws.codestar.silkroute.controller;
import com.aws.codestar.silkroute.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;


@Controller
public class IndexController {

	
	public IndexController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping( value="/", method = RequestMethod.GET)
	   public String home() {
	      
		ModelAndView mav = new ModelAndView("index");
		
		return "index";
//		return mav;
	   }

}
