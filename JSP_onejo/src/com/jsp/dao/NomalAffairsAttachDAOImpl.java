package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NomalAffairsAttachVO;

public class NomalAffairsAttachDAOImpl implements NomalAffairsAttachDAO{

	@Override
	public List<NomalAffairsAttachVO> selectNomalAffairsAttachesByBno(SqlSession session, int bno) throws SQLException {
		List<NomalAffairsAttachVO> nomalaffairsattachList=session.selectList("NomalAffairsAttach-Mapper.selectNomalAffairsAttachByBno",bno);
		return nomalaffairsattachList;
	}

	@Override
	public NomalAffairsAttachVO selectNomalAffairsAttachByAno(SqlSession session, int ano) throws SQLException {
		NomalAffairsAttachVO nomalaffairsattach=session.selectOne("NomalAffairsAttach-Mapper.selectNomalAffairsAttachByAno",ano);
		return nomalaffairsattach;
	}

	@Override
	public void insertNomalAffairsAttach(SqlSession session, NomalAffairsAttachVO nomalaffairsattach) throws SQLException {
		session.update("NomalAffairsAttach-Mapper.insertNomalAffairsAttach",nomalaffairsattach);
	}

	@Override
	public void deleteNomalAffairsAttach(SqlSession session, int ano) throws SQLException {
		session.update("NomalAffairsAttach-Mapper.deleteNomalAffairsAttach",ano);
	}

	@Override
	public void deleteAllNomalAffairsAttach(SqlSession session, int bno) throws SQLException {
		session.update("NomalAffairsAttach-Mapper.deleteAllNomalAffairsAttach",bno);
	}

}
