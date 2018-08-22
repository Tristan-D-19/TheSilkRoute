package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;



/**
 * UserDAOI is an interface for crud operations to the TSR_USER table. 
 */
public interface UserDAOI { 

    
    enum SQL {
		CREATEUSER("INSERT INTO TSR_ADMIN.TSR_USER (EMAIL, FIRST_NAME, LAST_NAME, ENCRYTED_PASSWORD, USER_TYPE, ACTIVE ) VALUES (?,?,?,?,0, 1)"),
		CREATEADMINUSER("INSERT INTO TSR_ADMIN.TSR_USER (EMAIL, FIRST_NAME, LAST_NAME, ENCRYTED_PASSWORD, USER_TYPE, ACTIVE ) VALUES (?,?,?,?,1, 1)"),
		DELETEUSERBYID("DELETE FROM TSR_ADMIN.TSR_USER WHERE USER_ID=?, ACTIVE=0"),
		DEACTIVATEUSER("UPDATE TSR_ADMIN.TSR_USER SET ACTIVE =0 WHERE USER_ID=?"), 
		UPDATEUSER("UPDATE TSR_ADMIN.TSR_USER SET EMAIL=?, FIRST_NAME=?, LAST_NAME=?, ADDRESS=?,CITY=?, STATE=?, ZIPCODE=?, PHONE NUMBER =?,PROFILE_PIC=?"),
		GETALLUSERS("SELECT EMAIL, FIRST_NAME, ZIPCODE, PROFILE_PIC FROM TSR_ADMIN.TSR_USER"),
		ADMINGETALLUSERS("SELECT * FROM TSR_ADMIN.TSR_USER"), 
		GETUSERBYID("SELECT * FROM TSR_ADMIN.TSR_USER WHERE USER_ID=?"),
		GETUSERBYEMAIL("select * from tsr_admin.tsr_user where EMAIL=?"),
		CHANGEUSERPASSWORD("UPDATE TSR_ADMIN.TSR_USER SET ENCRYTED_PASSWORD=? WHERE USER_ID=");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
	}
	
	/**
	 * createUser takes in a User object and creates a new User in the data base
	 * @param user the user to be created
	 * @return A new generated ID from the database.
	 */
	public long createUser(User user);

	/**
	 * createAdminUser takes in a user object and creates a new admin user
	 * @param user the user to be created
	 * @return A new generated ID from the database.
	 */
	public long createAdminUser(User user);
	/**
	 * deleteUserById removes a deactivated user from the database if the user has already been deactivated
	 * This function may only be called by an admin user
	 * @param userId the user's ID
	 * @return boolean indicating if the deletion was successfull 
	 */
	public boolean deleteUserById(long userId);

	/**
	 * deactivateUser deactivates a user from using the application 
	 * @param userId the user's Id
	 * @return a boolean indicating the user is deactivated
	 */
	public boolean deactivateUser(long userId);

	/**
	 * updateUser updates a user's information in the database
	 * @param user a user object with all of the data to be updated.
	 * @return a boolean indicating the update was successfull
	 */
	public boolean updateUser(User user);

	/**
	 * getAllUsers retrieves all active users from the database retrieves email, first name, zipcode and profile pic
	 * this function will be used for searching user's while securing data
	 * @return a list of all active user's from the database. type List
	 */
	public List<User> getAllUsers();

	/**
	 * adminGetAllUsers gets all users from the database
	 * @param userId the user's id to verify if they are an admin
	 * @return a list of all users type List
	 */
	public List<User> adminGetAllUsers();

	/**
	 * getUserById gets a user from the table TSR_USER by id
	 * @return a user from the database
	 */
	public User getUserById(long userId);

	/**
	 * getUserByEmail gets a user from the table TSR_USER by email
	 * @param email the user's Email
	 * @return a user from the database
	 */
	public User getUserByEmail(String email);

	/**
	 * changeUserPassword changes a user's encrypted password 
	 * @param encryptedPassword the new encrypted password
	 * @param userId the user's Id 
	 */
	public boolean changeUserPassword(String encryptedPassword, long userId );
}