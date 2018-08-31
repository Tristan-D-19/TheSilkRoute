package com.aws.codestar.silkroute.DAO;

import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;
import java.sql.Connection;
import com.aws.codestar.silkroute.models.*;

public class ProductPictureDAO extends AbstractDAO implements ProductPictureDAOI {

	
	@Override
	public List<ProductPicture> getPicturesByProduct(long productId) {
		List<ProductPicture> pics = new ArrayList<ProductPicture>();
		getConnection();
		try{
			PreparedStatement ps = conn.prepareStatement(SQL.GETPICTURESBYPRODUCT.getQuery());
			ps.setLong(1,productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ProductPicture row = new ProductPicture();
				row.setProduct_id(rs.getLong(1));
				row.setPic_id(rs.getLong(2));
				pics.add(row);
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return pics;
	}

	@Override
	public boolean createNewProductPicture(long prodId, long picId) {
		boolean itWorked = false;	
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.CREATENEWPRODUCTPICTURE.getQuery());
		ResultSet rs = null;
		ps.setLong(1, prodId);
		ps.setLong(2, picId);

		
		itWorked = ps.executeUpdate() > 0 ? true : false;
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		
		return itWorked;
		
	}

	@Override
	public boolean removeProductPicture(long prodId, long picId) {
		boolean itWorked = false;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.REMOVEPRODUCTPICTURE.getQuery());
		ps.setLong(1, prodId);
		ps.setLong(2, picId);
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return itWorked;
   }
	

}
