package com.hutech.topazproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.topazproject.model.AdminLogin;
import com.hutech.topazproject.model.AuthenticationRequest;
import com.hutech.topazproject.model.AuthenticationResponse;
import com.hutech.topazproject.repository.AdminRepository;
import com.hutech.topazproject.serviceimpl.AdminService;
import com.hutech.topazproject.utility.JWTUtility;

@RestController
public class AdminController {

	@Autowired
	private AdminService AdminService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtility jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private static final String SUCCESS_MSG = "Record saved successfully";
	private static final String FAILED_MSG = "Failed to save check logs";

	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}

	@PostMapping("/admin/login")
	public ResponseEntity<?> createAuthenticationAdminToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
//	@PostMapping("/product/login")
//	public ResponseEntity<?> createAuthenticationProductToken(@RequestBody AuthenticationRequest authenticationRequest)
//			throws Exception {
//
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticationRequest.getEmailId(), authenticationRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new Exception("Incorrect emailId or password", e);
//		}
//
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmailId());
//
//		final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
//	}

	@PostMapping("/user/add")
	public String saveAdminLogin(@RequestBody AdminLogin adminLogin) {
		System.out.print("adminLogin " + adminLogin);
		AdminLogin adminLoginObj = null;
		try {
			String password = adminLogin.getPassword();
			String encode = bCryptPasswordEncoder.encode(password);
			adminLogin.setPassword(encode);
			adminLoginObj = adminRepository.save(adminLogin);

			if (adminLoginObj != null) {
				adminLoginObj.setReturnMeggase(SUCCESS_MSG);
				return adminLoginObj.getReturnMessage();
			} else {
				return FAILED_MSG;
			}
			// return superAdminServiceImpl.saveAdmin(adminLogin);
		} catch (Exception e) {
			return FAILED_MSG;
		}
	}
}
