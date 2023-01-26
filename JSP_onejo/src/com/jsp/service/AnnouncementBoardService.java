package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.AnnouncementBoardAttachVO;
import com.jsp.dto.AnnouncementBoardVO;

public interface AnnouncementBoardService {
	
	Map<String, Object> getList(SearchCriteria cri) throws SQLException;
	
	void regist(AnnouncementBoardVO announcementBoard) throws SQLException;
	
	AnnouncementBoardVO read(int abno) throws SQLException;
	
	AnnouncementBoardVO getAnnouncementBoard(int abno) throws SQLException;
	
	void modify(AnnouncementBoardVO announcementBoard) throws SQLException;
	
	void remove(int abno) throws SQLException;
	
	AnnouncementBoardAttachVO getAnnouncementBoardAttachByAano(int aano) throws SQLException;
	
	void removeAnnouncementBoardAttachByAano(int aano) throws SQLException;

}
