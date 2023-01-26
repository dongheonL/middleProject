package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.QualificationBoardVO;

public class QualificationBoardDAOImpl implements QualificationBoardDAO {

	@Override
	public List<QualificationBoardVO> selectBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QualificationBoardVO> qualificationBoardList = session.selectList("QualificationBoard-Mapper.selectSearchboardList",cri,rowBounds);
		
		return qualificationBoardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count=session.selectOne("QualificationBoard-Mapper.selectSearchboardListCount",cri);
		return count;
	}

	@Override
	public QualificationBoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException {
		QualificationBoardVO qualificationBoard = session.selectOne("QualificationBoard-Mapper.selectboardByBno",bno);
		return qualificationBoard;
	}

	@Override
	public void insertBoard(SqlSession session, QualificationBoardVO qualificationBoard) throws SQLException {
		session.update("QualificationBoard-Mapper.insertboard",qualificationBoard);
		
	}

	@Override
	public void updateBoard(SqlSession session, QualificationBoardVO qualificationBoard) throws SQLException {
		session.update("QualificationBoard-Mapper.updateboard",qualificationBoard);
		
	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		session.update("QualificationBoard-Mapper.deleteboard",bno);
		
	}

	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		int bno = session.selectOne("QualificationBoard-Mapper.selectboardSeqNext");
		return bno;
	}

	@Override
	public void increaseViewCnt(SqlSession session, int bno) throws SQLException {
		session.update("QualificationBoard-Mapper.increaseViewCnt",bno);
		
	}
	
	


	
}
