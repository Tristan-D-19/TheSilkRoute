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
@Table(name="tsr_billing_info")
public class BillingInfo{ 

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//   @SequenceGenerator(name = "billing_id_gen", sequenceName = "billing_id_gen", initialValue = 50000000, allocationSize = 100)
    private long billingId;
	
	public BillingInfo(String billingAddress, String billingState, long stripeId, Date billingDate,
			int billingZip) {
		super();
		this.billingAddress = billingAddress;
		this.billingState = billingState;
		this.stripeId = stripeId;
		this.billingDate = billingDate;
		this.billingZip = billingZip;
	}

	protected BillingInfo() {
		
	}
	
	@ManyToOne
    private Account account;
	
	@Column(name="billing_address")
    private String billingAddress;
	
	@Column(name="billing_state")
    private String billingState; 
	
	@Column(name="stripe_id")
	private long stripeId;
	@Column(name="billing_date")
	private Date billingDate;
	
	@Column(name="billing_zip")
	private int billingZip;


	public int getBillingZip()
	{
		return this.billingZip;
	}

	public void setBillingZip(int billingZip)
	{
		this.billingZip = billingZip;
	}

	public Date getBillingDate()
	{
		return this.billingDate;
	}

	public void setBillingDate(Date billingDate)
	{
		this.billingDate = billingDate;
	}

	public long getBillingId()
	{
		return this.billingId;
	}

	public void setBillingId(long billingId)
	{
		this.billingId = billingId;
	}

	public Account getAccount()
	{
		return this.account;
	}

	public void setAcc_id(Account account)
	{
		this.account = account;
	}

	public String getBillingAddress()
	{
		return this.billingAddress;
	}

	public void setBillingAddress(String billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public String getBillingState()
	{
		return this.billingState;
	}

	public void setBillingState(String billingState )
	{
		this.billingState = billingState ;
	}

	public long getStripeId()
	{
		return this.stripeId;
	}

	public void setStripeId(long stripeId)
	{
		this.stripeId = stripeId;
	}
 
}