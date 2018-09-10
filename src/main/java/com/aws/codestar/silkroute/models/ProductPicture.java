package com.aws.codestar.silkroute.models;
import javax.persistence.*;

@Entity
public class ProductPicture{

	@OneToOne 
    private Product product;
	
	@OneToOne
    private Picture picture;
    
    
    
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