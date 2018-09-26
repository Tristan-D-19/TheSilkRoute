package com.aws.codestar.silkroute.controller;

import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.aws.codestar.silkroute.Application;
import com.aws.codestar.silkroute.models.OrderDetail;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.ProductRepository;
import com.aws.codestar.silkroute.service.ProductService;



@RestController
@RequestMapping("/cart")
public class CartController {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public ModelAndView getCart() {
		ModelAndView mav = new ModelAndView("cart");
		
		return mav;
	}
	
	
//	@PostMapping("/add/{productId:[\\d]+}")
//	public ModelAndView addToCart(@PathVariable("productId") long productId, HttpSession session) {
//			@SuppressWarnings("unchecked")
//			HashSet<OrderDetail> cart= (HashSet<OrderDetail>) session.getAttribute("cart");
////			long id = Long.parseLong(productId);
//			log.debug("product id is: "+ productId);
//			Product product = prodRepo.findOne(productId);
//			User user = (User) session.getAttribute("user");		
//				
//				OrderDetail item = new OrderDetail(product, 1, null);
//			ModelAndView mav = new ModelAndView("market");
//			cart.add(item);
//			session.setAttribute("cart", cart);
//			return mav;
//	}
	
	@PostMapping("/add")
	public RedirectView addToCart(@RequestParam("productId") long productId, HttpSession session) {
			@SuppressWarnings("unchecked")
			HashSet<OrderDetail> cart= (HashSet<OrderDetail>) session.getAttribute("cart");
//			long id = Long.parseLong(productId);
			log.debug("product id is: "+ productId);
			Product product = prodRepo.findOne(productId);
			User user = (User) session.getAttribute("user");		
				
				OrderDetail item = new OrderDetail(product, 1, null);
			ModelAndView mav = new ModelAndView("market");
			cart.add(item);
			session.setAttribute("cart", cart);
			return new RedirectView("/market");
	}
}
