package com.aws.codestar.silkroute.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * This Class is a representation of a user's account. The account handles transactions and other financial information. 
 *
 */
@Entity
@Table(name="tsr_account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
	
	@OneToOne(cascade = {CascadeType.ALL})
    private User user;
	
	
	@OneToMany
	private List<BillingInfo> billingInfos;

	@Column(name="balance", nullable=false)
    private double balance; 


    public Account(double balance, User user){ 
        this.balance = balance;
        this.user = user;
    }
 
    protected Account() {
    	
    }
    
	public long getAccountId()
	{
		return this.accountId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAccountId(long accountId)
	{
		this.accountId = accountId;
	}

	public void deposit (double amount) {
		this.balance = this.balance + amount;
	}

	public void withdraw (double amount)
	{
		this.balance = this.balance - amount;
	}
	public double getBalance()
	{
		return this.balance;
	}

	public List<BillingInfo> getBillingInfos() {
		return billingInfos;
	}

	public void setBillingInfos(List<BillingInfo> billingInfos) {
		this.billingInfos = billingInfos;
	}

	public void setBalance(double balance )
	{
		this.balance = balance ;
	}

     
}