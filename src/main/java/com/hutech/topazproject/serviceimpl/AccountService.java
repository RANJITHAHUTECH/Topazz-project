package com.hutech.topazproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.topazproject.model.AccountDetail;
import com.hutech.topazproject.repository.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public AccountDetail saveAccountDetail(AccountDetail accountDetail) {
		return accountRepo.save(accountDetail);

	}

	public List<AccountDetail> getAccountDetail() {
		return accountRepo.findAll();

	}

}
