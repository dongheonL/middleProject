package com.jsp.dto;

import java.util.Date;

public class QualificationAttachVO {
	
	private int ano; 			 
	private String uploadPath;	 
	private String fileName;  	 
	private String fileType; 	 
	private int bno;          	
	private String attacher; 	 
	private Date regDate;
	
	
	
	
	public QualificationAttachVO() {}

	
	public QualificationAttachVO(String uploadPath, String fileName, String fileType) {
		super();
		this.uploadPath = uploadPath;
		this.fileName = fileName;
		this.fileType = fileType;
	}


	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getAttacher() {
		return attacher;
	}
	public void setAttacher(String attacher) {
		this.attacher = attacher;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
}
