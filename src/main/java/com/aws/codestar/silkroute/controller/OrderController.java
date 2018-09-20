package com.aws.codestar.silkroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.Order;

@Controller
public class OrderController {

	
	@GetMapping("/cart")
	public ModelAndView getCart() {
		ModelAndView mav = new ModelAndView("cart");
		
		return mav;
	}
	
	@GetMapping("/checkout")
	public ModelAndView getCheckout() {
		ModelAndView mav = new ModelAndView("checkout");
			
		return mav;
	}
	
	@PostMapping("/checkout")
	public ModelAndView postCheckout(@ModelAttribute("order") Order order) {
		ModelAndView mav = new ModelAndView("orderSummary");
		mav.addObject("order", order);
	return mav;
	}
}
