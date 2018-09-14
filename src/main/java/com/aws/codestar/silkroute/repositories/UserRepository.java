package com.aws.codestar.silkroute.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aws.codestar.silkroute.models.User;


public interface UserRepository  extends CrudRepository <User, Long> {
	 
		/**
		 * findByEmail gets a user from the table TSR_USER by email
		 * @param email the user's Email
		 * @return a user from the database
		 */
//		@Query("select u from tsr_admin.tsr_user u where LOWER(u.EMAIL) = LOWER(:email)")
		 public User findByEmail(String email);
		  
		
		/**
		 * deActivateUser deactivates a user from using the application 
		 * @param userId the user's Id
		 * @return a boolean indicating the user is deactivated
		 */
		  @Query("UPDATE User u SET u.active =0 WHERE u.userId= :user_id")
		  boolean deActivateUser(long user_id);
		  
		  
		  /**
			 * reActivateUser reactivates a user from using the application 
			 * @param userId the user's Id
			 * @return a boolean indicating the user is reactivated
			 */
		  @Query("UPDATE User u SET u.active =1 WHERE u.userId = :user_id ")
		  boolean reActivateUser(@Param("user_id") long user_id);
		  
		  
			/**
			 * changeUserPassword changes a user's encrypted password 
			 * @param encryptedPassword the new encrypted password
			 * @param userId the user's Id 
			 */
		  @Query("update User u SET u.password = :encryptedPassword WHERE u.userId= :user_id")
		  boolean changeUserPassword(@Param("encryptedPassword") String encryptedPassword, @Param("user_id") long user_id);
		  
		  
		
		  /**
			 * getAllUsers retrieves all active users from the database retrieves email, first name, zipcode and profile pic
			 * this function will be used for searching user's while securing data
			 * @return a list of all active user's from the database. type List
			 */
		  	@Query("SELECT u.email, u.firstName, u.zipcode, u.profilePic FROM User u where u.active =1")
			public List<User> findAllUsers();
		  	
		  	@Query("SELECT u FROM User u where u.active =true")
		    @Transactional(readOnly =true)
		    public List<User> readAll();
		  	
		  
		
}
