package com.aws.codestar.silkroute.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.customannotations.CurrentUser;
import com.aws.codestar.silkroute.models.OrderDetail;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.ProductRepository;
import com.aws.codestar.silkroute.service.CustomUserDetails;
import com.aws.codestar.silkroute.service.ProductService;

@RestController
public class IndexController {

	@Autowired
	private ProductService prodService;
	
	@Autowired
	private ProductRepository prodRepo;
	Logger logger = LoggerFactory.getLogger(IndexController.class);
	public IndexController() {
		
	}
	
	@GetMapping({"/", "/home"})
public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		if(SecurityContextHolder.getContext().getAuthentication() != null)
		{
			 SecurityContext context = SecurityContextHolder.getContext();
			 Authentication authentication = context.getAuthentication();
		Object obj =  authentication.getPrincipal();
		User user = null;
		if(obj instanceof User) {
			user = (User) obj;
		
			String name = user.getFirstName();
			if(name!= null)
				session.setAttribute("name", name);
			}
		}

		
		String txtKeyword = "";
		session.setAttribute("cart", new HashSet<OrderDetail>());
		mav.addObject("txtKeyword", txtKeyword);
		return mav;
		}
	
	
	@RequestMapping("/test")
public ModelAndView testindex() {
		ModelAndView mav = new ModelAndView("test");
		return mav;
		}
	
	@PostMapping("/search")
	public ModelAndView search(@RequestParam("txtKeyword") String txtKeyword) {
		System.out.println("PRINTING KEYWORD"+ txtKeyword);
		List<Product> products = prodService.searchForProduct(txtKeyword);
//		List<Product> products = prodRepo.findAll();
		ModelAndView mav = new ModelAndView("market");
		mav.addObject("products", products);
		
		
		return mav;
		
	}
	
	@GetMapping("/search")
	public ModelAndView searchGet() {
		
		String txtKeyword = "";
		
		ModelAndView mav = new ModelAndView("market");
		List<Product> products = prodRepo.findAll();
		mav.addObject("txtKeyword", txtKeyword);
		mav.addObject("products", products);
		
		return mav;
		
	}
}
