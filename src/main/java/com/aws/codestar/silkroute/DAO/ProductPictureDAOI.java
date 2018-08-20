package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;

/**
 * ProductPictureDAOI is an interface for CRUD operations on product pictures from the table TSR_PRODUCT_PICTURE
 */
public interface ProductPictureDAOI { 

    
    enum SQL {
		GETPICTURESBYPRODUCT("SELECT * FROM TSR_PRODUCT_PICTURE WHERE PRODUCT_ID=?"),
		CREATENEWPRODUCTPICTURE("INSERT INTO TSR_PRODUCT_PICTURE (PRODUCT_ID, PIC_ID) VALUES (?,?)"),
		REMOVEPRODUCTPICTURE("DELTE FROM TSR_PRODUCT_PICTURE WHERE PIC_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
	}
	
	/**
	 * getPicturesByProduct gets a list of product pictures 
	 * @param productId the product's ID 
	 * @return a list of Pictures type List
	 */
	public List<Picture> getPicturesByProduct(long productId);

	/**
	 * createNewProductPicture creates a new picture for a product 
	 * @param prodId the product Id 
	 * @param picId the picture id 
	 * @return a boolean indicating if the product picture was successfully created
	 */

	public boolean createNewProductPicture(long prodId, long picId);

	/**
	 * removeProductPicture removes a product picture 
	 * @param prodId the product id 
	 * @param picId the picture's Id 
	 * @return a boolean indicating the picture's removal was successfull 
	 */
	public boolean removeProductPicture(long prodId, long picId);
}