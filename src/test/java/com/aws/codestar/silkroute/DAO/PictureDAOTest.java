package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.*;

import com.aws.codestar.silkroute.repositories.PictureRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class PictureDAOTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	PictureRepository picRepo;
	
	
	@Test
	public void should_find_no_pics_if_repo_is_empty() {
	Iterable<Picture> pics = picRepo.findAll();
	assertThat(pics).isEmpty();
	}
	
	@Test
	public void should_create_picture() {
		Picture pic = new Picture(new User("test@gmail.com", "first", "last", "password"), "testImage.jpg");
		Picture savedPic = picRepo.save(pic);
		assertThat(pic).isEqualTo(savedPic);
	}
	
	@Test
	public void should_delete_picture() {
		Picture pic = new Picture(new User("test@gmail.com", "first", "last", "password"), "testImage.jpg");
		entityManager.persist(pic);
		picRepo.delete(pic);
		Picture actualPic = picRepo.findOne(pic.getPictureId());
		assertThat(actualPic).isNull();
	}
	
	@Test
	public void should_find_users_pics() {
		User user = new User("test@gmail.com", "first", "last", "password");
		Picture pic1 = new Picture(user, "testImage.jpg");
		entityManager.persist(pic1);
		Picture pic2 = new Picture(user, "testImage.jpg");
		entityManager.persist(pic2);
		Picture pic3 = new Picture(user, "testImage.jpg");
		entityManager.persist(pic3);
		
		Iterable<Picture> pics = picRepo.findByUser(user);
		assertThat(pics).hasSize(3).contains(pic1,pic2,pic3);
	}
	
	@Test
	public void should_find_pic_by_id() {
		User user = new User("test@gmail.com", "first", "last", "password");
		Picture pic1 = new Picture(user, "testImage.jpg");
		entityManager.persist(pic1);
		Picture foundPic = picRepo.findOne(pic1.getPictureId());
		assertThat(pic1).isEqualTo(foundPic);
	}
	
	
}
