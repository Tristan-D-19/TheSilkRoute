package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;

/**
 * AccountDAOI provides access to the database for the table Accounts
 * 
 * 
 */
public interface AccountDAOI {
	
	enum SQL {
		GETACCOUNTBYUSERID("SELECT * FROM TSR_ACCOUNT WHERE USER_ID=?"),
		ADDMONEYTOACCOUNT("UPDATE TSR_ACCOUNT SET ACCOUNT_BALANCE = ACCOUNT_BALANCE + ? WHERE USER_ID = ?"),
		TAKEMONEYFROMACCOUNT("UPDATE ACCOUNT SET ACCOUNT_BALANCE = ACCOUNT_BALANCE - ? WHERE USER_ID = ? ");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
	}
	
	
	/**
	 * getAccountByUserId grabs a user's financial account for TSR transactions
	 * @param userId the user id of for the account 
	 * @return the user's account type <Account>
	 */

	public Account getAccountByUserId(long userId);
	
	/**
	 * addMoneytoAccount add's money to a user's account with the given id and amount
	 * @param amount the amount of money to add to the user's account balance 
	 * @return the adjusted amount from the users account
	 */
	public double addMoneyToAccount(double amount, long userId);

	/**
	 * takeMoneyFromAccount subtract money from a user's account with the given amount and the id 
	 * @param amount the amount to subtract from the user's account balance 
	 * @param userId the user's id 
	 * @return the updated balance for the user
	 */

	public double takeMoneyFromAccount(double amount, long userId);
	
}
