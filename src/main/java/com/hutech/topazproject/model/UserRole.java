package com.hutech.topazproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userType=" + userType + "]";
	}

	public UserRole(Long id, String userType) {
		super();
		this.id = id;
		this.userType = userType;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

}
