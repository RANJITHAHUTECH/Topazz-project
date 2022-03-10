package com.hutech.topazproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hutech.topazproject.exception.AdminNotFoundException;
import com.hutech.topazproject.model.AdminLogin;
import com.hutech.topazproject.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminLogin saveAdmin(AdminLogin adminLogin) {
		AdminLogin objFromDB = null;
		try {
			// AdminLogin adminLoginObj = new AdminLogin();
			System.out.println("objFromDB################### " + objFromDB);
			objFromDB = adminRepository.findByUser(adminLogin.getUserName());
			System.out.println("objFromDB################### " + objFromDB);


			if (objFromDB != null && objFromDB.getPhoneNumber() == adminLogin.getPhoneNumber()) {
				System.out.println("#1");
				objFromDB.setReturnMeggase("Phone Number already Exist");
				return objFromDB;
			}

			if (objFromDB != null && objFromDB.getUserName().equalsIgnoreCase(adminLogin.getUserName())) {
				System.out.println("#2");

				objFromDB.setReturnMeggase("User Name already exist");

				return objFromDB;
			}

			if (objFromDB != null && objFromDB.getEmailId().equalsIgnoreCase(adminLogin.getEmailId())) {
				System.out.println("#3");

				objFromDB.setReturnMeggase("Email already Exist");
				return objFromDB;
			}

			return adminRepository.save(adminLogin);
		} catch (Exception e) {
			objFromDB.setReturnMeggase("Failed to save check logs");
			return objFromDB;
		}
	}

}
