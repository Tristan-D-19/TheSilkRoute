package com.aws.codestar.silkroute.DAO;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Connection;
import com.aws.codestar.silkroute.models.*;

public class AccountDAO extends AbstractDAO implements AccountDAOI{


    @Override
    public Account getAccountByUserId(long userId) {
        Account account = null;
        getConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(SQL.GETACCOUNTBYUSERID.getQuery());
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                 account = new Account(rs.getLong(1), rs.getLong(2));
                 account.setBalance(rs.getDouble(3));
               
                  
               }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public double takeMoneyFromAccount(double amount, long userId) {
        boolean itWorked = false;
        double balance = 0;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.TAKEMONEYFROMACCOUNT.getQuery(),new String[]
        { "ACCOUNT_BALANCE" });
        ResultSet rs = null;
        ps.setDouble(1, amount);
        ps.setLong(2,userId);
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	if(!itWorked)
	  {
	 rs = ps.getGeneratedKeys();  
	  }
	  if (rs != null && rs.next() && itWorked) 
		{
			balance = rs.getDouble(1);
		}   
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return balance;
    }

    @Override
    public double addMoneyToAccount(double amount, long userId) {
        boolean itWorked = false;
        double balance = 0;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.ADDMONEYTOACCOUNT.getQuery(),new String[]
        { "ACCOUNT_BALANCE" });
        ResultSet rs = null;
        ps.setDouble(1, amount);
        ps.setLong(2,userId);
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	if(!itWorked)
	  {
	 rs = ps.getGeneratedKeys();  
	  }
	  if (rs != null && rs.next() && itWorked) 
		{
			balance = rs.getDouble(1);
		}   
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return balance;
    }
}