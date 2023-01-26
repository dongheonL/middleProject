package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NoticeBoardVO;

public interface NoticeboardDAO {
	
	List<NoticeBoardVO> selectNoticeBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException;
	int selectNoticeBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	NoticeBoardVO selectNoticeBoardByNbno(SqlSession session, int nbno) throws SQLException;
	
	void insertNoticeBoard(SqlSession session, NoticeBoardVO noticeBoard) throws SQLException;
	void updateNoticeBoard(SqlSession session, NoticeBoardVO noticeBoard) throws SQLException;
	void deleteNoticeBoard(SqlSession session, int nbno) throws SQLException;
	
	int selectSeqNextValue(SqlSession session) throws SQLException;
	
	void increaseViewCnt(SqlSession session, int nbno) throws SQLException;

}
