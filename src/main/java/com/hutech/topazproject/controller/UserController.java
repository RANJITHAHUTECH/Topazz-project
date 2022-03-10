package com.hutech.topazproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.topazproject.model.AuthenticationRequest;
import com.hutech.topazproject.model.AuthenticationResponse;
import com.hutech.topazproject.model.ManufacturerOnboardDetails;
import com.hutech.topazproject.model.UserEntity;
import com.hutech.topazproject.serviceimpl.UserService;
import com.hutech.topazproject.utility.JWTUtility;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/userentity/add")
	public UserEntity saveEntity(@RequestBody UserEntity entity) {
		return userService.saveEntity(entity);

	}

	@GetMapping("/userentity/get")
	public List<UserEntity> getAllEntities() {
		return userService.getAllEntities();
	}

	@PostMapping("/activate/account")
	public String forgotPassword(@RequestParam String emailId) {
		System.out.println("emailId from postman " + emailId);
		return userService.activateUserAccount(emailId);
	}

	@PutMapping("/setpassword")
	public String resetPassword(@RequestParam String token, @RequestParam String password) {
		System.out.println("token{} " + token + " password{} " + password);
		return userService.checkTokenAndSetPassword(token, password);
	}

}
