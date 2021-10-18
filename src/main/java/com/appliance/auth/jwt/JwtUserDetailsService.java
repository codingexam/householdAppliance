package com.appliance.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appliance.user.entity.User;
import com.appliance.user.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private PasswordEncoder passwordEncoder;
  
  @Autowired
  private UserService service;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  User user = service.getByUsername(username);
	  if (user == null) {
          throw new UsernameNotFoundException(username);
      }
      return new JwtUserDetails(user.getUserId(), user.getUsername(), user.getPassword());
  }

}


