package com.hutech.topazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.topazproject.model.UploadMultipleImage;

@Repository
public interface uploadMultipleRepo  extends JpaRepository<UploadMultipleImage, Long> {

}
