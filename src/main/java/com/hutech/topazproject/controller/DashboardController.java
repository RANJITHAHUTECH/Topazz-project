package com.hutech.topazproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.topazproject.model.AccountDetail;
import com.hutech.topazproject.model.ManufacturerOnboardDetails;
import com.hutech.topazproject.model.UserEntity;
import com.hutech.topazproject.repository.AccountRepo;
import com.hutech.topazproject.repository.ManufacturerRepository;
import com.hutech.topazproject.repository.UserRepository;

@RestController
public class DashboardController {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/getCount1")
	public int getCountOfManufacturUserDetails() {
		List<ManufacturerOnboardDetails> manufacturerDataList = manufacturerRepository.findAll();
		if (!CollectionUtils.isEmpty(manufacturerDataList)) {
			return manufacturerDataList.size();
		}
		return 0;
	}

	@RequestMapping("/getCount2")
	public int getCountOfAccountUserDetails() {
		List<AccountDetail> accountsDataList = accountRepo.findAll();

		if (!CollectionUtils.isEmpty(accountsDataList)) {
			return accountsDataList.size();
		}
		return 0;
	}

	@RequestMapping("/getCount3")
	public int getCountOfUserDetails() {
		List<UserEntity> userDataList = userRepository.findAll();
		if (!CollectionUtils.isEmpty(userDataList)) {
			return userDataList.size();
		}
		return 0;
	}

	@RequestMapping("/getCount4")
	public int getCountOfProductUserDetails() {
		List<UserEntity> userDataList = userRepository.findAll();
		if (!CollectionUtils.isEmpty(userDataList)) {
			return userDataList.size();
		}
		return 0;
	}

}
