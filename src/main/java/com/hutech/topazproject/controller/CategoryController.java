package com.hutech.topazproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.topazproject.dto.CategoryDTO;
import com.hutech.topazproject.model.Category;
import com.hutech.topazproject.serviceimpl.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category/add")
	public Category saveCategory(@RequestBody CategoryDTO categoryDTO) //, @RequestParam("fileData") MultipartFile fileData)
			throws IOException {
		System.out.print("categoryDTO " + categoryDTO);
		return categoryService.saveCategory(categoryDTO, null);
	}

	@GetMapping("/category/get")
	public List<Category> getcategoryDetails() {
		return categoryService.getcategoryDetails();

	}

	@PutMapping("/category/{id}")
	public Category updateCategoryById(@RequestBody Category category) {
		return categoryService.updateCategoryById(category);

	}

}
