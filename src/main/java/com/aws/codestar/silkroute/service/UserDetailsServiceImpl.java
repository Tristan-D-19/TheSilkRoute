//package com.aws.codestar.silkroute.service;
//
//import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.aws.codestar.silkroute.models.*;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//  @Override
//  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//    /*Here we are using dummy data, you need to load user data from
//     database or other third party application*/
//    User user = findUserbyUername(email);
//
//    UserDetailsBuilder builder = null;
//    if (user != null) {
//      builder = org.springframework.security.core.userdetails.User.withUsername(username);
//      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
//      builder.roles(user.getRoles());
//    } else {
//      throw new UsernameNotFoundException("User not found.");
//    }
//
//    return builder.build();
//  }
//
//  private User findUserbyUername(String username) {
//    if(username.equalsIgnoreCase("tsr_admin")) {
//      return new User("", "admin123", "ADMIN", "");
//    }
//    return null;
//  }
//}
