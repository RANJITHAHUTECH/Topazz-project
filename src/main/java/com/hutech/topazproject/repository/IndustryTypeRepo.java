package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.IndustryType;

@Repository
public interface IndustryTypeRepo extends JpaRepository<IndustryType, Long> {

}
