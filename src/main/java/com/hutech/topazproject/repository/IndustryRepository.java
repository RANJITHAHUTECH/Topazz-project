package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.IndustryType;
import com.hutech.topazproject.model.ManufacturerOnboardDetails;

@Repository
public interface IndustryRepository extends JpaRepository<ManufacturerOnboardDetails, Long> {

	IndustryType save(IndustryType type);

}
