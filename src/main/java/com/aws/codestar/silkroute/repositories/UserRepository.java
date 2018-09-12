package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aws.codestar.silkroute.models.User;

@Repository
@Transactional
public interface UserRepository  extends JpaRepository <User, Long> {
	 
		/**
		 * getUserByEmail gets a user from the table TSR_USER by email
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
//		  @Query("UPDATE TSR_USER u SET u.IS_ACTIVE =0 WHERE u.USER_ID=?")
//		  boolean deActivateUser(long user_id);
		  
		  
		  /**
			 * reActivateUser reactivates a user from using the application 
			 * @param userId the user's Id
			 * @return a boolean indicating the user is reactivated
			 */
//		  @Query("UPDATE TSR_ADMIN.TSR_USER u SET u.ACTIVE =1 WHERE u.USER_ID= :user_id ")
//		  boolean reActivateUser(@Param("user_id") long user_id);
		  
		  
			/**
			 * changeUserPassword changes a user's encrypted password 
			 * @param encryptedPassword the new encrypted password
			 * @param userId the user's Id 
			 */
//		  @Query("UPDATE TSR_ADMIN.TSR_USER SET ENCRYPTED_PASSWORD= :encryptedPassword WHERE u.USER_ID= :user_id")
//		  boolean changeUserPassword(String encryptedPassword, long user_id);
		  
		  
		
}
