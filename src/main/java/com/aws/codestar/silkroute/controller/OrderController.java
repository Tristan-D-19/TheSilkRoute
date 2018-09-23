package com.aws.codestar.silkroute.controller;

import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.Order;
import com.aws.codestar.silkroute.models.OrderDetail;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.repositories.ProductRepository;
import com.aws.codestar.silkroute.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	ProductService productService;
	
	
	
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
