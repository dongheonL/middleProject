package com.jsp.dto;

import java.util.Date;
import java.util.List;

public class NoticeBoardVO {

	private int nbno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Date redDate;
	private Date updateDate;
	private String department;

	private List<NoticeBoardAttachVO> noticeBoardAttachList;

	public List<NoticeBoardAttachVO> getNoticeBoardAttachList() {
		return noticeBoardAttachList;
	}

	public void setNoticeBoardAttachList(List<NoticeBoardAttachVO> noticeBoardAttachList) {
		this.noticeBoardAttachList = noticeBoardAttachList;
	}

	public int getNbno() {
		return nbno;
	}

	public void setNbno(int nbno) {
		this.nbno = nbno;
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

	public Date getRedDate() {
		return redDate;
	}

	public void setRedDate(Date redDate) {
		this.redDate = redDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
