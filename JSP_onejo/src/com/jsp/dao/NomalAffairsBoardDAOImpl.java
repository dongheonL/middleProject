package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NomalAffairsBoardVO;



public class NomalAffairsBoardDAOImpl implements NomalAffairsBoardDAO{

	@Override
	public List<NomalAffairsBoardVO> selectNomalAffairsBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<NomalAffairsBoardVO> nomalAffairsBoardList=
		   session.selectList("NomalAffairsBoard-Mapper.selectSearchNomalAffairsBoardList",cri,rowBounds);	
			
		return nomalAffairsBoardList;
	}

	@Override
	public int selectNomalAffairsBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count=session.selectOne("NomalAffairsBoard-Mapper.selectSearchNomalAffairsBoardListCount",cri);
		return count;
	}

	@Override
	public void insertNomalAffairsBoard(SqlSession session, NomalAffairsBoardVO nomalAffairsBoard) throws SQLException {		
		session.update("NomalAffairsBoard-Mapper.insertNomalAffairsBoard",nomalAffairsBoard);		
	}

	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		int bno=session.selectOne("NomalAffairsBoard-Mapper.selectNomalAffairsBoardSeqNext");
		return bno;
	}

	@Override
	public NomalAffairsBoardVO selectNomalAffairsBoardByBno(SqlSession session, int bno) throws SQLException {
		NomalAffairsBoardVO nomalAffairsBoard=session.selectOne("NomalAffairsBoard-Mapper.selectNomalAffairsBoardByBno",bno);
		return nomalAffairsBoard;
	}

	@Override
	public void increaseViewCnt(SqlSession session, int bno) throws SQLException {
		session.update("NomalAffairsBoard-Mapper.increaseViewCnt",bno);
	}
	
	@Override
	public void updateNomalAffairsBoard(SqlSession session,NomalAffairsBoardVO nomalAffairsBoard) throws SQLException {
		session.update("NomalAffairsBoard-Mapper.updateNomalAffairsBoard",nomalAffairsBoard);
	}

	@Override
	public void deleteNomalAffairsBoard(SqlSession session,int bno) throws SQLException {
		session.update("NomalAffairsBoard-Mapper.deleteNomalAffairsBoard",bno);
	}

}
