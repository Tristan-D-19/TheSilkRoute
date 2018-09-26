package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Order;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.OrderRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderDAOTest {

	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired 
	OrderRepository orderRepo;
	
	
	@Test
	public void should_find_no_orders_if_repo_is_empty() {
		
		Iterable<Order> orders = orderRepo.findAll();
		assertThat(orders).isEmpty();		
	}
	
	@Test
	public void should_create_order() {
		Order testOrder = new Order(new User("test@gmail.com", "first", "last","password"));
		Order savedOrder = orderRepo.save(testOrder);
		assertThat(testOrder).isEqualTo(savedOrder);
	}
	
	@Test
	public void should_find_order_by_id() {
		Order testOrder = new Order(new User("test@gmail.com", "first", "last","password"));
		entityManager.persist(testOrder);
		orderRepo.findOne(testOrder.getOrderId());
	}
	
	@Test 
	public void should_find_orders_by_customer() {
		User test1 = new User("test1@gmail.com", "test1", "test1", "password");
		Order testOrder1 = new Order(test1);
		Order testOrder2 = new Order(test1);
		Order testOrder3 = new Order(test1);
		
		entityManager.persist(testOrder1);
		entityManager.persist(testOrder2);
		entityManager.persist(testOrder3);
		
		Iterable <Order> orders = orderRepo.findByCustomer(test1);
		assertThat(orders).hasSize(3).contains(testOrder1, testOrder2, testOrder3);
	}
	
	@Test
	public void should_find_orders_by_date() {
		
		User test1 = new User("test1@gmail.com", "test1", "test1", "password");
		
		Date date = new Date(); 
		Order testOrder1 = new Order(test1);
		testOrder1.setCreationDate(date);
		Order testOrder2 = new Order(test1);
		testOrder2.setCreationDate(date);
		Order testOrder3 = new Order(test1);
		testOrder2.setCreationDate(date);
		testOrder3.setCreationDate(date);
		
		entityManager.persist(testOrder1);
		entityManager.persist(testOrder2);
		entityManager.persist(testOrder3);
		
		Iterable <Order> orders = orderRepo.findByCreationDate(date);
		assertThat(orders).hasSize(3).contains(testOrder1, testOrder2, testOrder3);
	}
}
