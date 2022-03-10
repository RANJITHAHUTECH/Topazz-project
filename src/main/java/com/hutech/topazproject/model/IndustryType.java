package com.hutech.topazproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "industry_type")
public class IndustryType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String industryName;

	public IndustryType() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	@Override
	public String toString() {
		return "IndustryType [id=" + id + ", industryName=" + industryName + "]";
	}

	public IndustryType(Long id, String industryName) {
		super();
		this.id = id;
		this.industryName = industryName;
	}

}
