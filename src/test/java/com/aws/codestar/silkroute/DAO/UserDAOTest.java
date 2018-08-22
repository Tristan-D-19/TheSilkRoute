package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// import org.junit.jupiter.api.*;

public class UserDAOTest  {
	
	static UserDAO userDAO;
	static String actual = "";

@BeforeAll
public static void setUp() { 
	 userDAO = new UserDAO();
	 actual = userDAO.getUserByEmail("test@gmail.com").getEmail();
}

@Test 
public void testGetUserByEmail(){
	User expected = new User("test@gmail.com", "test1","test1", "password");
	assertEquals(expected.getEmail(), actual);
	
    System.out.println("Testing Emails");
}

}