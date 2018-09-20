//package com.aws.codestar.silkroute.service;
//
//import java.util.Collection;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.aws.codestar.silkroute.models.*;
//import com.aws.codestar.silkroute.repositories.UserRepository;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//	 
//	@Autowired
//	    private UserRepository userRepository;
//
//	    @Override
//	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//	        Optional<User> user = userRepository.findByEmail(email);
//	        if (user.get() == null){
//	            throw new UsernameNotFoundException("Invalid username or password.");
//	        }
//	       User myUser = user.get();
//	        return new org.springframework.security.core.userdetails.User(myUser.getEmail(),
//	                myUser.getPassword(),
//	                mapRolesToAuthorities(myUser.getRoles()));
//	    }
//
//	    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//	        return roles.stream()
//	                .map(role -> new SimpleGrantedAuthority(role.getRole()))
//	                .collect(Collectors.toList());
//	    }
//	}
//
