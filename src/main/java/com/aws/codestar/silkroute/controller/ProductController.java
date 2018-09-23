package com.aws.codestar.silkroute.controller;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.Order;
import com.aws.codestar.silkroute.models.OrderDetail;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.ProductRepository;
import com.aws.codestar.silkroute.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("{id:[\\d]+}")
	public ModelAndView getProduct(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("productPage");
		
		Product product = productService.getProduct(id); 
		mav.addObject("product", product);
		
		return mav;
	}
	
	
}
