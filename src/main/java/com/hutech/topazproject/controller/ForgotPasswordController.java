package com.hutech.topazproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.topazproject.serviceimpl.ForgetAndResetService;

@RestController
public class ForgotPasswordController {

	@Autowired
	private ForgetAndResetService forgetResetService;

	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String emailId) {
		System.out.println("emailId from postman " + emailId);
		return forgetResetService.forgotPassword(emailId);
	}

	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String token, @RequestParam String password) {
		System.out.println("token{} " + token + " password{} " + password);
		return forgetResetService.checkTokenAndResetPassword(token, password);
	}
}
