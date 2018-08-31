package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;

/**
 * ProductReviewDAOI is an interface for CRUD operations on the table TSR_PRODUCT
 */

public interface ProductReviewDAOI { 

    
    enum SQL {
		CREATEPRODUCTREVIEW("INSERT INTO TSR_ADMIN.TSR_PRODUCT_REVIEW (USER_ID, PRODUCT_ID, REVIEW_ID, RATING) VALUES (?,?,?,?)"),
		GETPRODUCTREVIEWSBYPRODUCTID("SELECT * FROM TSR_ADMIN.TSR_PRODUCT_REVIEW WHERE PRODUCT_ID=?"), 
		DELETEPRODUCTREVIEWBYID("DELETE FROM TSR_ADMIN.TSR_PRODUCT_REVIEW WHERE REVIEW_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
	}
	
	/**
	 * getProductReviewsByProductId gets all product reviews for a product 
	 * @param productId the product's ID 
	 * @return a list of ProductReviews type List 
	 */
	public List<ProductReview> getProductReviewsByProductId(long productId);

	/**
	 * createProductReview creates a product review for a product
	 * @param userId the user's ID 
	 * @param product_id the product's ID
	 * @param reviewBody the body of the review 
	 * @param rating the user's rating from 1-10
	 * @return the generated key, type long
	 */
	public long createProductReview(long userId, long product_id, String reviewBody, int rating);


	/**
	 * deleteProductReviewById removes a user's review 
	 * @param review_id the review id 
	 * @return boolean indicating if the removal was successful
	 */
	
	public boolean deleteProductReviewById(long review_id);
}