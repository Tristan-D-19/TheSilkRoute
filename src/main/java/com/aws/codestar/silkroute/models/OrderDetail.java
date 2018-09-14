package com.aws.codestar.silkroute.models;

import javax.persistence.*;

@Entity
@Table(name="tsr_order_detail")

public class OrderDetail{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
	 
	@OneToOne(cascade = {CascadeType.ALL})
    private Product product;
   
	@ManyToOne(cascade = {CascadeType.ALL})
	private Order order;

	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="quantity", nullable=false)
    private int orderQuantity;

	protected OrderDetail(){
		
	}
	
    public OrderDetail( Product product, int quantity, Order order){
    	this.orderQuantity = quantity;
        this.product = product;
        this.order = order;
    }
	public long getOrderId()
	{
		return this.orderId;
	}

	public void setOrderId(long orderId)
	{
		this.orderId = orderId;
	}
	
 public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}


	public double getPrice()
	{
		return this.price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getOrderQuantity()
	{
		return this.orderQuantity;
	}

	public void setOrderQuantity(int order_quantity)
	{
		this.orderQuantity = order_quantity;
	}
	
	public void setItemPrice() {
		this.price = this.product.getPrice() * this.orderQuantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}