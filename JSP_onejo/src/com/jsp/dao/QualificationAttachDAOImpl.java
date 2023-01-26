

package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.QualificationAttachVO;


public class QualificationAttachDAOImpl implements QualificationAttachDAO{
	
	
	@Override
	public List<QualificationAttachVO> selectAttachByBno(SqlSession session,int bno) throws SQLException {
		List<QualificationAttachVO> qualificationAttachList = session.selectList("QualificationAttach-Mapper.selectAttachByBno",bno);
		return qualificationAttachList;
	}
	
	@Override
	public QualificationAttachVO selectAttachByAno(SqlSession session,int ano) throws SQLException {
		QualificationAttachVO qualificationAttach = session.selectOne("QualificationAttach-Mapper.selectAttachByAno",ano);
		return qualificationAttach;
	}
	
	@Override
	public void insertAttach(SqlSession session, QualificationAttachVO qualificationAttach) throws SQLException {
		session.update("QualificationAttach-Mapper.insertAttach",qualificationAttach);
	}

	@Override
	public void deleteAttach(SqlSession session,int ano) throws SQLException {
		session.update("QualificationAttach-Mapper.deleteAttach",ano);		
		
	}
	
	@Override
	public void deleteAllAttach(SqlSession session,int bno) throws SQLException {
		session.update("QualificationAttach-Mapper.deleteAllAttach",bno);		
	}


	
	
}
