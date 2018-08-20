package com.aws.codestar.silkroute.models;

public class ProductReview{

    private long review_id;
    private long user_id;
    private String review_body;
    private int rating;


    public ProductReview(long user_id, String review_body, int rating){
        this.user_id = user_id;
        this.review_body = review_body;
        this.rating = rating;

    }
	public long getReview_id()
	{
		return this.review_id;
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