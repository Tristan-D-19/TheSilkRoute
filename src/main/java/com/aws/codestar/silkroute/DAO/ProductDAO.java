package com.aws.codestar.silkroute.DAO;

import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Connection;
import com.aws.codestar.silkroute.models.*;

public class ProductDAO extends AbstractDAO implements ProductDAOI {

	
	@Override
    public List<Product> getProductsByDepartment(long departmentId) {
        List<Product> products = new ArrayList<Product>();
        getConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(SQL.GETPRODUCTSBYDEPARTMENT.getQuery());
            ps.setLong(1, departmentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Product row = new Product();
                row.setProduct_id(rs.getLong(1));
                row.setProduct_name(rs.getString(2));
                row.setSeller_id(rs.getLong(3));
                row.setDepartment_id(rs.getLong(4));
                row.setQuantity(rs.getInt(5));
                row.setPrice(rs.getDouble(6));
                row.setProduct_description(rs.getString(7));
                   products.add(row);	
               }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getProductsByUser(long userId) {
        List<Product> products = new ArrayList<Product>();
        getConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(SQL.GETPRODUCTSBYDEPARTMENT.getQuery());
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Product row = new Product();
                row.setProduct_id(rs.getLong(1));
                row.setProduct_name(rs.getString(2));
                row.setSeller_id(rs.getLong(3));
                row.setDepartment_id(rs.getLong(4));
                row.setQuantity(rs.getInt(5));
                row.setPrice(rs.getDouble(6));
                row.setProduct_description(rs.getString(7));
                   products.add(row);	
               }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean createNewProduct(Product product) {
        boolean itWorked = false;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.CREATENEWPRODUCT.getQuery());
        ps.setString(1, product.getProduct_name());
        ps.setLong(2, product.getSellerId());
        ps.setLong(3,product.getDepartment_id());
        ps.setInt(4, product.getQuantity());
        ps.setDouble(5, product.getPrice());
        ps.setString(6, product.getProduct_description());
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return itWorked;
   }
    

    @Override
    public boolean removeProduct(long productId) {
        boolean itWorked = false;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.REMOVEPRODUCT.getQuery());
		ps.setLong(1, productId);
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return itWorked;
   }
    

    @Override
    public int addProductQuantity(long productId) {
        boolean itWorked = false;
        int prodQuantity = 0;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.REMOVEPRODUCT.getQuery(),new String[]
        { "Quantity" });
        ResultSet rs = null;
		ps.setLong(1, productId);
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	if(!itWorked)
	  {
	 rs = ps.getGeneratedKeys();  
	  }
	  if (rs != null && rs.next() && itWorked) 
		{
			prodQuantity = rs.getInt(1);
		}   
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return prodQuantity;
    }

    @Override
    public int subtractProductQuantity(double amount, long productId) {
        boolean itWorked = false;
        int prodQuantity = 0;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.REMOVEPRODUCT.getQuery(),new String[]
        { "Quantity" });
        ResultSet rs = null;
		ps.setLong(1, productId);
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	if(!itWorked)
	  {
	 rs = ps.getGeneratedKeys();  
	  }
	  if (rs != null && rs.next() && itWorked) 
		{
			prodQuantity = rs.getInt(1);
		}   
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return prodQuantity;
    }

}
