package com.aws.codestar.silkroute.models;
/**
 * This class represents a product or service provided by users in the TSR application.
 */
public class Product{ 


    private long product_id; 
    private String product_name; 
    private long seller_id; 
    private int department_id;
    private int quantity;
    private double price;
    private String product_description;

	public long getProduct_id()
	{
		return this.product_id;
	}

	public void setProduct_id( long productId )
	{
		this.product_id = productId ;
	}

	public String getProduct_name()
	{
		return this.product_name;
	}

	public void setProduct_name(String productName )
	{
		this.product_name = productName ;
	}

	public long getSellerId()
	{
		return this.seller_id;
	}

	public void setSeller_id(long sellerId )
	{
		this.seller_id = sellerId ;
	}

	public int getDepartment_id()
	{
		return this.department_id;
	}

	public void setDepartment_id(int departmentId)
	{
		this.department_id = departmentId;
	}

	public int getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public double getPrice()
	{
		return this.price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public String getProduct_description()
	{
		return this.product_description;
	}

	public void setProduct_description(String productDescription)
	{
		this.product_description = productDescription;
	}

}