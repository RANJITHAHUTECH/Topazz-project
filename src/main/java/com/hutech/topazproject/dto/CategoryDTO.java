package com.hutech.topazproject.dto;

import java.util.Arrays;
import java.util.List;

public class CategoryDTO {

	private String categoryName;
	private byte[] fileData;
	private List<String> tagList;
	private List<String> subCategoryList;
	private String descriptions;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public List<String> getSubCategoryList() {
		return subCategoryList;
	}

	public void setSubCategoryList(List<String> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryName=" + categoryName + ", fileData=" + Arrays.toString(fileData) + ", tagList="
				+ tagList + ", subCategoryList=" + subCategoryList + ", descriptions=" + descriptions + "]";
	}

}
