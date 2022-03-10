package com.hutech.topazproject.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.topazproject.dto.CategoryDTO;
import com.hutech.topazproject.model.Category;
import com.hutech.topazproject.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public Category saveCategory(CategoryDTO categoryDTO, MultipartFile fileData) throws IOException {
		try {
			Category category = createObjPayload(categoryDTO);
			return categoryRepo.save(category);
		} catch (Exception e) {
			e.printStackTrace();
			return new Category();
		}
	}

	private Category createObjPayload(CategoryDTO categoryDTO) {

		Category newObj = new Category();
		newObj.setCategoryName(categoryDTO.getCategoryName());
		// newObj.setFileData(fileData.getBytes());
		newObj.setDescriptions(categoryDTO.getDescriptions());

		List<String> tagListString = categoryDTO.getTagList();
		List<String> subCategoryList = categoryDTO.getSubCategoryList();
		newObj.setTag(String.join(",", tagListString));
		newObj.setSubCategory(String.join(",", subCategoryList));

		return newObj;
	}

	public List<Category> getcategoryDetails() {
		return categoryRepo.findAll();

	}

	public Category updateCategoryById(Category category) {
		return categoryRepo.save(category);

	}
	

}
