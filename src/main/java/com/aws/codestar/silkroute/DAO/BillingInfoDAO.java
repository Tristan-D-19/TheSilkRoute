package com.aws.codestar.silkroute.DAO;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Connection;
import com.aws.codestar.silkroute.models.*;


public class BillingInfoDAO extends AbstractDAO implements BillingInfoDAOI {


    @Override
    public boolean createBillingInfo(long accId, String billingState, int billingZip) {
        boolean itWorked = false;
		
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.CREATEBILLINGINFO.getQuery());
		ps.setLong(1, accId);
        ps.setString(2, billingState);
        ps.setInt(3, billingZip);

		
		itWorked = ps.executeUpdate() > 0 ? true : false;
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		
		return itWorked;
    }

    @Override
    public List<BillingInfo> getBillingInfoByAccountId(long accountId) {
       List<BillingInfo> billingInfos = new ArrayList<BillingInfo>();

       getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.GETBILLINGIINFOBYACCOUNTID.getQuery());
		ps.setLong(1, accountId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            BillingInfo row = new BillingInfo();
            row.setBilling_id(rs.getLong(1));
            row.setAcc_id(rs.getLong(2));
            row.setBilling_address(rs.getString(3));
            row.setBilling_date(rs.getDate(4));
            row.setBilling_state(rs.getString(5));
            row.setBilling_zip(rs.getInt(6));
            billingInfos.add(row);
        }
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		
		return billingInfos;

    }

    @Override
    public boolean deleteBillingInfoById(long billingId) {
        boolean itWorked = false;
		
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.CREATEBILLINGINFO.getQuery());
		
		ps.setLong(1, billingId);
		itWorked = ps.executeUpdate() > 0 ? true : false;
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		
		return itWorked;
    }
    
}