package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NotificationBoardVO;


public interface NotificationBoardDAO {

	List<NotificationBoardVO> selectBoardCriteria(SqlSession session,SearchCriteria cri) throws SQLException;
	int selectBoardCriteriaTotalCount(SqlSession session,SearchCriteria cri) throws SQLException;
	
	NotificationBoardVO selectBoardByBno(SqlSession session,int bno)throws SQLException;
	
	
	void insertBoard(SqlSession session,NotificationBoardVO board)throws SQLException;
	void updateBoard(SqlSession session,NotificationBoardVO board)throws SQLException;
	void deleteBoard(SqlSession session,int bno)throws SQLException;
	
	
	//Board_seq.nextval 가져오기
	int selectSeqNextValue(SqlSession session) throws SQLException;
	//viewcnt  증가
	void increaseViewCnt(SqlSession session,int bno)throws SQLException;
}
