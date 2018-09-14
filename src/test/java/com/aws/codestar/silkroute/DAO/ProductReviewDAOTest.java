package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.ProductReview;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.ProductReviewRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductReviewDAOTest {

	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ProductReviewRepository reviewRepo;
	
	@Test
	public void should_find_no_reviews_if_repo_is_empty() {
		Iterable<ProductReview> reviews = reviewRepo.findAll();
		assertThat(reviews).isEmpty();
	}
	
	@Test
	public void should_create_a_prod_review() {
		User user = new User("test@gmail.com", "first", "last", "password"); 
		Product product = new Product(user, "Website", "fully functional website", 200);
		ProductReview review = new ProductReview(user, product, "Clean minimal design, quick and effective!", 9);
		ProductReview savedReview = reviewRepo.save(review);
		assertThat(savedReview).isEqualTo(review);
		
	}
	
	@Test 
	public void should_delete_product_review() {
		User user = new User("test@gmail.com", "first", "last", "password"); 
		Product product = new Product(user, "Website", "fully functional website", 200);
		ProductReview review = new ProductReview(user, product, "Clean minimal design, quick and effective!", 9);
		entityManager.persist(review);
		reviewRepo.delete(review);
		
		ProductReview actual = reviewRepo.findOne(review.getReview_id());
		assertThat(actual).isNull();
		
	}
	
	@Test 
	public void should_find_reviews_by_product() {
		User seller = new User("seller@gmail.com", "first", "last", "password");
		User user1 = new User("test1@gmail.com", "first", "last", "password"); 
		User user2 = new User("test2@gmail.com", "first", "last", "password"); 
		User user3 = new User("test3@gmail.com", "first", "last", "password"); 
		Product product = new Product(seller, "Website", "fully functional website", 200);
		ProductReview review1 = new ProductReview(user1, product, "Clean minimal design, quick and effective!", 9);
		ProductReview review2 = new ProductReview(user2, product, "Clean minimal design, quick and effective!", 9);
		ProductReview review3 = new ProductReview(user3, product, "Clean minimal design, quick and effective!", 9);
		
		entityManager.persist(review1);
		entityManager.persist(review2);
		entityManager.persist(review3);
		
		Iterable <ProductReview> reviews = reviewRepo.findByProduct(product);
		
		assertThat(reviews).hasSize(3).contains(review1, review2, review3);
		
	}
}


