package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserResporitory  repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		user u1=repo.findByEmail(email);
		if(u1==null)
		{
			throw new UsernameNotFoundException("user not fount");
		}
		return new CustomerUserDetails(u1);
	}

}
