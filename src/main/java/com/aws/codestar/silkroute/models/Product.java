package com.aws.codestar.silkroute.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * This class represents a product or service provided by users in the TSR application.
 */

@Entity
@Table(name="tsr_product")
public class Product{ 

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//     @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_gen", initialValue = 50000000, allocationSize = 100)
    private long productId; 
	 
	 @Column(name="product_name", nullable=false)
    private String productName; 
	 
	 @ManyToOne
    private User seller;
	 
	@ManyToMany
	private List<Department> departments = new ArrayList<Department>();
	

	@Column(name="quantity", nullable=false)
    private int quantity;
	
	@Column(name="price", nullable=false)
    private double price;
    
    @Column(name="product_description", nullable=false)
    private String productDescription;

    protected Product() {
    	
    }
    
	public long getProductId()
	{
		return this.productId;
	}

	public void setProductId( long productId )
	{
		this.productId = productId ;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public String getProductName()
	{
		return this.productName;
	}

	public void setProductName(String productName )
	{
		this.productName = productName ;
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

	public String getProductDescription()
	{
		return this.productDescription;
	}

	public void setProductDescription(String productDescription)
	{
		this.productDescription = productDescription;
	}

}