package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.AnnouncementBoardAttachVO;

public class AnnouncementBoardAttachDAOImpl implements AnnouncementBoardAttachDAO{

	@Override
	public List<AnnouncementBoardAttachVO> selectAnnouncementBoardAttachesByAbno(SqlSession session, int abno)
			throws SQLException {
		List<AnnouncementBoardAttachVO> announcementBoardAttachList = session.selectList("AnnouncementBoardAttach-Mapper.selectAnnouncementBoardAttachesByAbno", abno);
		return announcementBoardAttachList;
	}

	@Override
	public AnnouncementBoardAttachVO selectAnnouncementBoardAttachByAano(SqlSession session, int aano)
			throws SQLException {
		AnnouncementBoardAttachVO announcementBoardAttach = session.selectOne("AnnouncementBoardAttach-Mapper.selectAnnouncementBoardAttachByAano", aano);
		return announcementBoardAttach;
	}

	@Override
	public void insertAnnouncementBoardAttach(SqlSession session, AnnouncementBoardAttachVO announcementBoardAttach)
			throws SQLException {
		session.update("AnnouncementBoardAttach-Mapper.insertAnnouncementBoardAttach", announcementBoardAttach);
		
	}

	@Override
	public void deleteAnnouncementBoardAttach(SqlSession session, int aano) throws SQLException {
		session.update("AnnouncementBoardAttach-Mapper.deleteAnnouncementBoardAttach", aano);
		
	}

	@Override
	public void deleteAllAnnouncementBoardAttach(SqlSession session, int abno) throws SQLException {
		session.update("AnnouncementBoardAttach-Mapper.deleteAllAnnouncementBoardAttach", abno);
		
	}

}
