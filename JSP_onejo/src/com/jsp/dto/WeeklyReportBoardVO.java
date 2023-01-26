package com.jsp.dto;

import java.util.Date;
import java.util.List;

public class WeeklyReportBoardVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Date regDate;
	private Date updateDate;
	
	private List<WeeklyReportAttachVO> attachList;
	
	public WeeklyReportBoardVO() {}

	public WeeklyReportBoardVO(String title, String content, String writer) {
		super();
		
		this.title = title;
		this.content = content;
		this.writer = writer;
		
	}

	
	public List<WeeklyReportAttachVO> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<WeeklyReportAttachVO> attachList) {
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
