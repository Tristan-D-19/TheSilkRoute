package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;


/**
 * ProductDAOI is an interface that defines methods and Strings for CRUD operations on the TSR_Product table.
 */
public interface ProductDAOI { 

    
    enum SQL {
        GETPRODUCTSBYDEPARTMENT("SELECT * FROM TSR_PRODUCT WHERE DEPARMENT_ID=?"),
        GETPRODUCTSBYUSER("SELECT * FROM TSR_PRODUCT WHERE SELLER_ID=?"), 
        SUBTRACTPRODUCTQUANTITY("UPDATE TSR_PRODUCT SET QUANTITY=QUANTITY-? WHERE PRODUCT_ID=?"),
        ADDPRODUCTQUANTITY("UPDATE TSR_PRODUCT SET QUANTITY=QUANTITY+? WHERE PRODUCT_ID=?"),
        CREATENEWPRODUCT("INSERT INTO TSR_PRODUCT (PRODUCT_ID, PRODUCT_NAME, SELLER_ID, DEPARMENT_ID, QUANTITY, PRICE, PRODUCT_DESCRIPTION) VALUES (?,?,?,?,?,?,?)"),
        REMOVEPRODUCT("DELETE FROM TSR_PRODUCT WHERE PRODUCT_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
        }
        
        
    }

    /**getProductsByDepartment gets all of the products by the department 
     * @param departmentId the department's id
     * @return a list of products type List
     */
    public List<Product> getProductsByDepartment(long departmentId);


    /**
     * getProductsByUser gets a list of the user's products 
     * @param userId the user's ID 
     * @return A list of user products type List
     */
    public List<Product> getProductsByUser(long userId);


    /**
     * subtractProductQuantity subtracts a quantity from a product
     * @param amount the amount to subtract
     * @param productId the product's Id.
     * @return quantity the product's new quantity
     */

     public int subtractProductQuantity(double amount, long productId);


     /**
      * 
      * addProductQuantity adds to a products quantity
      * @param amount the amount to add
      *@param productId the products Id
      * @return the products new quantity
      */

      public int addProductQuantity(long productId);


      /**createNewProduct creates a new product in the table TSR_PRODUCT
       * @param product a new product object
       * @return A boolean value indicating that the new product was created. 
       */
      public boolean createNewProduct(Product product);


      /**
       * removeProduct removes a product from the table TSR_PRODUCT
       * @param productId the products ID 
       * @return a boolean value indacating if the product was succesfully deleted. 
       */
      public boolean removeProduct(long productId);
}