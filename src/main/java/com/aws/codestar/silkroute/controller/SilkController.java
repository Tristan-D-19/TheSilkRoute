package com.aws.codestar.silkroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.service.OrderService;
import com.aws.codestar.silkroute.service.ProductService;

@RestController
@RequestMapping("/silk")
public class SilkController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/home")
	public ModelAndView silkHome() {
		ModelAndView mav = new ModelAndView("index");
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("loggedInUser",loggedInUser);
		return mav;
	}
	
	
	@GetMapping("/market/buy")
	public ModelAndView silkMarketBuy() {
		ModelAndView mav = new ModelAndView("market");
		
		return mav;
	}
	

	@GetMapping("/market/sell")
	public ModelAndView silkMarketSell() {
		ModelAndView mav = new ModelAndView("silk-market-sell");
		
		return mav;
	}
	

	@GetMapping("/market/trade")
	public ModelAndView silkMarketTrade() {
		ModelAndView mav = new ModelAndView("silk-market-trade");
		
		return mav;
	}
}
