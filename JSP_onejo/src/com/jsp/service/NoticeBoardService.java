package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NoticeBoardAttachVO;
import com.jsp.dto.NoticeBoardVO;

public interface NoticeBoardService {
	
	Map<String, Object> getList(SearchCriteria cri) throws SQLException;
	
	void regist(NoticeBoardVO noticeBoard) throws SQLException;
	
	NoticeBoardVO read(int nbno) throws SQLException;
	
	NoticeBoardVO getNoticeBoard(int nbno) throws SQLException;
	
	void modify(NoticeBoardVO noticeBoard) throws SQLException;
	
	void remove(int nbno) throws SQLException;
	
	NoticeBoardAttachVO getNoticeBoardAttachByNano(int nano) throws SQLException;
	
	void removeNoticeBoardAttachByNano(int nano) throws SQLException;
	 
}
