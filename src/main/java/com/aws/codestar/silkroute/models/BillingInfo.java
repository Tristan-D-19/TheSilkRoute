package com.aws.codestar.silkroute.models;
import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;
/**
 * This class is a representation of billing information for a user's account. No credit card information is stored within. 
 * We will use Stripe for processing transaction and passing this information to stripe; 
 */

@Entity
public class BillingInfo{ 

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
   @SequenceGenerator(name = "billing_id_gen", sequenceName = "billing_id_gen", initialValue = 50000000, allocationSize = 100)
    private long billing_id;
	
	@ManyToOne
    private Account account;
	
	@Column(name="billing_address")
    private String billing_address;
	
	@Column(name="billing_state")
    private String billing_state; 
	
	@Column(name="stripe_id")
	private long stripe_id;
	@Column(name="billing_date")
	private Date billing_date;
	
	@Column(name="billing_zip")
	private int billing_zip;


	public int getBilling_zip()
	{
		return this.billing_zip;
	}

	public void setBilling_zip(int billing_zip)
	{
		this.billing_zip = billing_zip;
	}

	public Date getBilling_date()
	{
		return this.billing_date;
	}

	public void setBilling_date(Date billing_date)
	{
		this.billing_date = billing_date;
	}

	public long getBilling_id()
	{
		return this.billing_id;
	}

	public void setBilling_id(long billing_id)
	{
		this.billing_id = billing_id;
	}

	public Account getAccount()
	{
		return this.account;
	}

	public void setAcc_id(Account account)
	{
		this.account = account;
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