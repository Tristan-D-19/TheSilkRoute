package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.hamcrest.*;
import org.hamcrest.collection.*;
import com.aws.codestar.silkroute.service.*;
// import org.junit.jupiter.api.*;

public class UserDAOTest {
	
//	static UserDAO userService;
	static UserService userService;
	static String actualEmail = "";
    static List <User> expectedUsers = null;
    static User test = null;
    static long testId = 0;
    
@BeforeAll
public static void setUp() { 
	 
	 userService = new UserService();
	 expectedUsers = new ArrayList<User>();
}


@Test
public void testCreateUser(){
	User expected = new User("test5@gmail.com", "test5","test5", "password");
	User userStub = new User("test5@gmail.com", "test5","test5", "password");
	User actual = userService.createUser(userStub);
//	testId = expected; // save for next test
//	assertNotEquals(expected, expected);
	assertEquals(expected, actual);
//	userDAO.deleteUserById(testId);

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

