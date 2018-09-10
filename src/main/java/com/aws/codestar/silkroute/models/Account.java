package com.aws.codestar.silkroute.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * This Class is a representation of a user's account. The account handles transactions and other financial information. 
 *
 */
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "account_id_gen", sequenceName = "account_id_gen", initialValue = 50000000, allocationSize = 100)
    private long account_id;
	
	@OneToOne
    private User user;
	
	

	@Column(name="balance")
    private double balance; 


    public Account(long accountId, User user){ 
        account_id = accountId;
        this.user = user;
    }
 
    
	public long getAccount_id()
	{
		return this.account_id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAccount_id(long accountId)
	{
		this.account_id = accountId;
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