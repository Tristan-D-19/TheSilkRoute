package com.aws.codestar.silkroute.models;

import java.sql.Date;

/**
 * This class represents the orders for a customer's purchase
 * 
 */
public class Order{

    private long order_id;
    private long customer_id;
    private Date creation_date;
    private Date shipping_date;
    private double order_price;

    //create a new order with the customers id and the current date
    public Order(long customer_id, Date creationDate){

    }
	public long getOrder_id()
	{
		return this.order_id;
	}

	public void setOrder_id(long order_id)
	{
		this.order_id = order_id;
	}

	public long getCustomer_id()
	{
		return this.customer_id;
	}

	public void setCustomer_id(long customer_id){
	
		this.customer_id = customer_id;
	}

	public Date getCreation_date()
	{
		return this.creation_date;
	}

	public void setCreation_date(Date creation_date)
	{
		this.creation_date = creation_date;
	}

	public Date getShipping_date()
	{
		return this.shipping_date;
	}

	public void setShipping_date(Date shipping_date)
	{
		this.shipping_date = shipping_date;
	}

	public double getOrder_price()
	{
		return this.order_price;
	}

	public void setOrder_price(double order_price)
	{
		this.order_price = order_price;
	}


}