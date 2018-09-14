//package com.aws.codestar.silkroute.service;
//
//import com.aws.codestar.silkroute.models.User;
//import com.aws.codestar.silkroute.models.UserType;
//import com.aws.codestar.silkroute.repositories.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class LoginService implements UserDetailsService {
//
//	@Autowired
//    private UserRepository userRepository;
//	
//	@Override
//	@Transactional(readOnly = true)
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(email);
//		
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (UserType role : user.getUserTypes()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getTypeName()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
//   
//		
//	}
//
//	
//}
