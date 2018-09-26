package com.aws.codestar.silkroute.models;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name="tsr_product_review")

public class ProductReview{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;
	 
	 @OneToOne(cascade = {CascadeType.ALL})
	private User user;
	
	 @OneToOne(cascade = {CascadeType.ALL})
	private Product product;
	 
	 @Column(name="review_body", nullable=false)
    private String reviewBody;
	 @Column(name="rating", nullable=false)
	private int rating;
	 
	 @Column(name="creation_date", nullable=false)
	private Date creationDate;



	protected ProductReview() {
		
	}
	
    public ProductReview(User user, Product product, String review_body, int rating){
        this.user = user;
        this.reviewBody = review_body;
		this.rating = rating;
		this.product = product;
		this.creationDate = new Date(Calendar.getInstance().getTime().getTime());
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