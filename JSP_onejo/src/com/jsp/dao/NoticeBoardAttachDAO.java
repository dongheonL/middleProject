package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NoticeBoardAttachVO;

public interface NoticeBoardAttachDAO {

	public List<NoticeBoardAttachVO> selectNoticeBoardAttachesByNbno(SqlSession session, int nbno) throws SQLException;
	public NoticeBoardAttachVO selectNoticeBoardAttachByNano(SqlSession session, int nano) throws SQLException;

	public void insertNoticeBoardAttach(SqlSession session, NoticeBoardAttachVO noticeBoardAttach) throws SQLException;

	public void deleteNoticeBoardAttach(SqlSession session, int nano) throws SQLException;

	public void deleteAllNoticeBoardAttach(SqlSession session, int nbno) throws SQLException;

}
