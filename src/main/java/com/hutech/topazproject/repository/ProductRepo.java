package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.ProductDetails;

@Repository
public interface ProductRepo extends JpaRepository<ProductDetails, Long> {

}
