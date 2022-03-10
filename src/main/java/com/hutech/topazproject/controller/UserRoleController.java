package com.hutech.topazproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.topazproject.model.UserRole;
import com.hutech.topazproject.serviceimpl.UserRoleservice;

@RestController
public class UserRoleController {

	@Autowired
	private UserRoleservice userRoleservice;

	@PostMapping("/role/add")
	public UserRole saveuserRole(@RequestBody UserRole role) {
		return userRoleservice.saveuserRole(role);

	}
}
