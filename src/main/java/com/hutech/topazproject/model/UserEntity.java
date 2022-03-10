package com.hutech.topazproject.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_entity")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long phoneNumber;

	private String emailId;

	private String contactPerson;

	private boolean isActivated;

	private String password;

	private String token;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime tokenCreationDate;

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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserRole userRole;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public LocalDateTime getTokenCreationDate() {
		return tokenCreationDate;
	}

	public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
		this.tokenCreationDate = tokenCreationDate;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", contactPerson="
				+ contactPerson + ", isActivated=" + isActivated + ", password=" + password + ", token=" + token
				+ ", tokenCreationDate=" + tokenCreationDate + ", userRole=" + userRole + "]";
	}

	public UserEntity(Long id, Long phoneNumber, String emailId, String contactPerson, boolean isActivated,
			String password, String token, LocalDateTime tokenCreationDate, UserRole userRole) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.contactPerson = contactPerson;
		this.isActivated = isActivated;
		this.password = password;
		this.token = token;
		this.tokenCreationDate = tokenCreationDate;
		this.userRole = userRole;
	}

}
