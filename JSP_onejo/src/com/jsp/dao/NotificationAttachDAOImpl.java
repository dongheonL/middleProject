package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NotificationAttachVO;

public class NotificationAttachDAOImpl implements NotificationAttachDAO {

	@Override
	public List<NotificationAttachVO> selectAttachesByBno(SqlSession session, int bno) throws SQLException {
		List<NotificationAttachVO> notificationAttachList=session.selectList("NotificationAttach-Mapper.selectAttachByBno",bno);
		return notificationAttachList;
	}

	@Override
	public NotificationAttachVO selectAttachByAno(SqlSession session, int ano) throws SQLException {
		NotificationAttachVO attach=session.selectOne("NotificationAttach-Mapper.selectAttachByAno",ano);
		return attach;
	}

	@Override
	public void insertAttach(SqlSession session, NotificationAttachVO attach) throws SQLException {
		session.update("NotificationAttach-Mapper.insertAttach",attach);

	}

	@Override
	public void deleteAttach(SqlSession session, int ano) throws SQLException {
		session.update("NotificationAttach-Mapper.deleteAttach",ano);		

	}

	@Override
	public void deleteAllAttach(SqlSession session, int bno) throws SQLException {
		session.update("NotificationAttach-Mapper.deleteAllAttach",bno);	

	}

}
