package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws.codestar.silkroute.models.Order;
import com.aws.codestar.silkroute.models.User;
import java.util.List;
import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByCustomer(User customer);
	
	List<Order> findByCreationDate(Date creationdate);
}
