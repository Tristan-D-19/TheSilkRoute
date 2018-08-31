package com.aws.codestar.silkroute.DAO;
import java.util.List;
import com.aws.codestar.silkroute.models.ProductReview;
import java.util.List;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;
import java.sql.Connection;

public class ProductReviewDAO extends AbstractDAO implements ProductReviewDAOI {

@Override
public long createProductReview(long userId, long product_id, String reviewBody, int rating) {
	boolean itWorked = false;
	long productGenKey = 0;

	
	
	getConnection();
	try{
	PreparedStatement ps = conn.prepareStatement(SQL.CREATEPRODUCTREVIEW.getQuery(),  new String[]
	{ "PRODUCT_ID" });
	ResultSet rs = null;
	ps.setLong(1, userId);
	ps.setLong(2, product_id);
	ps.setString(3, reviewBody);
	ps.setInt(4,rating);
	
	itWorked = ps.executeUpdate() > 0 ? true : false;
	if(!itWorked)
	  {
	 rs = ps.getGeneratedKeys();  
	  }
	  if (rs != null && rs.next() && itWorked) 
		{
			productGenKey = rs.getLong(1);
		}   
} catch (SQLException e) {
   
	e.printStackTrace();
} finally {
	closeConnection();
}
	
	return productGenKey;
	
}

@Override
	public List<ProductReview>  getProductReviewsByProductId(long productId) {
		List<ProductReview> productReviews = new ArrayList<ProductReview>();
    	
    	
    	 getConnection();
         try{
         PreparedStatement ps = conn.prepareStatement(SQL.GETPRODUCTREVIEWSBYPRODUCTID.getQuery());
		 ps.setLong(1, productId);
		 ResultSet rs = ps.executeQuery();
         
         while(rs.next()) {
        	 ProductReview row = new ProductReview(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
				productReviews.add(row);	
			}
     } catch (SQLException e) {
        
         e.printStackTrace();
     } finally {
         closeConnection();
     }
         return productReviews;
	}


	@Override
	public boolean deleteProductReviewById(long review_id) {
		boolean itWorked = false;
		getConnection();
		try{
		PreparedStatement ps = conn.prepareStatement(SQL.DELETEPRODUCTREVIEWBYID.getQuery());
		ps.setLong(1, review_id);
		itWorked = ps.executeUpdate() > 0 ? true : false;
		
	
	} catch (SQLException e) {
	   
		e.printStackTrace();
	} finally {
		closeConnection();
	}
		return itWorked;
   }

}

	

