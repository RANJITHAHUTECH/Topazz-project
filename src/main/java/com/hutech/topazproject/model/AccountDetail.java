package com.hutech.topazproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_detail")
public class AccountDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private Long accountNumber;
	private String ifsccode;
	private String branchName;
	private String gstNumber;
	private String cinNumber;

	public AccountDetail() {
		super();
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getCinNumber() {
		return cinNumber;
	}

	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
	}

	@Override
	public String toString() {
		return "AccountDetail [accountId=" + accountId + ", accountNumber=" + accountNumber + ", ifsccode=" + ifsccode
				+ ", branchName=" + branchName + ", gstNumber=" + gstNumber + ", cinNumber=" + cinNumber + "]";
	}

	public AccountDetail(Long accountId, Long accountNumber, String ifsccode, String branchName, String gstNumber,
			String cinNumber) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.ifsccode = ifsccode;
		this.branchName = branchName;
		this.gstNumber = gstNumber;
		this.cinNumber = cinNumber;
	}
}