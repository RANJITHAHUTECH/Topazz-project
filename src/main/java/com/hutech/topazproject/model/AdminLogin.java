
package com.hutech.topazproject.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "admin_info", uniqueConstraints = @UniqueConstraint(columnNames = "phoneNumber"))
public class AdminLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String userName;

	private Long phoneNumber;

	private String emailId;

	private String password;

	private String token;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime tokenCreationDate;

	@Transient
	private String returnMessage;

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMeggase(String returnMeggase) {
		this.returnMessage = returnMeggase;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getTokenCreationDate() {
		return tokenCreationDate;
	}

	public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
		this.tokenCreationDate = tokenCreationDate;
	}

	@Override
	public String toString() {
		return "AdminLogin [Id=" + Id + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", emailId="
				+ emailId + ", password=" + password + ", token=" + token + ", tokenCreationDate=" + tokenCreationDate
				+ ", returnMessage=" + returnMessage + "]";
	}

}
