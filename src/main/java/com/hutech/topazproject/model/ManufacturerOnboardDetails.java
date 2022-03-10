package com.hutech.topazproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer_onboard_details")
public class ManufacturerOnboardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long manufacturerId;

	private String manufacturerCode;

	private String manufacturerName;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private IndustryType industryType;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AddressLine addressLine;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UserEntity userEntity;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UploadLogo uploadLogo;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AccountDetail account;

	public ManufacturerOnboardDetails() {
		super();

	}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public IndustryType getIndustryType() {
		return industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	public AddressLine getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(AddressLine addressLine) {
		this.addressLine = addressLine;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public UploadLogo getUploadLogo() {
		return uploadLogo;
	}

	public void setUploadLogo(UploadLogo uploadLogo) {
		this.uploadLogo = uploadLogo;
	}

	public AccountDetail getAccount() {
		return account;
	}

	public void setAccount(AccountDetail account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "ManufacturerOnboardDetails [manufacturerId=" + manufacturerId + ", manufacturerCode=" + manufacturerCode
				+ ", manufacturerName=" + manufacturerName + ", industryType=" + industryType + ", addressLine="
				+ addressLine + ", userEntity=" + userEntity + ", uploadLogo=" + uploadLogo + ", account=" + account
				+ "]";
	}
}