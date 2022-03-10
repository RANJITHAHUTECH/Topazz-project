package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.UserEntity;
import com.hutech.topazproject.model.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserEntity, Long> {

	UserRole save(UserRole role);

}
