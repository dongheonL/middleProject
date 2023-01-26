package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.AnnouncementBoardAttachVO;

public interface AnnouncementBoardAttachDAO {
	
	public List<AnnouncementBoardAttachVO> selectAnnouncementBoardAttachesByAbno(SqlSession session, int abno) throws SQLException;
	public AnnouncementBoardAttachVO selectAnnouncementBoardAttachByAano(SqlSession session, int aano) throws SQLException;

	public void insertAnnouncementBoardAttach(SqlSession session, AnnouncementBoardAttachVO announcementBoardAttach) throws SQLException;

	public void deleteAnnouncementBoardAttach(SqlSession session, int aano) throws SQLException;

	public void deleteAllAnnouncementBoardAttach(SqlSession session, int abno) throws SQLException;

}
