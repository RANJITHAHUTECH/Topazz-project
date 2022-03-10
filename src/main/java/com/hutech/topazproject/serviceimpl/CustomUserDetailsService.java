package com.hutech.topazproject.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hutech.topazproject.model.AdminLogin;
import com.hutech.topazproject.repository.AdminRepository;

@Service("userDetailsService")
@Repository
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AdminLogin adminLogin = adminRepository.findByUser(userName);
		return new User(adminLogin.getUserName(), adminLogin.getPassword(), new ArrayList<>());
	}

}