package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("from UserEntity where emailId=:emailId")
	UserEntity findByEmailId(String emailId);

	@Query("from  UserEntity where token=:token")
	UserEntity findByToken(String token);

}

