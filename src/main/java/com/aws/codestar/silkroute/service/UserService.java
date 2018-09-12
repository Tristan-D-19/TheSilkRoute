package com.aws.codestar.silkroute.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.UserRepository;


@Service
@Repository
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepo;


	public List<User> adminGetAllUsers(){
		List<User> users = new ArrayList<User>();
		userRepo.findAll().forEach(users::add);
		return users;
	}
	
	public List<User> getAllUsers(){
		return null;
		
	}
	
	
	public boolean validateUser(String email, String password) {
		boolean validated = false;
		
		return validated;
	}
	
	public User createUser(User user){
	
		User newUser = userRepo.save(user);
		return newUser;
	}
	
	public boolean createAdminUser() {
		return false;
	}
	
	public boolean deleteUserById(long userId) {
		
		userRepo.delete(userId);
		return true;
	}
	
	
	public boolean deactivateUser(long userId) {
		return false;
	}
	
	
	public boolean reactivateUser(long userId) {
		return false;
	}
	
	
	public boolean updateUser(User user){
		return false;
	}
	
	
	public User findUserByEmail(String email) {
//		User user = userRepo.findUserByEmail(email);
		return null;
	}
	
	
	public User findUserById(Long userId) {
		User user = userRepo.findOne(userId);
		return user;
	}
	
	
	public boolean changeUserPassword() {
		return false;
	}
}
