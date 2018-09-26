package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.aws.codestar.silkroute.models.OrderDetail;
import com.aws.codestar.silkroute.models.Order;
import java.util.List;
import com.aws.codestar.silkroute.models.Product;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

	List<OrderDetail> findByOrder(Order order);
	
	List<OrderDetail> findByProduct(Product product);
	
	List<OrderDetail> findByPrice(double price);
	
	List<OrderDetail> findByOrderQuantity(int quantity);
	
	
}
