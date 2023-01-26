package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.WeeklyReportBoardVO;

public class WeeklyReportBoardDAOImpl implements WeeklyReportBoardDAO {

	@Override
	public List<WeeklyReportBoardVO> selectBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<WeeklyReportBoardVO> weeklyReportBoardList = session.selectList("WeeklyReportBoard-Mapper.selectSearchBoardList", cri, rowBounds);
		return weeklyReportBoardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = session.selectOne("WeeklyReportBoard-Mapper.selectSearchBoardListCount", cri);
		return count;
	}

	@Override
	public WeeklyReportBoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException {
		WeeklyReportBoardVO weeklyReportBoard = session.selectOne("WeeklyReportBoard-Mapper.selectBoardByBno", bno);
		return weeklyReportBoard;
	}

	
	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		int bno = session.selectOne("WeeklyReportBoard-Mapper.selectBoardSeqNext");
		return bno;
	}

	@Override
	public void increaseViewCnt(SqlSession session, int bno) throws SQLException {
		session.update("WeeklyReportBoard-Mapper.increaseViewCnt",bno);

	}
	@Override
	public void insertBoard(SqlSession session, WeeklyReportBoardVO board) throws SQLException {
		session.update("WeeklyReportBoard-Mapper.insertBoard", board);

	}

	@Override
	public void updateBoard(SqlSession session, WeeklyReportBoardVO board) throws SQLException {
		session.update("WeeklyReportBoard-Mapper.updateBoard", board);

	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		session.update("WeeklyReportBoard-Mapper.deleteBoard", bno);

	}



}
