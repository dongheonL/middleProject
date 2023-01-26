package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NotificationAttachVO;


public interface NotificationAttachDAO {

	public List<NotificationAttachVO> selectAttachesByBno(SqlSession session, int bno)throws SQLException;
	public NotificationAttachVO selectAttachByAno(SqlSession session,int ano)throws SQLException;
	
	public void insertAttach(SqlSession session,NotificationAttachVO attach) throws SQLException;

	public void deleteAttach(SqlSession session,int ano) throws SQLException;

	public void deleteAllAttach(SqlSession session,int bno)throws SQLException;
}
