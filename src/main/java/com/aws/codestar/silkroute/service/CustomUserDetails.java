package com.aws.codestar.silkroute.service;

import java.util.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.aws.codestar.silkroute.models.Role;
import com.aws.codestar.silkroute.models.User;


//


@Service
public class CustomUserDetails extends User implements UserDetails {

	private User user;
	 public CustomUserDetails() {
		
	}
//--------------------------------------------------------------------------------------------	 
	 //extend the user entity. 
	 public CustomUserDetails( User loadedUser) {
	        super(loadedUser);
	        
	         user = this;
	    }
//--------------------------------------------------------------------------------------------	  
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//create authorities for user 
		List<SimpleGrantedAuthority> listOfRoles = super.getRoles()
		.stream()
		.map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
		.collect(Collectors.toList());
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
      for (Role role : super.getRoles() ){
          grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
          
		return listOfRoles;
      		}
	return grantedAuthorities;
      
	}   
//--------------------------------------------------------------------------------------------	 

	@Override 
	public String getPassword() {
		return super.getPassword();
		
	}
//--------------------------------------------------------------------------------------------	 
	
	public User getUser() {
		return user;
	}
//-------------------------------------------------------------------------------------------	
	@Override
	public String getUsername() {
		
		return super.getEmail();
	}
//--------------------------------------------------------------------------------------------	 
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
//--------------------------------------------------------------------------------------------	 
	@Override
	public boolean isAccountNonLocked() {
		return super.getActive();
	}
//--------------------------------------------------------------------------------------------	 

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
//--------------------------------------------------------------------------------------------	 
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.getActive();
	}
//--------------------------------------------------------------------------------------------	 

}
