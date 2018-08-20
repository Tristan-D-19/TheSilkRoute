package com.aws.codestar.silkroute.models;

/**
 * This class represents the orders for a customer's purchase
 * 
 */
public class Order{

    private long order_id;
    private long customer_id;
    private String creation_date;
    private String shipping_date;
    private double order_price;

    //create a new order with the customers id and the current date
    public Order(long customer_id, String creationDate){

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

	public String getCreation_date()
	{
		return this.creation_date;
	}

	public void setCreation_date(String creation_date)
	{
		this.creation_date = creation_date;
	}

	public String getShipping_date()
	{
		return this.shipping_date;
	}

	public void setShipping_date(String shipping_date)
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