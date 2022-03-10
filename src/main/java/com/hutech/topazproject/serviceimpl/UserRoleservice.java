package com.hutech.topazproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.topazproject.model.UserRole;
import com.hutech.topazproject.repository.UserRoleRepo;

@Service
public class UserRoleservice {
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	public UserRole saveuserRole(UserRole role) {
		return userRoleRepo.save(role);
		
	}

}
