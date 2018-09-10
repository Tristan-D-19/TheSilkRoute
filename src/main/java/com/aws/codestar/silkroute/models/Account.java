package com.aws.codestar.silkroute.models;

import javax.persistence.*;

/**
 * This Class is a representation of a user's account. The account handles transactions and other financial information. 
 *
 */

@Entity
@Table(name="tsr_account")
public class Account {
	
	@Id
	@Column
    private long account_id;
	
	@Basic
	@Column
    private long user_id;
	
	@Basic 
	@Column
    private double balance; 


    public Account(long accountId, long userId){ 
        account_id = accountId;
        user_id = userId;
    }
 
	public long getAccount_id()
	{
		return this.account_id;
	}

	public void setAccount_id(long accountId)
	{
		this.account_id = accountId;
	}

	public long getUser_id()
	{
		return this.user_id;
	}

	public void setUserid(long userId)
	{
		this.user_id = userId;
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