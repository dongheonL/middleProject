package com.jsp.dto;

import java.util.Date;
import java.util.List;

public class NomalAffairsBoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Date regDate;
	private Date updateDate;
	private List<NomalAffairsAttachVO> nomalAffairsAttachList;
	
	
	public List<NomalAffairsAttachVO> getNomalAffairsAttachList() {
		return nomalAffairsAttachList;
	}
	public void setNomalAffairsAttachList(List<NomalAffairsAttachVO> nomalAffairsAttachList) {
		this.nomalAffairsAttachList = nomalAffairsAttachList;
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
	public void setRegDate(Date gerDate) {
		this.regDate = gerDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
