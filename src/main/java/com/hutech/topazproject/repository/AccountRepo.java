package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.AccountDetail;

@Repository
public interface AccountRepo extends JpaRepository<AccountDetail, Long> {

//	@Query("from AccountDetail where accountNumber=:accountNumber")
//	public AccountDetail findByAccountNumber(Long accountNumber);

}
