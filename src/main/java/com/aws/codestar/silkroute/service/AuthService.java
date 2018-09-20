package com.aws.codestar.silkroute.service;

import com.aws.codestar.silkroute.models.Role;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional <User> optionalUser = userRepository.findByEmail(email);
		
		//user does not exist
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("User does not exist. Please register."));
		//else user exist return user
		return optionalUser.get();
		
		
	}
	
	
	


	
}
