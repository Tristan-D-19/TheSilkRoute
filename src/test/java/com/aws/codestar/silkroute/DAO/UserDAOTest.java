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

// import org.junit.jupiter.api.*;

public class UserDAOTest {
	
	static UserDAO userDAO;
	static String actualEmail = "";
    static List <User> expectedUsers = null;
    static User test = null;
    static long testId = 0;
    
@BeforeAll
public static void setUp() { 
	 userDAO = new UserDAO();
	 expectedUsers = new ArrayList<User>();
}


@Test
public void testCreateUser(){
	User userStub = new User("test@gmail.com", "test","test", "password");
	long expected = userDAO.createUser(userStub);
	testId = expected; // save for next test
	assertNotEquals(0, expected);
	

}


@Test 
public void testGetUserByEmail(){
	User expected = new User("test1@gmail.com", "test1","test1", "password");
	User actual  = userDAO.getUserByEmail("test1@gmail.com");
	String first_name = actual.getFirst_name();
	assertEquals(expected.getFirst_name(), first_name);
	test = actual; //save
	
    System.out.println("Testing Emails");
}




@Test 
public void testAdminGetAllUsers(){
//admin 

//expectedUsers.add( userDAO.getUserByEmail("test@gmail.com") );
expectedUsers.add( userDAO.getUserByEmail("test1@gmail.com") );
expectedUsers.add( userDAO.getUserByEmail("test2@gmail.com") );

List<User> actualUsers = userDAO.adminGetAllUsers();
assertEquals(expectedUsers.size(), actualUsers.size());
expectedUsers.clear();

}

@Test
public void testGetAllUsers() {
//	expectedUsers.add( userDAO.getUserByEmail("test@gmail.com") );
	expectedUsers.add( userDAO.getUserByEmail("test1@gmail.com") );
	expectedUsers.add( userDAO.getUserByEmail("test2@gmail.com") );
	List<User> actualUsers = userDAO.getAllUsers();
	assertEquals(expectedUsers.size(), actualUsers.size());
	expectedUsers.clear();
}

@Test
public void testDeleteUser() {
	
	boolean  actual = userDAO.deleteUserById(testId);
			assertTrue(actual);		
}

@Test
public void testGetUserById() {
	long idStub = 772311712;
	
	User actual = userDAO.getUserById(idStub);
	User expected = new User("test1@gmail.com", "test1","test1", "password");
	assertEquals(expected.getFirst_name(), actual.getFirst_name());
}

@Test
public void testDeactivateUserById() {
	long idStub = 772311712;
	
	assertTrue(userDAO.deactivateUser(idStub));
}

@Test
public void testReactivateUserById() {
	long idStub = 772311712;
	
	assertTrue(userDAO.reactivateUser(idStub));
}



}

