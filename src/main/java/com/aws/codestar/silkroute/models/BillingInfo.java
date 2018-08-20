package com.aws.codestar.silkroute.models;

/**
 * This class is a representation of billing information for a user's account. No credit card information is stored within. 
 * We will use Stripe for processing transaction and passing this information to stripe; 
 */
public class BillingInfo{ 

    private long billing_id;
    private long acc_id;
    private String billing_address;
    private String billing_state; 
    private long stripe_id;

	public long getBilling_id()
	{
		return this.billing_id;
	}

	public void setBilling_id(long billing_id)
	{
		this.billing_id = billing_id;
	}

	public long getAcc_id()
	{
		return this.acc_id;
	}

	public void setAcc_id(long acc_id)
	{
		this.acc_id = acc_id;
	}

	public String getBilling_address()
	{
		return this.billing_address;
	}

	public void setBilling_address(String billing_address)
	{
		this.billing_address = billing_address;
	}

	public String getBilling_state()
	{
		return this.billing_state;
	}

	public void setBilling_state(String billing_state )
	{
		this.billing_state = billing_state ;
	}

	public long getStripe_id()
	{
		return this.stripe_id;
	}

	public void setStripe_id(long stripe_id)
	{
		this.stripe_id = stripe_id;
	}
 
}