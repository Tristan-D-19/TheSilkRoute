package com.aws.codestar.silkroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.codestar.silkroute.repositories.OrderDetailRepository;
import com.aws.codestar.silkroute.repositories.OrderRepository;
import com.aws.codestar.silkroute.repositories.ProductRepository;

@Service
public class OrderService {

	
	
	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired 
	private OrderDetailRepository orderDetRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	
}
