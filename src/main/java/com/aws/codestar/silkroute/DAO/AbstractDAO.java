package com.aws.codestar.silkroute.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

abstract class AbstractDAO {
	
	/**
	 * Connection variable to interact with DB
	 */
	protected Connection conn;
	
	public void getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xed";
			String url2 = "jdbc:oracle:thin:@ec2-18-220-173-65.us-east-2.compute.amazonaws.com:1521:xe";
			String user = "tsr_admin";
			String pass = "aRwWyc7WUKHgWWup";
			
			conn = DriverManager.getConnection(url2, user, pass);
			if(conn == null) {
				System.out.println("WTF");
			}
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
