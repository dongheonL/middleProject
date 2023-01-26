package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.WeeklyReportAttachVO;

public interface WeeklyReportAttachDAO {

	public List<WeeklyReportAttachVO> selectAttachesByBno(SqlSession session, int bno)throws SQLException;
	public WeeklyReportAttachVO selectAttachByAno(SqlSession session,int ano)throws SQLException;
	
	public void insertAttach(SqlSession session,WeeklyReportAttachVO attach) throws SQLException;

	public void deleteAttach(SqlSession session,int ano) throws SQLException;

	public void deleteAllAttach(SqlSession session,int bno)throws SQLException;
}
