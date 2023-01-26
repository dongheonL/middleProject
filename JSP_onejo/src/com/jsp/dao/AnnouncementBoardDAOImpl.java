package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.AnnouncementBoardVO;

public class AnnouncementBoardDAOImpl implements AnnouncementBoardDAO {

	@Override
	public List<AnnouncementBoardVO> selectAnnouncementBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<AnnouncementBoardVO> announcementBoardList = session.selectList("AnnouncementBoard-Mapper.selectSearchAnnouncementBoardList", cri, rowBounds);
		return announcementBoardList;
	}

	@Override
	public int selectAnnouncementBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = session.selectOne("AnnouncementBoard-Mapper.selectSearchAnnouncementBoardListCount", cri);
		return count;
	}

	@Override
	public void insertAnnouncementBoard(SqlSession session, AnnouncementBoardVO announcementBoard) throws SQLException {
		session.update("AnnouncementBoard-Mapper.insertAnnouncementBoard", announcementBoard);
	}

	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		int abno = session.selectOne("AnnouncementBoard-Mapper.selectAnnouncementBoardSeqNext");
		return abno;
	}

	@Override
	public AnnouncementBoardVO selectAnnouncementBoardByAbno(SqlSession session, int abno) throws SQLException {
		AnnouncementBoardVO announcementBoard = session.selectOne("AnnouncementBoard-Mapper.selectAnnouncementBoardByAbno", abno);
		return announcementBoard;
	}

	@Override
	public void increaseViewCnt(SqlSession session, int abno) throws SQLException {
		session.update("AnnouncementBoard-Mapper.increaseViewCnt", abno);
		
	}

	@Override
	public void updateAnnouncementBoard(SqlSession session, AnnouncementBoardVO announcementBoard) throws SQLException {
		session.update("AnnouncementBoard-Mapper.updateAnnouncementBoard", announcementBoard);
		
	}

	@Override
	public void deleteAnnouncementBoard(SqlSession session, int abno) throws SQLException {
		session.update("AnnouncementBoard-Mapper.deleteAnnouncementBoard", abno);
		
	}

}
