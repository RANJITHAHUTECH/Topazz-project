package com.hutech.topazproject.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "upload_multiple_image")
public class UploadMultipleImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	private byte[] fileData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "UploadMultipleImage [id=" + id + ", fileData=" + Arrays.toString(fileData) + "]";
	}

	public UploadMultipleImage(Long id, byte[] fileData) {
		super();
		this.id = id;
		this.fileData = fileData;
	}

	public UploadMultipleImage() {
		super();

	}

}
