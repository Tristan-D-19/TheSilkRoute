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
@Table(name="tsr_order")
public class Order{

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//    @SequenceGenerator(name = "order_id_gen", sequenceName = "order_id_gen", initialValue = 50000000, allocationSize = 100)
    private long orderId;
	
	protected Order() {
		
	}
	
	@OneToOne
    private User customer;
	
	@Column(name="creation_date", nullable=false)
    private Date creationDate;
	
	@Column(name="shipping_date")
    private Date shippingDate;
	
	@Column(name="order_price", nullable=false)
    private double orderPrice;
    
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
	public long getOrderId()
	{
		return this.orderId;
	}

	public void setOrderId(long orderId)
	{
		this.orderId = orderId;
	}


	public Date getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public Date getShippingDate()
	{
		return this.shippingDate;
	}

	public void setShippingDate(Date shippingDate)
	{
		this.shippingDate = shippingDate;
	}

	public double getOrderPrice()
	{
		return this.orderPrice;
	}

	public void setOrderPrice(double orderPrice)
	{
		this.orderPrice = orderPrice;
	}


}