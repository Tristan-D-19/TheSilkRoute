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
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@SequenceGenerator(name = "account_id_gen", sequenceName = "account_id_gen", initialValue = 50000000, allocationSize = 100)
    private long accountId;
	
	@OneToOne
    private User user;
	
	

	@Column(name="balance", nullable=false)
    private double balance; 


    public Account(long accountId, User user){ 
        this.accountId = accountId;
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

	

	public double getBalance()
	{
		return this.balance;
	}

	public void setBalance(double balance )
	{
		this.balance = balance ;
	}

     
}