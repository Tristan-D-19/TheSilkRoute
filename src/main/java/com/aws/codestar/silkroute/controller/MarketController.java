package com.aws.codestar.silkroute.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.OrderDetail;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.repositories.ProductRepository;
import com.aws.codestar.silkroute.service.ProductService;

@RestController
@RequestMapping("/market")
public class MarketController {

	@Autowired
	private ProductService prodService;
	
	@Autowired 
	private ProductRepository prodRepo;
	
	@GetMapping
	public ModelAndView market() {
		
		String txtKeyword = "";
		
		ModelAndView mav = new ModelAndView("market");
		List<Product> products = prodRepo.findAll();
		mav.addObject("txtKeyword", txtKeyword);
		mav.addObject("products", products);
		
		return mav;
		
	}
	
	@PostMapping("/buy")
	public ModelAndView addtoCart(HttpSession session) {
		HashSet<OrderDetail> cart= (HashSet<OrderDetail>) session.getAttribute("cart");
		String txtKeyword = "";
		
		ModelAndView mav = new ModelAndView("market");
		List<Product> products = prodRepo.findAll();
		mav.addObject("txtKeyword", txtKeyword);
		mav.addObject("products", products);
		
		return mav;
		
	}
	
}
