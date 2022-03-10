package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.categoryType;

@Repository
public interface CategoryTypeRepo  extends JpaRepository<categoryType, Long>{

}

