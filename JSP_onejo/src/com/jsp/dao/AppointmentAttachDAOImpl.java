
package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.AppointmentAttachVO;

public class AppointmentAttachDAOImpl implements AppointmentAttachDAO{
	
	
	@Override
	public List<AppointmentAttachVO> selectAttachByBno(SqlSession session,int bno) throws SQLException {
		List<AppointmentAttachVO> appointmentattachList = session.selectList("AppointmentAttach-Mapper.selectAttachByBno",bno);
		return appointmentattachList;
	}
	
	@Override
	public AppointmentAttachVO selectAttachByAno(SqlSession session,int ano) throws SQLException {
		AppointmentAttachVO appointmentattach = session.selectOne("AppointmentAttach-Mapper.selectAttachByAno",ano);
		return appointmentattach;
	}
	
	@Override
	public void insertAttach(SqlSession session, AppointmentAttachVO appointmentattach) throws SQLException {
		session.update("AppointmentAttach-Mapper.insertAttach",appointmentattach);
	}

	@Override
	public void deleteAttach(SqlSession session,int ano) throws SQLException {
		session.update("AppointmentAttach-Mapper.deleteAttach",ano);		
		
	}
	
	@Override
	public void deleteAllAttach(SqlSession session,int bno) throws SQLException {
		session.update("AppointmentAttach-Mapper.deleteAllAttach",bno);		
	}
	
	
}





