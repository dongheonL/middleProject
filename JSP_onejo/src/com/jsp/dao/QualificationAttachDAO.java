package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.QualificationAttachVO;



public interface QualificationAttachDAO {

	public List<QualificationAttachVO> selectAttachByBno(SqlSession session, int bno)throws SQLException;

	public QualificationAttachVO selectAttachByAno(SqlSession session,int ano)throws SQLException;
	
	public void insertAttach(SqlSession session, QualificationAttachVO qualificationAttach) throws SQLException;

	public void deleteAttach(SqlSession session,int ano) throws SQLException;

	public void deleteAllAttach(SqlSession session,int bno)throws SQLException;
	
}