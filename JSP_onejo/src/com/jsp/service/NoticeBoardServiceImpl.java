package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.NoticeBoardAttachDAO;
import com.jsp.dao.NoticeboardDAO;
import com.jsp.dto.NoticeBoardAttachVO;
import com.jsp.dto.NoticeBoardVO;

public class NoticeBoardServiceImpl implements NoticeBoardService {

	private SqlSessionFactory sqlSessionFactory;
	private NoticeboardDAO noticeBoardDAO;
	private NoticeBoardAttachDAO noticeBoardAttachDAO;

	public void setNoticeboardAttachDAO(NoticeBoardAttachDAO noticeBoardAttachDAO) {
		this.noticeBoardAttachDAO = noticeBoardAttachDAO;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setNoticeboardDAO(NoticeboardDAO noticeBoardDAO) {
		this.noticeBoardDAO = noticeBoardDAO;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			List<NoticeBoardVO> noticeBoardList = noticeBoardDAO.selectNoticeBoardCriteria(session, cri);
			if (noticeBoardList != null)
				for (NoticeBoardVO noticeBoard : noticeBoardList)
					addNoticeBoardAttachList(session, noticeBoard);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(noticeBoardDAO.selectNoticeBoardCriteriaTotalCount(session, cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("noticeBoardList", noticeBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}

	}

	@Override
	public void regist(NoticeBoardVO noticeBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			int nbno = noticeBoardDAO.selectSeqNextValue(session);

			noticeBoard.setNbno(nbno);
			noticeBoardDAO.insertNoticeBoard(session, noticeBoard);
			
			if (noticeBoard.getNoticeBoardAttachList() != null) {
				for(NoticeBoardAttachVO noticeBoardAttach : noticeBoard.getNoticeBoardAttachList()) {
					noticeBoardAttach.setNbno(nbno);
					noticeBoardAttach.setAttacher(noticeBoard.getWriter());
					noticeBoardAttachDAO.insertNoticeBoardAttach(session, noticeBoardAttach);
				}
			}
		} finally {
			session.close();
		}

	}

	@Override
	public NoticeBoardVO read(int nbno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			NoticeBoardVO noticeBoard = noticeBoardDAO.selectNoticeBoardByNbno(session, nbno);
			noticeBoardDAO.increaseViewCnt(session, nbno);
			
			addNoticeBoardAttachList(session, noticeBoard);

			return noticeBoard;
		} finally {
			session.close();
		}

	}

	@Override
	public NoticeBoardVO getNoticeBoard(int nbno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			NoticeBoardVO noticeBoard = noticeBoardDAO.selectNoticeBoardByNbno(session, nbno);
			
			addNoticeBoardAttachList(session, noticeBoard);

			return noticeBoard;
		} finally {
			session.close();
		}

	}

	@Override
	public void modify(NoticeBoardVO noticeBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			noticeBoardDAO.updateNoticeBoard(session, noticeBoard);
			
			if (noticeBoard.getNoticeBoardAttachList() != null)
				for (NoticeBoardAttachVO noticeBoardAttach : noticeBoard.getNoticeBoardAttachList()) {
					noticeBoardDAO.insertNoticeBoard(session, noticeBoard);
				}
		} finally {
			session.close();
		}

	}

	@Override
	public void remove(int nbno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			noticeBoardDAO.deleteNoticeBoard(session, nbno);
		} finally {
			session.close();
		}

	}
	
	private void addNoticeBoardAttachList(SqlSession session, NoticeBoardVO noticeBoard) throws SQLException {
		
		if (noticeBoard == null)
			return;
		
		int nbno = noticeBoard.getNbno();
		List<NoticeBoardAttachVO> noticeBoardAttachList = noticeBoardAttachDAO.selectNoticeBoardAttachesByNbno(session, nbno);
		
		noticeBoard.setNoticeBoardAttachList(noticeBoardAttachList);
	}

	@Override
	public NoticeBoardAttachVO getNoticeBoardAttachByNano(int nano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			NoticeBoardAttachVO noticeBoardAttach = noticeBoardAttachDAO.selectNoticeBoardAttachByNano(session, nano);

			return noticeBoardAttach;
		} finally {
			session.close();
		}

	}

	@Override
	public void removeNoticeBoardAttachByNano(int nano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			noticeBoardAttachDAO.deleteNoticeBoardAttach(session, nano);
		} finally {
			session.close();
		}

	}

}
