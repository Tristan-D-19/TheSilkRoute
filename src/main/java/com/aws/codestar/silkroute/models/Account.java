package com.aws.codestar.silkroute.models;

/**
 * This Class is a representation of a user's account. The account handles transactions and other financial information. 
 *
 */
public class Account {
    private long account_id;
    private long user_id;
    private float balance; 


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

	public float getBalance()
	{
		return this.balance;
	}

	public void setBalance(float balance )
	{
		this.balance = balance ;
	}

     
}