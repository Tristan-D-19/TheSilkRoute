package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;

/**
 * ProductReviewDAOI is an interface for CRUD operations on the table TSR_PRODUCT
 */

public interface ProductReviewDAOI { 

    
    enum SQL {
		CREATEPRODUCTREVIEW("INSERT INTO TSR_PRODUCT_REVIEW (USER_ID, REVIEW, RATING) VALUES (?,?,?)"),
		GETPRODUCTREVIEWBYPRODUCT("SELECT * FROM TSR_PRODUCT_REVIEW WHERE PRODUCT_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
	}
	
	/**
	 * getProductReview gets all product reviews for a product 
	 * @param productId the product's ID 
	 * @return a list of ProductReviews type List 
	 */
	public List<ProductReview> getProductReviews(long productId);

	/**
	 * createProductReview creates a product review for a product
	 * @param userId the user's ID 
	 * @param reviewBody the body of the review 
	 * @param rating the user's rating from 1-10
	 * @return boolean indicating the review was successfully created
	 */
	public boolean createProductReview(long userId, String reviewBody, int Rating);
}