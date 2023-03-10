package com.jsp.dto;

import java.util.Date;

public class WeeklyReportAttachVO {

	private int ano; //고유번호
	private String uploadPath; //저장경로
	private String fileName; //파일명
	private String fileType; //파일형식
	private int bno; //자료실 글번호
	private String attacher; //등록자
	private Date regDate; //등록일
	
	public WeeklyReportAttachVO() {}

	public WeeklyReportAttachVO( String uploadPath, String fileName, String fileType
			) {
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
