package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NomalAffairsBoardVO;


public interface NomalAffairsBoardDAO {
	List<NomalAffairsBoardVO> selectNomalAffairsBoardCriteria(SqlSession session,SearchCriteria cri) throws SQLException;
	int selectNomalAffairsBoardCriteriaTotalCount(SqlSession session,SearchCriteria cri) throws SQLException;
	NomalAffairsBoardVO selectNomalAffairsBoardByBno(SqlSession session,int bno)throws SQLException;
	void insertNomalAffairsBoard(SqlSession session,NomalAffairsBoardVO nomalAffairsBoard)throws SQLException;
	void updateNomalAffairsBoard(SqlSession session,NomalAffairsBoardVO nomalAffairsBoard)throws SQLException;
	void deleteNomalAffairsBoard(SqlSession session,int bno)throws SQLException;
	int selectSeqNextValue(SqlSession session) throws SQLException;
	void increaseViewCnt(SqlSession session,int bno)throws SQLException;
}
