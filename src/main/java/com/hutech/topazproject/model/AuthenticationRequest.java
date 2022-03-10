package com.hutech.topazproject.model;

public class AuthenticationRequest {

	private String userName;
	private String password;
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [userName=" + userName + ", password=" + password + ", emailId=" + emailId + "]";
	}

	public AuthenticationRequest(String userName, String password, String emailId) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
	}

	public AuthenticationRequest() {
		super();
	}

}
