package com.aws.codestar.silkroute.DAO;

import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Connection;
import com.aws.codestar.silkroute.models.*;

public class OrderDetailDAO extends AbstractDAO implements OrderDetailDAOI {

    @Override
    public long createOrderItem(long product_id, double price, int quantity) {
        boolean itWorked = false;	
        long order_id = 0;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.CREATEORDERITEM.getQuery());
		ResultSet rs = null;
		ps.setLong(1, product_id);
        ps.setDouble(2, price);	
        ps.setInt(3,quantity);
		itWorked = ps.executeUpdate() > 0 ? true : false;
    
        if(!itWorked)
        {
       rs = ps.getGeneratedKeys();  
        }
        if (rs != null && rs.next() && itWorked) 
          {
              order_id = rs.getInt(1);
          }   
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		
		return order_id;
    }

    @Override
    public List<OrderDetail> getAllOrdersById(long order_id) {
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        getConnection();
        try{
			PreparedStatement ps = conn.prepareStatement(SQL.GETALLORDERSBYID.getQuery());
			ps.setLong(1,order_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OrderDetail row = new OrderDetail(rs.getLong(1), rs.getLong(2));
                row.setPrice(rs.getDouble(3));
                row.setOrder_quantity(rs.getInt(4));
				orderDetails.add(row);
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return orderDetails;
    }
}