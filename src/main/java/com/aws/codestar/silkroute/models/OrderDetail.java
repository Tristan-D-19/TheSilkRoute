package com.aws.codestar.silkroute.models;

import javax.persistence.*;

@Entity
@Table(name="tsr_order_detail")
public class OrderDetail{ 
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//     @SequenceGenerator(name = "order_det_id_gen", sequenceName = "order_det_id_gen", initialValue = 50000000, allocationSize = 100)
    private long orderId;
	 
	@OneToOne 
    private Product product;
   

	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="quantity", nullable=false)
    private int orderQuantity;

	protected OrderDetail(){
		
	}
	
    public OrderDetail(long orderId, Product product){
        this.orderId = orderId;
        this.product = product;
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

}