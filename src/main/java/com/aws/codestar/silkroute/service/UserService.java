package com.aws.codestar.silkroute.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.models.Role;
import com.aws.codestar.silkroute.repositories.UserRepository;
import com.aws.codestar.silkroute.repositories.RoleRepository;


@Service
@Repository
@Transactional
public class UserService  {
	
	public void init_admin_roles() {
		if (roleRepository.findByRoleAccess(1) == null)
		{
			Role admin = new Role(1, "ADMIN");
	        Role user = new Role(0, "USER");
	           
	        Set<User> users = new HashSet<User>();
	        User adminUser = new User("tristand.thomas19@gmail.com", "tsr_admin", "tsr_admin", "$lowJaguar29");
	        users.add(adminUser);
	        
	        admin.setUsers(users);
	        user.setUsers(users);
	        Set<Role> roles = new HashSet<Role>();
	        roles.add(admin);
	        roles.add(user);
	        admin = roleRepository.save(admin);
	        user = roleRepository.save(user);
	        adminUser.setRoles(roles);
	        adminUser = userRepo.save(adminUser);
		}
	}
	
	@Autowired
	private UserRepository userRepo;

	
    @Autowired
    private RoleRepository roleRepository;
    
   
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> adminGetAllUsers(){
		List<User> users = new ArrayList<User>();
		userRepo.findAll().forEach(users::add);
		return users;
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		userRepo.findAll().forEach(users::add);
		return users;
		
	}
	
	
	public boolean validateUser(String email, String password) {
		boolean validated = false;
		validated = userRepo.findByEmail(email).get().getPassword().equals(password);
		return validated;
	}
	
	public User createUser(User user){
		Role customer = new Role(0, "USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<Role>();
		roles.add(customer);
		user.setRoles(roles);
		User newUser = userRepo.save(user);
		return newUser;
	}
	
	public User createAdminUser(User user) {
		
		
		Role admin = new Role(1,"ADMIN");
		Role customer = new Role(0, "USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<Role>();
		roles.add(admin);
		roles.add(customer);
		user.setRoles(roles);
		User newAdminUser = userRepo.save(user);
		return newAdminUser;
	}
	
	public boolean deleteUserById(long userId) {
		
		userRepo.delete(userId);
		return true;
	}
	
	
	public boolean deactivateUser(long userId) {
		User user = userRepo.findOne(userId);
		user.setActive(false);
		User deactivatedUser = userRepo.save(user);
		if(deactivatedUser.getActive() == false)
		return true;
		
		return false;
	}
	
	
	public boolean reactivateUser(long userId) {
		User user = userRepo.findOne(userId);
		user.setActive(true);
		User deactivatedUser = userRepo.save(user);
		if(deactivatedUser.getActive() == true)
		return true;
		
		return false;
	}
	
	
	public User updateUser(User user){
		User updatedUser = userRepo.save(user);
		return updatedUser;
	}
	
	
	
	public User findUserById(long userId) {
		User user = userRepo.findOne(userId);
		return user;
	}
	
	
	public boolean changeUserPassword(String password, long user_id) {
		User user = userRepo.findOne(user_id);
		user.setPassword(password);
		User changedUser = userRepo.save(user);
		if(changedUser.getPassword().equals(user.getPassword()))
		return true;
		
		return false;
	}

	
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role userRole = roleRepository.findByRole("CUSTOMER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
	        userRepo.save(user);
		
	}

	
	public User findUserByEmail(String email) {
		
		return userRepo.findByEmail(email).get();
	}
}
