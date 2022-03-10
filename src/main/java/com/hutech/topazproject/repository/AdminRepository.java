
package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.AdminLogin;
import com.hutech.topazproject.model.ManufacturerOnboardDetails;

@Repository
public interface AdminRepository extends JpaRepository<AdminLogin, Long> {
	
	
	//AdminLogin findByAdminEmail(String Email);
	
	//List<AdminLogin> findByResetPassword(String token);
	

	@Query("from AdminLogin where userName=:userName")
	AdminLogin findByUser(String userName);

	@Query("from AdminLogin where emailId=:emailId")
	AdminLogin findByEmailId(String emailId);

	@Query("from AdminLogin where token=:token")
	AdminLogin findByToken(String token);

}
