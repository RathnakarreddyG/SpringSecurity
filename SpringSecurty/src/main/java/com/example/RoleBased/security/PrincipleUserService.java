package com.example.RoleBased.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.RoleBased.Dao.UserDetailsDAO;
import com.example.RoleBased.model.User;

@Service
public class PrincipleUserService implements UserDetailsService {

	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws RuntimeException {
		User user = userDetailsDAO.findbyEmail(username).orElseThrow(()->new RuntimeException("User details Not found "+username));
		PricipleUser PpricipleUser = new PricipleUser(user);
		return PpricipleUser;
//		return new PricipleUser(username);
	}
	

}
