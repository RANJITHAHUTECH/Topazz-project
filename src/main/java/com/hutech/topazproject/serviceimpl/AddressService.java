package com.hutech.topazproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.topazproject.model.AddressLine;
import com.hutech.topazproject.repository.AddressRepo;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;

	public AddressLine saveCode(AddressLine code) {
		return addressRepo.save(code);

	}

}
