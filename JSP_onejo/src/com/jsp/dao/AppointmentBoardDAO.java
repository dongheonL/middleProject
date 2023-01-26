package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.AppointmentBoardVO;

public interface AppointmentBoardDAO {
	
	List<AppointmentBoardVO> selectBoardCriteria(SqlSession session,SearchCriteria cri) throws SQLException;
	
	int selectBoardCriteriaTotalCount(SqlSession session,SearchCriteria cri) throws SQLException;
	
	AppointmentBoardVO selectBoardByBno(SqlSession session,int bno)throws SQLException;
	
	
	void insertBoard(SqlSession session,AppointmentBoardVO appointmentBoard)throws SQLException;
	
	void updateBoard(SqlSession session,AppointmentBoardVO appointmentBoard)throws SQLException;
	
	void deleteBoard(SqlSession session,int bno)throws SQLException;
	
	
	int selectSeqNextValue(SqlSession session) throws SQLException;
	//viewcnt  증가
	void increaseViewCnt(SqlSession session,int bno)throws SQLException;
	
}