package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NoticeBoardVO;

public class NoticeBoardDAOImpl implements NoticeboardDAO {

	@Override
	public List<NoticeBoardVO> selectNoticeBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<NoticeBoardVO> noticeBoardList = session.selectList("NoticeBoard-Mapper.selectSearchNoticeBoardList", cri, rowBounds);
		return noticeBoardList;
	}

	@Override
	public int selectNoticeBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = session.selectOne("NoticeBoard-Mapper.selectSearchNoticeBoardListCount", cri);
		return count;
	}

	@Override
	public void insertNoticeBoard(SqlSession session, NoticeBoardVO noticeBoard) throws SQLException {
		session.update("NoticeBoard-Mapper.insertNoticeBoard", noticeBoard);
	}

	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		int nbno = session.selectOne("NoticeBoard-Mapper.selectNoticeBoardSeqNext");
		return nbno;
	}

	@Override
	public NoticeBoardVO selectNoticeBoardByNbno(SqlSession session, int nbno) throws SQLException {
		NoticeBoardVO noticeBoard = session.selectOne("NoticeBoard-Mapper.selectNoticeBoardByNbno");
		return noticeBoard;
	}

	@Override
	public void increaseViewCnt(SqlSession session, int nbno) throws SQLException {
		session.update("NoticeBoard-Mapper.increaseViewCnt", nbno);
		
	}

	@Override
	public void updateNoticeBoard(SqlSession session, NoticeBoardVO noticeBoard) throws SQLException {
		session.update("NoticeBoard-Mapper.updateNoticeBoard", noticeBoard);
		
	}

	@Override
	public void deleteNoticeBoard(SqlSession session, int nbno) throws SQLException {
		session.update("NoticeBoard-Mapper.deleteNoticeBoard", nbno);
		
	}

}
