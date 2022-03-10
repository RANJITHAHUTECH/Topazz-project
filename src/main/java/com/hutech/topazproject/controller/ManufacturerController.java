package com.hutech.topazproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.topazproject.model.AccountDetail;
import com.hutech.topazproject.model.ManufacturerOnboardDetails;
import com.hutech.topazproject.model.UploadLogo;
import com.hutech.topazproject.repository.ManufacturerRepository;
import com.hutech.topazproject.repository.UploadLogoRepo;
import com.hutech.topazproject.serviceimpl.ManufacturerService;
import com.hutech.topazproject.serviceimpl.UploadService;

import net.bytebuddy.asm.Advice.Return;

@RestController
public class ManufacturerController {

	@Autowired
	private ManufacturerService manufacturerService;

	@PostMapping("/onboarddetails/add")
	public ManufacturerOnboardDetails saveOnboardDetails(@RequestBody ManufacturerOnboardDetails details) {
		return manufacturerService.saveOnboardDetails(details);
	}

	@PutMapping("/addfile/{id}")
	public String savelogo(@RequestParam("fileData") MultipartFile fileData, @PathVariable("id") Long id)
			throws IOException {
		System.out.println("fileData {}" + fileData + " id " + id);

		if (fileData.getContentType().equals("image/jpeg") || fileData.getContentType().equals("image/png")) {
			manufacturerService.saveUploadlogo(fileData, id);
			return "File Uploaded Successfully!!!";
		} else {
			return "file not updated";
		}
	}

	@PutMapping("/account/{id}")
	public String saveaccount(@RequestBody AccountDetail detail,@PathVariable("id") Long manufacturerId) {
		return manufacturerService.saveAccountDetails(detail, manufacturerId);

	}

	@GetMapping("/onboarddetails/get")
	public List<ManufacturerOnboardDetails> getOnboardDetails() {
		return manufacturerService.getAllMaufacturerDetails();
	}

}
