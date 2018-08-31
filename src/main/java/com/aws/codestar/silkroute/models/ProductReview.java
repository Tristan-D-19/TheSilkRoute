package com.aws.codestar.silkroute.models;
import java.sql.Date;
public class ProductReview{

    private long review_id;
	private long user_id;
	private long product_id;
    private String review_body;
	private int rating;
	private Date creation_date;

	



    public ProductReview(long user_id, long product_id, String review_body, int rating, Date creation_date){
        this.user_id = user_id;
        this.review_body = review_body;
		this.rating = rating;
		this.product_id = product_id;
		this.creation_date = creation_date;

	}
	public long getProductId(){
		return this.product_id;
	}
	public void setProductId(long product_id){
		this.product_id = product_id;
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

	public long getUser_id()
	{
		return this.user_id;
	}

	public void setUser_id(long user_id)
	{
		this.user_id = user_id;
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