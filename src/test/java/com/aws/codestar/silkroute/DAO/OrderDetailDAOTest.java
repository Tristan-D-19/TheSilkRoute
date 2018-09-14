package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Order;
import com.aws.codestar.silkroute.models.OrderDetail;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.OrderDetailRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderDetailDAOTest {

	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired 
	OrderDetailRepository orderDetRepo;
	
	@Test
	public void should_find_no_order_details_if_repo_is_empty() {
		
		Iterable<OrderDetail> orderDetails = orderDetRepo.findAll();
		assertThat(orderDetails).isEmpty();		
	}
	
	@Test
	public void should_create_order_detail() {
		User testUser = new User("test@gmail.com", "first", "last", "password");
		Product product = new Product(new User("test@gmail.com", "first", "last", "password"), "test product", "Website Logo", 70);
		OrderDetail orderDet = new OrderDetail(product, 3, new Order(testUser));
		OrderDetail savedItem = orderDetRepo.save(orderDet);
		assertThat(orderDet).isEqualTo(savedItem);
	}
	
	@Test 
	public void should_find_order_detail_by_id() {
		User testUser = new User("test@gmail.com", "first", "last", "password");
		Product product = new Product(new User("test@gmail.com", "first","last", "password"), "test product", "Website Logo", 70);
		OrderDetail orderDet = new OrderDetail(product, 3, new Order(testUser));
		entityManager.persist(orderDet);
		
		OrderDetail foundItem = orderDetRepo.findOne(orderDet.getOrderId());
		assertThat(orderDet).isEqualTo(foundItem);
	}
	
	@Test 
	public void should_delete_item() {
		User testUser = new User("test@gmail.com", "first", "last", "password");
		Product product = new Product(new User("test@gmail.com", "first","last", "password"), "test product","Website Logo", 70);
		OrderDetail orderDet = new OrderDetail(product, 3, new Order(testUser));
		entityManager.persist(orderDet);
		orderDetRepo.delete(orderDet);
		OrderDetail actual = orderDetRepo.findOne(orderDet.getOrderId());
		assertThat(actual).isNull();
	}
	
	@Test
	public void should_find_items_by_order() {
		User testUser = new User("test@gmail.com", "first", "last", "password");
		Order order = new Order(testUser);
		
		Product product1 = new Product(new User("test@gmail.com", "first","last", "password"), "test product", "Website Logo", 70);
		OrderDetail orderDet1 = new OrderDetail(product1, 3, order);
		entityManager.persist(orderDet1);
		
		Product product2 = new Product(new User("test@gmail.com", "first","last", "password"), "test product","Website Logo", 70);
		OrderDetail orderDet2 = new OrderDetail(product2, 10, order);
		entityManager.persist(orderDet2);
		
		Product product3 = new Product(new User("test@gmail.com", "first","last", "password"), "test product","Website Logo", 70);
		OrderDetail orderDet3 = new OrderDetail(product3, 20, order);
		entityManager.persist(orderDet3);
		
		Iterable<OrderDetail> items = orderDetRepo.findByOrder(order);
		assertThat(items).hasSize(3).contains(orderDet1, orderDet2, orderDet3);
	}
	
	@Test
	public void should_find_items_by_product() {
		User testUser = new User("test@gmail.com", "first", "last", "password");
		Order order = new Order(testUser);
		
		Product product1 = new Product(new User("test@gmail.com", "first","last", "password"), "test product","Website Logo", 70);
		OrderDetail orderDet1 = new OrderDetail(product1, 3, order);
		entityManager.persist(orderDet1);
				
		OrderDetail orderDet2 = new OrderDetail(product1, 10, order);
		entityManager.persist(orderDet2);
		
		OrderDetail orderDet3 = new OrderDetail(product1, 20, order);
		entityManager.persist(orderDet3);
		
		Iterable<OrderDetail> items = orderDetRepo.findByProduct(product1);
		assertThat(items).hasSize(3).contains(orderDet1, orderDet2, orderDet3);
	}
	
	@Test
	public void should_update_item() {
		User testUser = new User("test@gmail.com", "first", "last", "password");
		Product product = new Product(new User("test@gmail.com", "first","last", "password"),"test product", "Website Logo", 70);
		OrderDetail orderDet = new OrderDetail(product, 3, new Order(testUser));
		entityManager.persist(orderDet);
		
		OrderDetail item = orderDetRepo.findOne(orderDet.getOrderId());
		item.setOrderQuantity(5);
		OrderDetail updatedItem = orderDetRepo.save(item);
		
		assertThat(item).isEqualTo(updatedItem);
	}
}
