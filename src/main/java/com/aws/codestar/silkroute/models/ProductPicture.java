package com.aws.codestar.silkroute.models;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tsr_product_picture")
public class ProductPicture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//    @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_gen", initialValue = 50000000, allocationSize = 100)
	private long productPicId; 
	
	
	public long getProductPicId() {
		return productPicId;
	}
	public void setProductPicId(long productPicId) {
		this.productPicId = productPicId;
	}
	@OneToOne 
    private Product product;
	
	@OneToOne
    private Picture picture;
    
    
	protected ProductPicture() {
		
		
	}
    
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	

}