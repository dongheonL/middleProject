package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NomalAffairsAttachVO;

public interface NomalAffairsAttachDAO {
	List<NomalAffairsAttachVO> selectNomalAffairsAttachesByBno(SqlSession session, int bno) throws SQLException;
	
	public NomalAffairsAttachVO selectNomalAffairsAttachByAno(SqlSession session,int ano)throws SQLException;
	
	public void insertNomalAffairsAttach(SqlSession session,NomalAffairsAttachVO nomalaffairsattach)throws SQLException;
	
	public void deleteNomalAffairsAttach(SqlSession session,int ano)throws SQLException;
	
	public void deleteAllNomalAffairsAttach(SqlSession session,int bno)throws SQLException;
}
