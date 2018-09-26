package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aws.codestar.silkroute.models.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	
	/**
	 * addMoneytoAccount add's money to a user's account with the given id and amount
	 * @param amount the amount of money to add to the user's account balance 
	 *  @param accountId the account id
	 * @return the updated balnace from the users account
	 */
	@Modifying
	@Query("update Account a set a.balance = (a.balance + :amount) where a.accountId = :accountId")
	public int addMoneyToAccount(@Param("amount")double amount,@Param("accountId") long accountId);

	/**
	 * takeMoneyFromAccount subtract money from a user's account with the given amount and the id 
	 * @param amount the amount to subtract from the user's account balance 
	 * @param accountId the account id 
	 * @return the updated balance for the user
	 */
	@Modifying
	@Query("update Account a set a.balance = a.balance - :amount where a.accountId = :accountId")
	public int takeMoneyFromAccount(@Param("amount") double amount,@Param("accountId") long accountId);
	
}
