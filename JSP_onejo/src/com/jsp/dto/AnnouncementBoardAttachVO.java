package com.jsp.dto;

import java.util.Date;

public class AnnouncementBoardAttachVO {

	private int aano;
	private String uploadPath;
	private String fileName;
	private String fileType;
	private int abno;
	private String attacher;
	private Date regDate;

	public int getAano() {
		return aano;
	}

	public void setAano(int aano) {
		this.aano = aano;
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

	public int getAbno() {
		return abno;
	}

	public void setAbno(int abno) {
		this.abno = abno;
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
