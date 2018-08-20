package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;




/**
 * OrderDAOI is an interface that defines methods for getting order's from the TSR_ORDER table.
 */
public interface OrderDAOI{ 

    
    enum SQL {
		GETALLUSERSORDERSBYID("SELECT * FROM TSR_ORDER WHERE CUSTOMER_ID=?"),
        GETORDERBYDATE("SELECT * FROM TSR_ORDER WHERE ORDER_DATE=?"),
        GETORDERBYID("SELECT * FROM TSR_ODER WHERE ORDER_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
    }

    /**
     * getAllUsersOrdersById gets all of a users orders.
     * @param userId the user's ID 
     * @return A list of orders type List
     */
    public List<Order> getAllUsersOrdersById(long userId);

    /**
     * getOrdersByDate gets all orders on a specified date
     * @param date the date of the order(s)
     * @return a List of Orders type List
     */
    public List<Order> getOrdersByDate(String date);

    /**
     * getOrderByid returns an order specified by the ID
     * @param orderId the order's Id
     * @return a list of Orders type List
     */
    public Order getOrderById(long orderId);

}
