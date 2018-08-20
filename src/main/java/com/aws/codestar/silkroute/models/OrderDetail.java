package com.aws.codestar.silkroute.models;


public class OrderDetail{ 

    private long order_id;
    private long product_id;
    private double price;
    private int order_quantity;

    public OrderDetail(long order_id, long product_id){
        this.order_id = order_id;
        this.product_id = product_id;
    }
	public long getOrder_id()
	{
		return this.order_id;
	}

	public void setOrder_id(long order_id)
	{
		this.order_id = order_id;
	}

	public long getProduct_id()
	{
		return this.product_id;
	}

	public void setProduct_id(long product_id)
	{
		this.product_id = product_id;
	}

	public double getPrice()
	{
		return this.price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getOrder_quantity()
	{
		return this.order_quantity;
	}

	public void setOrder_quantity(int order_quantity)
	{
		this.order_quantity = order_quantity;
	}

}