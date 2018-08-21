package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.DAO.*;
import com.aws.codestar.silkroute.models.*;
import org.junit.*;

public class UserDAOTest  {
	
	UserDAO userDAO;

@BeforeClass
public void setUp() { 
	 userDAO = new UserDAO();
}

@Test 
public void testCreateUser(){
	User expected = new User("test1@gmail.com", "test1","test1", "password");
	Assert.assertEquals(expected.getEmail(), userDAO.getUserByEmail("test1@email.com").getEmail());
	
    System.out.println("Testing Emails");
}

}