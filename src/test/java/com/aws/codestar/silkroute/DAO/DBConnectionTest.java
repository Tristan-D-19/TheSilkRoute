package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.aws.codestar.silkroute.models.*;
import java.util.List;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;
import java.sql.Connection;
// import org.junit.jupiter.api.*;

public class DBConnectionTest extends AbstractDAO {
	
	UserDAO userDAO;
	String actual = "";

@BeforeAll
public static void setUp() { 
	
}

@Test 
public void testConnection(){
getConnection();

assertNotNull(conn);
}
}

