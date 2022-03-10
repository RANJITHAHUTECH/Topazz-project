package com.hutech.topazproject.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "category_detail")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	private String categoryName;
	@Lob
	private byte[] fileData;
	private String tag;
	private String subCategory;
	private String descriptions;

	public Category() {
		super();
	}

	public Category(long categoryId, String categoryName, byte[] fileData, String tag, String subCategory,
			String descriptions) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.fileData = fileData;
		this.tag = tag;
		this.subCategory = subCategory;
		this.descriptions = descriptions;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", fileData="
				+ Arrays.toString(fileData) + ", tag=" + tag + ", subCategory=" + subCategory + ", descriptions="
				+ descriptions + "]";
	}

}
