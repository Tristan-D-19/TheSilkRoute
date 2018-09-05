package com.aws.codestar.silkroute.models;

import javax.persistence.*;

@Entity
public class OrderDetail{ 
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     @SequenceGenerator(name = "order_det_id_gen", sequenceName = "order_det_id_gen", initialValue = 50000000, allocationSize = 100)
    private long order_id;
	 
	@OneToOne 
    private Product product;
   

	@Column(name="price")
	private double price;
	
	@Column(name="quantity")
    private int order_quantity;

    public OrderDetail(long order_id, Product product){
        this.order_id = order_id;
        this.product = product;
    }
	public long getOrder_id()
	{
		return this.order_id;
	}

	public void setOrder_id(long order_id)
	{
		this.order_id = order_id;
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

	public int getOrder_quantity()
	{
		return this.order_quantity;
	}

	public void setOrder_quantity(int order_quantity)
	{
		this.order_quantity = order_quantity;
	}

}