package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Picture;
import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.ProductPicture;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.ProductPictureRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductPictureDAOTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ProductPictureRepository prodPicRepo;
	
	@Test
	public void should_find_no_pics_if_repo_is_empty() {
		Iterable<ProductPicture> pics = prodPicRepo.findAll();
		
		assertThat(pics).isEmpty();
	}
	
	@Test
	public void should_create_new_prod_pic() {
		User user = new User("test@gmail.com", "first", "last", "password"); 
		Picture pic = new Picture(user, "test.jpg");
		Product product = new Product(user, "Website", "fully functional website", 200);
		ProductPicture pic1 = new ProductPicture(product, pic);
		ProductPicture savedPic = prodPicRepo.save(pic1);
		assertThat(pic1).isEqualTo(savedPic);
		
	}
	
	@Test
	public void should_delete_pic() {
		User user = new User("test@gmail.com", "first", "last", "password"); 
		Picture pic = new Picture(user, "test.jpg");
		Product product = new Product(user, "Website", "fully functional website", 200);
		ProductPicture pic1 = new ProductPicture(product, pic);
		entityManager.persist(pic1);
		
		prodPicRepo.delete(pic1);
		ProductPicture actual = prodPicRepo.findOne(pic1.getProductPicId());
		assertThat(actual).isNull();
		
	}
	
	@Test 
	public void should_find_pics_by_product() {
		User user = new User("test@gmail.com", "first", "last", "password"); 
		Picture pic1 = new Picture(user, "test1.jpg");
		Picture pic2 = new Picture(user, "test2.jpg");
		Picture pic3 = new Picture(user, "test3.jpg");
		Product product = new Product(user, "Website", "fully functional website", 200);
		ProductPicture prodPic1 = new ProductPicture(product, pic1);
		ProductPicture prodPic2 = new ProductPicture(product, pic2);
		ProductPicture prodPic3 = new ProductPicture(product, pic3);
		entityManager.persist(prodPic1);
		entityManager.persist(prodPic2);
		entityManager.persist(prodPic3);
		
		Iterable<ProductPicture> pics = prodPicRepo.findByProduct(product);
		assertThat(pics).hasSize(3).contains(prodPic1, prodPic2, prodPic3);
		
	}
	
	
}
