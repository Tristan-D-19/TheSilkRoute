package com.aws.codestar.silkroute.models;
import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
@Table(name="tsr_product_review")
public class ProductReview{

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//     @SequenceGenerator(name = "review_id_gen", sequenceName = "review_id_gen", initialValue = 50000000, allocationSize = 100)
    private long reviewId;
	 
	 @OneToOne
	private User user;
	
	 @OneToOne
	private Product product;
	 
	 @Column(name="review_body", nullable=false)
    private String reviewBody;
	 @Column(name="rating", nullable=false)
	private int rating;
	 
	 @Column(name="creation_date", nullable=false)
	private Date creationDate;



	protected ProductReview() {
		
	}
	
    public ProductReview(User user, Product product, String review_body, int rating, Date creation_date){
        this.user = user;
        this.reviewBody = review_body;
		this.rating = rating;
		this.product = product;
		this.creationDate = creation_date;

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
	public String getReviewBody() {
		return reviewBody;
	}
	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}
	
	public long getReview_id()
	{
		return this.reviewId;
	}

	public Date getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public void setReviewId(long reviewId)
	{
		this.reviewId = reviewId;
	}

	public String getReviewbody()
	{
		return this.reviewBody;
	}

	public void setReviewbody(String reviewBody)
	{
		this.reviewBody = reviewBody;
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