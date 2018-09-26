package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import com.aws.codestar.silkroute.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
//import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.*;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.aws.codestar.silkroute.service.*;
// import org.junit.jupiter.api.*;


//BASIC DAO CRUD TEST
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDAOTest {
	
	
	private UserService userService;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepo;
	
	static String actualEmail = "";
    static List <User> expectedUsers = null;
    static User test = null;
    static long testId = 0;
     public static User userStub;
    
@Before
public  void setUp() { 
	 
	
	 
}

@Ignore
//@Test
public void testUserRepo() {
	long actualCount = userRepo.count();
//	assertNotEquals(0, actualCount);
}

@Test
public void should_find_no_users_if_repository_is_empty() {
	userRepo.deleteAll();
	Iterable<User> users = userRepo.findAll();

	assertThat(users).isEmpty();
}
@Test
public void should_create_user() throws Exception{
	//stub for test
	userStub = new User("test5@gmail.com", "test5","test5", "password");

	User savedUser = userRepo.save(new User("test5@gmail.com", "test5","test5", "password"));
	User actual = userRepo.findOne(savedUser.getUserId()); //find user in repo
	assertNotNull(actual);

}

@Test
public void should_find_all_users() {
	userRepo.deleteAll();
	User user1 = new User("test1", "first", "last", "password");
	User user2 = new User("test2", "first", "last", "password");
	User user3 = new User("test3", "first", "last", "password");
	User user4 = new User("test4", "first", "last", "password");
	User user5 = new User("test5", "first", "last", "password");
	entityManager.persist(user1);
	entityManager.persist(user2);
	entityManager.persist(user3);
	entityManager.persist(user4);
	entityManager.persist(user5);
	
	Iterable<User> users = userRepo.findAll();
	
	//should have 5 distinct users
	assertThat(users).hasSize(5).contains(user1,user2, user3, user4, user5);
}
@Test
public void should_delete_all_users() {
	entityManager.persist(new User("test1", "first", "last", "password"));
	entityManager.persist(new User("test2", "first", "last", "password"));
	entityManager.persist(new User("test3", "first", "last", "password"));
	entityManager.persist(new User("test4", "first", "last", "password"));
	entityManager.persist(new User("test5", "first", "last", "password"));
	userRepo.deleteAll();
	assertThat(userRepo.findAll()).isEmpty();
}


@Test
public void should_find_user_by_id() {
	User user1 = new User("sam@gmail.com", "Sam", "Smith", "password");
	entityManager.persist(user1);
	User actual  = userRepo.findOne(user1.getUserId());
	
	assertThat(actual).isEqualTo(user1);
	
}


@Test 
public void should_find_user_by_email(){
	
	User user2 = new User("mark@gmail.com", "mark", "Smith", "password");
	entityManager.persist(user2);
	Optional<User> foundUser = userRepo.findByEmail(user2.getEmail());
	assertThat(foundUser.get()).isEqualTo(user2);
}


@Test
public void should_deactivate_user_by_id() {
	User test = new User("test1", "first", "last", "password");
	test = userRepo.save(test); //save active user
	test.setActive(false); // deactivate user
	test = userRepo.save(test);
	assertThat(test).hasFieldOrPropertyWithValue("active", false);
}

@Test
public void should_reactivate_user_by_id() {
	User test2 = new User("test2", "first", "last", "password");
	test2.setActive(false); // create deactivated user
	test2 = userRepo.save(test2);
	test2.setActive(true); // reactivate user
	test2 = userRepo.save(test2);
	assertThat(test2).hasFieldOrPropertyWithValue("active", true);
}

@Test
public void should_create_admin_user() {
 Role admin = new Role(1, "Admin");
 Role customer = new Role(0, "Customer");
 Set<Role> roles = new HashSet<Role>();
 roles.add(admin);
 roles.add(customer);
 User adminUser = new User("admin@gmail.com", "admin", "admin", "adminPass");
 adminUser.setRoles(roles);
 adminUser = userRepo.save(adminUser);
 assertThat(adminUser).hasFieldOrPropertyWithValue("roles", roles);
}

@Test
public void should_create_customer_user() {
	Role customer = new Role(0, "customer");
	Set<Role> roles = new HashSet<Role>();
	roles.add(customer);
	User testUser = new User("customer@gmail.com", "Sam", "smith", "password");
	testUser.setRoles(roles);
	assertThat(testUser).hasFieldOrPropertyWithValue("roles", roles);
}

@Test
public void should_delete_user() {
	User testx = new User("testx", "first", "last", "password");
	userRepo.save(testx);
	userRepo.delete(testx.getUserId());
	//should return null 
	assertThat(userRepo.findOne(testx.getUserId())).isNull(); 
}

@Test
public void should_update_user() {
	User testUser = new User("customer@gmail.com", "Sam", "smith", "password");
	entityManager.persist(testUser);
	testUser.setAddress("199 White House lane");
	testUser.setCity("Washington");
	testUser.setPhone("777-888-9999");
	testUser.setZipcode(11111);
	testUser.setState("DC");
	User updatedUser = userRepo.save(testUser);
	assertThat(updatedUser).isEqualTo(testUser);
	}

@Test 
public void should_change_password() {
	User user1 = new User("test1", "first", "last", "password");
	entityManager.persist(user1);
	user1.setPassword("securePass");
	user1 = userRepo.save(user1);
	assertThat(user1).hasFieldOrPropertyWithValue("password", "securePass");
}

@Test
public void should_find_all_users_read_only() {
	userRepo.deleteAll();
	User user1 = new User("test1", "first", "last", "password");
	User user2 = new User("test2", "first", "last", "password");
	User user3 = new User("test3", "first", "last", "password");
	User user4 = new User("test4", "first", "last", "password");
	User user5 = new User("test5", "first", "last", "password");
	entityManager.persist(user1);
	entityManager.persist(user2);
	entityManager.persist(user3);
	entityManager.persist(user4);
	entityManager.persist(user5);
	
	Iterable<User> users = userRepo.readAll();
	
	//should have 5 distinct users
	assertThat(users).hasSize(5).contains(user1,user2, user3, user4, user5);
	
}

//@Test 
//public void should_find_user_by_email_service() {
//	User user1 = new User("test1", "first", "last", "password");
//	entityManager.persist(user1);
//User user = userService.findUserByEmail("test1");
//assertThat(user).isNotNull();
//}

}
