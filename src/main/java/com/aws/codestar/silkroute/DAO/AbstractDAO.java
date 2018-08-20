package com.aws.codestar.silkroute.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

abstract class AbstractDAO {
	
	protected Connection conn;
	
	public void getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "tsr_admin";
			String pass = "aRwWyc7WUKHgWWup";
			
			conn = DriverManager.getConnection(url, user, pass);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch(Exception e) {}
	}
	
}
