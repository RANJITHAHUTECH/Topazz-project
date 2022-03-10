
package com.hutech.topazproject.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SKUId;
	private String productTitle;
	private String categoryType;
	private Integer minOrderQuality;
	private Integer maxOrderQuality;
	private String color;
	private String woodType;
	private Integer size;
	private Integer thickness;
	private String brand;
	private String stock;
	private String threshold;
	private String collection;
	private String unitOfMesaurment;
	private Integer MRP;
	private String tag;
	private String currency;
	private String description;
	@Lob
	private byte[] fileData;

	public Long getSKUId() {
		return SKUId;
	}

	public void setSKUId(Long sKUId) {
		SKUId = sKUId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Integer getMinOrderQuality() {
		return minOrderQuality;
	}

	public void setMinOrderQuality(Integer minOrderQuality) {
		this.minOrderQuality = minOrderQuality;
	}

	public Integer getMaxOrderQuality() {
		return maxOrderQuality;
	}

	public void setMaxOrderQuality(Integer maxOrderQuality) {
		this.maxOrderQuality = maxOrderQuality;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getThickness() {
		return thickness;
	}

	public void setThickness(Integer thickness) {
		this.thickness = thickness;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getUnitOfMesaurment() {
		return unitOfMesaurment;
	}

	public void setUnitOfMesaurment(String unitOfMesaurment) {
		this.unitOfMesaurment = unitOfMesaurment;
	}

	public Integer getMRP() {
		return MRP;
	}

	public void setMRP(Integer mRP) {
		MRP = mRP;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "ProductDetails [SKUId=" + SKUId + ", productTitle=" + productTitle + ", categoryType=" + categoryType
				+ ", minOrderQuality=" + minOrderQuality + ", maxOrderQuality=" + maxOrderQuality + ", color=" + color
				+ ", woodType=" + woodType + ", size=" + size + ", thickness=" + thickness + ", brand=" + brand
				+ ", stock=" + stock + ", threshold=" + threshold + ", collection=" + collection + ", unitOfMesaurment="
				+ unitOfMesaurment + ", MRP=" + MRP + ", tag=" + tag + ", currency=" + currency + ", description="
				+ description + ", fileData=" + Arrays.toString(fileData) + "]";
	}

	public ProductDetails(Long sKUId, String productTitle, String categoryType, Integer minOrderQuality,
			Integer maxOrderQuality, String color, String woodType, Integer size, Integer thickness, String brand,
			String stock, String threshold, String collection, String unitOfMesaurment, Integer mRP, String tag,
			String currency, String description, byte[] fileData) {
		super();
		SKUId = sKUId;
		this.productTitle = productTitle;
		this.categoryType = categoryType;
		this.minOrderQuality = minOrderQuality;
		this.maxOrderQuality = maxOrderQuality;
		this.color = color;
		this.woodType = woodType;
		this.size = size;
		this.thickness = thickness;
		this.brand = brand;
		this.stock = stock;
		this.threshold = threshold;
		this.collection = collection;
		this.unitOfMesaurment = unitOfMesaurment;
		MRP = mRP;
		this.tag = tag;
		this.currency = currency;
		this.description = description;
		this.fileData = fileData;
	}

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
