package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.AppointmentBoardVO;

public class AppointmentBoardDAOImpl implements AppointmentBoardDAO{

	@Override
	public List<AppointmentBoardVO> selectBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<AppointmentBoardVO> appointmentBoardList = session.selectList("AppointmentBoard-Mapper.selectSearchBoardList",cri,rowBounds);
		
		return appointmentBoardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count=session.selectOne("AppointmentBoard-Mapper.selectSearchBoardListCount",cri);
		return count;
	}

	@Override
	public AppointmentBoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException {
		AppointmentBoardVO appointmentBoard = session.selectOne("AppointmentBoard-Mapper.selectboardByBno",bno);
		return appointmentBoard;
	}

	@Override
	public void insertBoard(SqlSession session, AppointmentBoardVO appointmentBoard) throws SQLException {
		session.update("AppointmentBoard-Mapper.insertboard",appointmentBoard);
		
	}

	@Override
	public void updateBoard(SqlSession session, AppointmentBoardVO appointmentBoard) throws SQLException {
		session.update("AppointmentBoard-Mapper.updateboard",appointmentBoard);
		
	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		session.update("AppointmentBoard-Mapper.deleteboard",bno);
		
	}

	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		int bno = session.selectOne("AppointmentBoard-Mapper.selectboardSeqNext");
		return bno;
	}

	@Override
	public void increaseViewCnt(SqlSession session, int bno) throws SQLException {
		session.update("AppointmentBoard-Mapper.increaseViewCnt",bno);
		
	}
	
	

	
	
}