package com.aws.codestar.silkroute.models;
import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
public class ProductReview{

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     @SequenceGenerator(name = "review_id_gen", sequenceName = "review_id_gen", initialValue = 50000000, allocationSize = 100)
    private long review_id;
	 
	 @OneToOne
	private User user;
	
	 @OneToOne
	private Product product;
	 
	 @Column(name="review_body")
    private String review_body;
	 @Column(name="rating")
	private int rating;
	 
	 @Column(name="creation_date")
	private Date creation_date;



    public ProductReview(User user, Product product, String review_body, int rating, Date creation_date){
        this.user = user;
        this.review_body = review_body;
		this.rating = rating;
		this.product = product;
		this.creation_date = creation_date;

	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getReview_body() {
		return review_body;
	}
	public void setReview_body(String review_body) {
		this.review_body = review_body;
	}
	
	public long getReview_id()
	{
		return this.review_id;
	}

	public Date getCreation_date()
	{
		return this.creation_date;
	}

	public void setCreation_date(Date creation_date)
	{
		this.creation_date = creation_date;
	}

	public void setReview_id(long review_id)
	{
		this.review_id = review_id;
	}

	public String getReviewbody()
	{
		return this.review_body;
	}

	public void setReviewbody(String reviewBody)
	{
		this.review_body = reviewBody;
	}

	public int getRating()
	{
		return this.rating;
	}

	public void setRating(int rating)
	{
		this.rating = rating;
	}


}