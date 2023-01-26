package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.AppointmentAttachVO;

public interface AppointmentAttachDAO {

	public List<AppointmentAttachVO> selectAttachByBno(SqlSession session, int bno)throws SQLException;

	public AppointmentAttachVO selectAttachByAno(SqlSession session,int ano)throws SQLException;
	
	public void insertAttach(SqlSession session, AppointmentAttachVO appointmentattach) throws SQLException;

	public void deleteAttach(SqlSession session,int ano) throws SQLException;

	public void deleteAllAttach(SqlSession session,int bno)throws SQLException;
	
}

