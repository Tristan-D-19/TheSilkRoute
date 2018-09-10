package com.aws.codestar.silkroute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aws.codestar.silkroute.models.User;

public interface UserRepository  extends JpaRepository <User, Long> {
	 
		@Query("select u from tsr_admin.tsr_user u where LOWER(u.EMAIL) = LOWER(:email)")
		  User getUserByEmail(@Param("email") String email);
		  
		  @Query("UPDATE TSR_ADMIN.TSR_USER u SET u.ACTIVE =0 WHERE u.USER_ID=?")
		  boolean deactivateUser(long user_id);
		  
		  boolean reactivateUser(long user_id);
		  
		  boolean ChangeUserPassword(String encryptedPassword);
		  
		  
		
}
