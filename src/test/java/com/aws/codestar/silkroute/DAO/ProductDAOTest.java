package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Department;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.ProductRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductDAOTest {

	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ProductRepository prodRepo;
	
	@Test
	public void should_find_no_products_if_repo_is_empty(){
		Iterable<Product> products = prodRepo.findAll();
		assertThat(products).isEmpty();
	}
	
	@Test
	public void should_create_a_product() {
		User user = new User("test@gmail.com", "first", "last", "password");
		Product product = new Product(user, "Website", "fully functional website", 200);
		Product savedProduct = prodRepo.save(product);
		
		assertThat(product).isEqualTo(savedProduct);
	}
	
	@Test
	public void should_find_product_by_id() {
		User user = new User("test@gmail.com", "first", "last", "password");
		Product product = new Product(user, "Website", "fully functional website", 200);
		entityManager.persist(product);
		Product foundProduct = prodRepo.findOne(product.getProductId());
		assertThat(product).isEqualTo(foundProduct);
		
	}
	
	@Test
	public void should_delete_a_product() {
		User user = new User("test@gmail.com", "first", "last", "password");
		Product product = new Product(user, "Website", "fully functional website", 200);
		entityManager.persist(product);
		prodRepo.delete(product);
		Product foundProduct = prodRepo.findOne(product.getProductId());
		assertThat(foundProduct).isNull();
	}
	
	@Test
	public void should_find_products_by_departments() {
		List<Department> deps = new ArrayList<Department>();
		
		Department engineering = new Department("Engineering","engineering and IOT");
		Department webdev = new Department("Web Development", "website development, full stack, word press, and all web frameworks");
		Department graphicDesign = new Department("Graphic Design", "Logos, banners, and all designs");
		
		deps.add(engineering);
		deps.add(webdev);
		deps.add(graphicDesign);
		
		User user = new User("test@gmail.com", "first", "last", "password");
		
		
		Product product1 = new Product(user, "Website", "fully functional website", 200);
		product1.setDepartments(deps);
		Product product2 = new Product(user, "Website", "fully functional website", 200);
		product2.setDepartments(deps);
		Product product3 = new Product(user, "Website", "fully functional website", 200);
		product3.setDepartments(deps);
		
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		Iterable<Product> products = prodRepo.findDistinctProductByDepartmentsIn(deps);
		assertThat(products).hasSize(3).contains(product1, product2, product3);
	}
	
	@Test
	public void should_find_products_by_user() {
		User user = new User("test@gmail.com", "first", "last", "password");
			
		Product product1 = new Product(user, "Website", "fully functional website", 200);
	
		Product product2 = new Product(user, "Website", "fully functional website", 200);
		
		Product product3 = new Product(user, "Website", "fully functional website", 200);
		
		
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		
		Iterable<Product> products = prodRepo.findBySeller(user);
		assertThat(products).hasSize(3).contains(product1, product2, product3);
		
	}
	
	@Test
	public void should_find_product_by_price() {
		User user = new User("test@gmail.com", "first", "last", "password");
		
		Product product1 = new Product(user, "Website", "fully functional website", 200);
	
		Product product2 = new Product(user, "Website", "fully functional website", 200);
		
		Product product3 = new Product(user, "Website", "fully functional website", 200);
		
		
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		
		Iterable<Product> products = prodRepo.findByPrice(200);
		assertThat(products).hasSize(3).contains(product1, product2, product3);	
	}
	
	@Test 
	public void should_update_product() {
		User user = new User("test@gmail.com", "first", "last", "password");
		
		Product product1 = new Product(user, "Website", "fully functional website", 200);
		
		entityManager.persist(product1);
		Product product = prodRepo.findOne(product1.getProductId());
		product.addToQuantity(20); // should be 21 now
		product.setPrice(300);
		Product updatedProduct = prodRepo.save(product);
		assertThat(product).isEqualTo(updatedProduct);
		
	}
}
