package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NoticeBoardAttachVO;

public class NoticeBoardAttachDAOImpl implements NoticeBoardAttachDAO{

	@Override
	public List<NoticeBoardAttachVO> selectNoticeBoardAttachesByNbno(SqlSession session, int nbno) throws SQLException {
		List<NoticeBoardAttachVO> noticeBoardAttachList = session.selectList("NoticeBoardAttach-Mapper.selectNoticeBoardAttachByNbno", nbno);
		return noticeBoardAttachList;
	}

	@Override
	public NoticeBoardAttachVO selectNoticeBoardAttachByNano(SqlSession session, int nano) throws SQLException {
		NoticeBoardAttachVO noticeBoardAttach = session.selectOne("NoticeBoardAttach-Mapper.selectNoticeBoardAttachByNano", nano);
		return noticeBoardAttach;
	}

	@Override
	public void insertNoticeBoardAttach(SqlSession session, NoticeBoardAttachVO noticeBoardAttach) throws SQLException {
		session.update("NoticeBoardAttach-Mapper.insertNoticeBoardAttach", noticeBoardAttach);
		
	}

	@Override
	public void deleteNoticeBoardAttach(SqlSession session, int nano) throws SQLException {
		session.update("NoticeBoardAttach-Mapper.deleteNoticeBoardAttach", nano);
		
	}

	@Override
	public void deleteAllNoticeBoardAttach(SqlSession session, int nbno) throws SQLException {
		session.update("NoticeBoardAttach-Mapper.deleteAllNoticeBoardAttach", nbno);
		
	}

}
