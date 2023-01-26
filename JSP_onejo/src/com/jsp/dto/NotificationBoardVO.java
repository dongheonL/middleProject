package com.jsp.dto;

import java.util.Date;
import java.util.List;

public class NotificationBoardVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Date regDate;
	private Date updateDate;
	
	private List<NotificationAttachVO> attachList;
	
	public NotificationBoardVO() {}

	public NotificationBoardVO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		
	}

	
	public List<NotificationAttachVO> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<NotificationAttachVO> attachList) {
		this.attachList = attachList;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
