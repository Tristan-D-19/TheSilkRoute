package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import com.aws.codestar.silkroute.repositories.UserRepository;

import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.hamcrest.*;
import org.hamcrest.collection.*;
import com.aws.codestar.silkroute.service.*;
// import org.junit.jupiter.api.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
  
@DataJpaTest
@Import(User.class)

//@Transactional
public class UserDAOTest {
	

	
	static UserService userService;
	
	@Autowired
	private static TestEntityManager entityManager;
	
	
	static UserRepository userRepo;
	
	static String actualEmail = "";
    static List <User> expectedUsers = null;
    static User test = null;
    static long testId = 0;
     public static User userStub;
    
@Before
public static void setUp() { 
	 
	 userService = new UserService();
	 userRepo = Mockito.mock(UserRepository.class);
	 expectedUsers = new ArrayList<User>();
	 userStub = new User("test5@gmail.com", "test5","test5", "password");
	 entityManager.persistAndFlush(userStub);
}

@Ignore
//@Test
public void testUserRepo() {
	long actualCount = userRepo.count();
//	assertNotEquals(0, actualCount);
}

@Test
public void testCreateUser(){
	
	User expected = new User("test5@gmail.com", "test5","test5", "password");
	
//	 this.entityManager.persistAndFlush(userStub);
//	 this.entityManager.flush();
//	User actual = userService.createUser(userStub);
//	userRepo.saveAndFlush(userStub);
	if(userRepo == null)
		System.out.println("NO REPO");
	
	User actual = userRepo.findByEmail(userStub.getEmail());
//	 actual = userRepo.findOne(savedUser.getUserId());
	assertEquals(expected.getEmail(),actual.getEmail());

}


//@Test 
public void testGetUserByEmail(){
	User expected = new User("test4@gmail.com", "test4","test4", "password");
	User actual  = userService.findUserByEmail("test4@gmail.com");
	String first_name = actual.getFirstName();
//	assertEquals(expected.getFirst_name(), first_name);
	assertNotNull(actual);
	test = actual; //save
	
    System.out.println("Testing Emails " + test.getUserId());
}




//@Test 
public void testAdminGetAllUsers(){
//admin 

//expectedUsers.add( userDAO.getUserByEmail("test@gmail.com") );
expectedUsers.add( userService.findUserByEmail("test1@gmail.com") );
expectedUsers.add( userService.findUserByEmail("test2@gmail.com") );
expectedUsers.add( userService.findUserByEmail("test3@gmail.com") );
expectedUsers.add( userService.findUserByEmail("test4@gmail.com") );
List<User> actualUsers = userService.adminGetAllUsers();
assertEquals(expectedUsers.size(), actualUsers.size());
expectedUsers.clear(); //reset list

}

//@Test
public void testGetAllUsers() {
	expectedUsers.add( userService.findUserByEmail("test1@gmail.com") );
	expectedUsers.add( userService.findUserByEmail("test2@gmail.com") );
	expectedUsers.add( userService.findUserByEmail("test3@gmail.com") );
	expectedUsers.add( userService.findUserByEmail("test4@gmail.com") );
	List<User> actualUsers = userService.getAllUsers();
	assertEquals(expectedUsers.size(), actualUsers.size());
	expectedUsers.clear(); //reset list 
}


//@Test
public void testGetUserById() {
	
	
	User actual = userService.findUserById(test.getUserId());
	User expected = new User("test5@gmail.com", "test5","test5", "password");
//	assertEquals(expected.getFirst_name(), actual.getFirst_name());
	assertNotNull(actual);
}

//@Test
public void testDeactivateUserById() {

	
	assertTrue(userService.deactivateUser(test.getUserId()));
}

//@Test
public void testReactivateUserById() {

	
	assertTrue(userService.reactivateUser(test.getUserId()));
}

//@Test
public void testDeleteUser() {
	
	boolean  actual = userService.deleteUserById(test.getUserId());
			assertTrue(actual);		
	User userStub = new User("test5@gmail.com", "test5","test5", "password");
	userService.createUser(userStub);
}

}

