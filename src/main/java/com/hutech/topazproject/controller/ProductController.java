package com.hutech.topazproject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.topazproject.dto.ProductDTO;
import com.hutech.topazproject.model.ProductDetails;
import com.hutech.topazproject.serviceimpl.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product/add")
	public ProductDetails saveProductDetails(@RequestBody ProductDTO productDTO)
			//@RequestParam("fileData") MultipartFile fileData)
	throws IOException {
		System.out.print("productDTO " + productDTO);
		return productService.saveProductDetails(productDTO, null);
	}

}
