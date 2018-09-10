package com.aws.codestar.silkroute.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * This class represents a product or service provided by users in the TSR application.
 */

@Entity
public class Product{ 

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_gen", initialValue = 50000000, allocationSize = 100)
    private long product_id; 
	 
	 @Column(name="product_name")
    private String product_name; 
	 
	 @ManyToOne
    private User seller;
	 
	@ManyToMany
	private List<Department> departments = new ArrayList<Department>();
	

	@Column(name="quantity")
    private int quantity;
	
	@Column(name="price")
    private double price;
    
    @Column(name="product_description")
    private String product_description;

	public long getProduct_id()
	{
		return this.product_id;
	}

	public void setProduct_id( long productId )
	{
		this.product_id = productId ;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public String getProduct_name()
	{
		return this.product_name;
	}

	public void setProduct_name(String productName )
	{
		this.product_name = productName ;
	}
	  public User getSeller() {
			return seller;
		}
	
		public void setSeller(User seller) {
			this.seller = seller;
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