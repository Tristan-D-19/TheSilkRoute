package com.aws.codestar.silkroute.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * This class represents the orders for a customer's purchase
 * 
 */

@Entity
public class Order{

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "order_id_gen", sequenceName = "order_id_gen", initialValue = 50000000, allocationSize = 100)
    private long order_id;
	
	@OneToOne
    private User customer;
	
	@Column(name="creation_date")
    private Date creation_date;
	
	@Column(name="shipping_date")
    private Date shipping_date;
	
	@Column(name="order_price")
    private double order_price;
    
    @OneToMany
    private List<OrderDetail> items = new ArrayList<OrderDetail>();

    public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public List<OrderDetail> getItems() {
		return items;
	}
	public void setItems(List<OrderDetail> items) {
		this.items = items;
	}
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