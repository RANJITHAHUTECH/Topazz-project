package com.hutech.topazproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.topazproject.model.AccountDetail;
import com.hutech.topazproject.serviceimpl.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/account/add")
	public AccountDetail saveAccountDetail(@RequestBody AccountDetail accountDetail) {
		return accountService.saveAccountDetail(accountDetail);

	}

	@GetMapping("/account/get")
	public List<AccountDetail> getAccountDetail() {
		return accountService.getAccountDetail();

	}
}
