package com.hutech.topazproject.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.topazproject.dto.CategoryDTO;
import com.hutech.topazproject.dto.ProductDTO;
import com.hutech.topazproject.model.Category;
import com.hutech.topazproject.model.ProductDetails;
import com.hutech.topazproject.repository.ProductRepo;
import com.hutech.topazproject.repository.uploadMultipleRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private uploadMultipleRepo uploadMultipleRepo;

	public ProductDetails saveProductDetails(ProductDTO productDTO, MultipartFile fileData) throws IOException {
		try {
			ProductDetails product = createObjPayload(productDTO);
			return productRepo.save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return new ProductDetails();
		}
	}

	public ProductDetails createObjPayload(ProductDTO productDTO) {
		ProductDetails newObj = new ProductDetails();
		newObj.setBrand(productDTO.getBrand());
		newObj.setCollection(productDTO.getCollection());
		List<String> categoryTypeList = productDTO.getCategoryTypeList();
		newObj.setCategoryType(String.join(",", categoryTypeList));
		newObj.setCurrency(productDTO.getCurrency());
		newObj.setDescription(productDTO.getDescription());
		newObj.setMaxOrderQuality(productDTO.getMaxOrderQuality());
		newObj.setMinOrderQuality(productDTO.getMinOrderQuality());
		newObj.setMRP(productDTO.getMRP());
		newObj.setProductTitle(productDTO.getProductTitle());
		newObj.setSize(productDTO.getSize());
		newObj.setSKUId(productDTO.getSKUId());
		newObj.setStock(productDTO.getStock());

		newObj.setTag(productDTO.getTag());
		newObj.setThickness(productDTO.getThickness());
		newObj.setThreshold(productDTO.getThreshold());
		newObj.setUnitOfMesaurment(productDTO.getUnitOfMesaurment());
		newObj.setWoodType(productDTO.getWoodType());

		return newObj;
	}

}
