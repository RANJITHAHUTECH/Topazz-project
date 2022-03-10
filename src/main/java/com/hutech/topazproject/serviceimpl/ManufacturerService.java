
package com.hutech.topazproject.serviceimpl;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.topazproject.model.AccountDetail;
import com.hutech.topazproject.model.AddressLine;
import com.hutech.topazproject.model.IndustryType;
import com.hutech.topazproject.model.ManufacturerOnboardDetails;
import com.hutech.topazproject.model.UploadLogo;
import com.hutech.topazproject.model.UserEntity;
import com.hutech.topazproject.model.UserRole;
import com.hutech.topazproject.repository.AccountRepo;
import com.hutech.topazproject.repository.ManufacturerRepository;
import com.hutech.topazproject.repository.UploadLogoRepo;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Autowired
	private UploadLogoRepo uploadLogoRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	private static final String tokenUrl = "http://localhost:8888/setpassword?token=";
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

	public ManufacturerOnboardDetails saveOnboardDetails(ManufacturerOnboardDetails requestFromFrontEnd) {
		ManufacturerOnboardDetails obj = null;
		try {
			obj = createObjPayload(requestFromFrontEnd);
			System.out.println("Final Obj needs to be saved " + obj);

			obj = manufacturerRepository.save(obj);

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public ManufacturerOnboardDetails createObjPayload(ManufacturerOnboardDetails requestFromFrontEnd) {
		ManufacturerOnboardDetails newObj = new ManufacturerOnboardDetails();

		newObj.setAddressLine(requestFromFrontEnd.getAddressLine());
		newObj.setManufacturerCode(requestFromFrontEnd.getManufacturerCode());
		newObj.setManufacturerName(requestFromFrontEnd.getManufacturerName());
		newObj.setIndustryType(requestFromFrontEnd.getIndustryType());

		IndustryType industryType = new IndustryType();
		industryType.setIndustryName(requestFromFrontEnd.getIndustryType().getIndustryName());

		AddressLine addressLine = new AddressLine();
		addressLine.setCity(requestFromFrontEnd.getAddressLine().getCity());
		addressLine.setCountry(requestFromFrontEnd.getAddressLine().getCountry());
		addressLine.setState(requestFromFrontEnd.getAddressLine().getState());
		addressLine.setPinCode(requestFromFrontEnd.getAddressLine().getPinCode());

		UserEntity userEntity = new UserEntity();
		userEntity.setPhoneNumber(requestFromFrontEnd.getUserEntity().getPhoneNumber());
		userEntity.setContactPerson(requestFromFrontEnd.getUserEntity().getContactPerson());
		userEntity.setEmailId(requestFromFrontEnd.getUserEntity().getEmailId());
		userEntity.setUserRole(requestFromFrontEnd.getUserEntity().getUserRole());

		UploadLogo uploadLogo = new UploadLogo();
		uploadLogo.setFileName(requestFromFrontEnd.getUploadLogo().getFileName());

		UserRole userRole = new UserRole();
		userRole.setUserType(requestFromFrontEnd.getUserEntity().getUserRole().getUserType());

		newObj.setAddressLine(addressLine);
		newObj.setUserEntity(userEntity);
		newObj.setUploadLogo(uploadLogo);
		return newObj;
	}

	public UploadLogo saveUploadlogo(MultipartFile fileData, Long id) throws IOException {
		UploadLogo uploadLogDBObj = uploadLogoRepo.getById(id);
		System.out.println("uploadLogDBObj " + uploadLogDBObj);

		if (uploadLogDBObj != null) {
			uploadLogDBObj.setFileData(fileData.getBytes());
			uploadLogDBObj = uploadLogoRepo.save(uploadLogDBObj);
		}

		return uploadLogDBObj;
	}

	public String saveAccountDetails(AccountDetail detail, Long manufacturerId) {
		ManufacturerOnboardDetails manufacturer = manufacturerRepository.getById(manufacturerId);
		System.out.println("uploadLogDBObj " + manufacturer);
		AccountDetail accountDetail = new AccountDetail();

		accountDetail.setAccountNumber(detail.getAccountNumber());
		accountDetail.setBranchName(detail.getBranchName());
		accountDetail.setCinNumber(detail.getCinNumber());
		accountDetail.setGstNumber(detail.getGstNumber());
		accountDetail.setIfsccode(detail.getIfsccode());

		SimpleMailMessage activateEmail = new SimpleMailMessage();
		manufacturer.getUserEntity().setToken(generateToken());

		manufacturer.getUserEntity().setTokenCreationDate(LocalDateTime.now());
		activateEmail.setFrom("ranjithabm133@gmail.com");
		activateEmail.setTo(manufacturer.getUserEntity().getEmailId());
		activateEmail.setSubject("Activate your account");
		activateEmail.setText("To  Activate your Account, click the link below:\n" + tokenUrl
				+ "/activate-account?token=" + manufacturer.getUserEntity().getToken());
		javaMailSender.send(activateEmail);
		manufacturer.setAccount(accountDetail);
		manufacturerRepository.save(manufacturer);
		if (manufacturer.getUserEntity() != null) {
			return tokenUrl + "<" + manufacturer.getUserEntity().getToken() + ">" + "\n" + "\n" + "Data saved";
		} else {
			return "Failed to Save";
		}

	}

	private String generateToken() {
		StringBuilder token = new StringBuilder();
		return token.append(UUID.randomUUID().toString()).append(UUID.randomUUID().toString()).toString();
	}

	private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {
		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);
		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}

	public List<ManufacturerOnboardDetails> getAllMaufacturerDetails() {
		return manufacturerRepository.findAll();
	}
}
