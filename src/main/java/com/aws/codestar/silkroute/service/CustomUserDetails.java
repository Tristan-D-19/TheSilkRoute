package com.aws.codestar.silkroute.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aws.codestar.silkroute.models.User;

public class CustomUserDetails extends User implements UserDetails {

	 public CustomUserDetails() {
		
	}
	 public CustomUserDetails(final User user) {
	        super(user);
	    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> listOfRoles = getRoles()
		.stream()
		.map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
		.collect(Collectors.toList());
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//      for (Role role : user.getRoles() ){
//          grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
          
		return null;
	}

	@Override 
	public String getPassword() {
		return super.getPassword();
		
	}
	@Override
	public String getUsername() {
		
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.getActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.getActive();
	}

}
