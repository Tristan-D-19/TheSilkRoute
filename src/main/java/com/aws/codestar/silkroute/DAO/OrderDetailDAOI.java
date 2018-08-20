package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;



/**
 * OrderDetailDAOI provides access to the database for the table ORDER_DETAILS
 * 
 * 
 */
public interface OrderDetailDAOI {
	
	enum SQL {
		CREATEORDERITEM("INSERT INTO TSR_ORDER_DETAILS (PRODUCT_ID, PRICE, QUANTITY) VALUES(?,?,?)"),
		GETALLORDERSBYID("SELECT * FROM TSR_ORDER_DETAILS WHERE ORDER_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
	}
	
	
	/** createOrderItem creates an order_detail item that is used to create an order which consist of multiple order details
	 * @param order_id the id used to reference an order
	 * @param product_id the id of the product that this order detail describes
	 * @param price the price of this order detail
	 * @param quantity the quantity of the product for this order detail
	 * @return the generated order id type long 
	 */

	public long createOrderItem(long product_id, double price, int quantity); 
	

	/** getAllOrdersById finds all order details relating to the order_id provided. This function is used to calculate a users order at checkout
	 * @param order_id the order id for the overall order
	 * @return a list of order details type List
	 */
	public List<OrderDetail> getAllOrdersById(long order_id);

	
}
