package com.capg.otms.gateway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.otms.gateway.model.UserInfo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	RestTemplate rt;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo userInfo = rt.getForObject("http://user-ms/users/p/user-name/"+userName, UserInfo.class);
		String role=userInfo.isAdmin()?"ROLE_ADMIN":"ROLE_USER";
		List<GrantedAuthority> authorities=Arrays.asList(new SimpleGrantedAuthority(role));
		return new User(userName, userInfo.getUserPassword(),authorities );
	}
	
	
	

}
