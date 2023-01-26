package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.AnnouncementBoardVO;

public interface AnnouncementBoardDAO {
	
	List<AnnouncementBoardVO> selectAnnouncementBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException;
	int selectAnnouncementBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	AnnouncementBoardVO selectAnnouncementBoardByAbno(SqlSession session, int abno) throws SQLException;
	
	void insertAnnouncementBoard(SqlSession session, AnnouncementBoardVO announcementBoard) throws SQLException;
	void updateAnnouncementBoard(SqlSession session, AnnouncementBoardVO announcementBoard) throws SQLException;
	void deleteAnnouncementBoard(SqlSession session, int abno) throws SQLException;
	
	int selectSeqNextValue(SqlSession session) throws SQLException;
	
	void increaseViewCnt(SqlSession session, int abno) throws SQLException;

}
