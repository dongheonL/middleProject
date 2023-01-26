package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NotificationBoardVO;

public class NotificationBoardDAOImpl implements NotificationBoardDAO {

	@Override
	public List<NotificationBoardVO> selectBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<NotificationBoardVO> notificationBoardList = session.selectList("NotificationBoard-Mapper.selectSearchBoardList", cri, rowBounds);
		return notificationBoardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = session.selectOne("NotificationBoard-Mapper.selectSearchBoardListCount", cri);
		return count;
	}

	@Override
	public NotificationBoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException {
		NotificationBoardVO notificationBoard =session.selectOne("NotificationBoard-Mapper.selectBoardByBno", bno);
		
		return notificationBoard;
	}

	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		
		int bno = session.selectOne("NotificationBoard-Mapper.selectBoardSeqNext");
		return bno;
	}
	@Override
	public void insertBoard(SqlSession session, NotificationBoardVO board) throws SQLException {
		session.update("NotificationBoard-Mapper.insertBoard", board);

	}

	@Override
	public void updateBoard(SqlSession session, NotificationBoardVO board) throws SQLException {
		session.update("NotificationBoard-Mapper.updateBoard", board);

	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		session.update("NotificationBoard-Mapper.deleteBoard", bno);

	}



	@Override
	public void increaseViewCnt(SqlSession session, int bno) throws SQLException {
		session.update("NotificationBoard-Mapper.increaseViewCnt",bno);

	}

}
