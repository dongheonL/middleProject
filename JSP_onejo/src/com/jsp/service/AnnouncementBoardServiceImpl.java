package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.AnnouncementBoardAttachDAO;
import com.jsp.dao.AnnouncementBoardDAO;
import com.jsp.dto.AnnouncementBoardAttachVO;
import com.jsp.dto.AnnouncementBoardVO;

public class AnnouncementBoardServiceImpl implements AnnouncementBoardService {

	private SqlSessionFactory sqlSessionFactory;
	private AnnouncementBoardDAO announcementBoardDAO;
	private AnnouncementBoardAttachDAO announcementBoardAttachDAO;

	public void setAnnouncementBoardAttachDAO(AnnouncementBoardAttachDAO announcementBoardAttachDAO) {
		this.announcementBoardAttachDAO = announcementBoardAttachDAO;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setAnnouncementboardDAO(AnnouncementBoardDAO announcementBoardDAO) {
		this.announcementBoardDAO = announcementBoardDAO;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			List<AnnouncementBoardVO> announcementBoardList = announcementBoardDAO
					.selectAnnouncementBoardCriteria(session, cri);
			if (announcementBoardList != null)
				for (AnnouncementBoardVO announcementBoard : announcementBoardList)
					addAnnouncementBoardAttachList(session, announcementBoard);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(announcementBoardDAO.selectAnnouncementBoardCriteriaTotalCount(session, cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("announcementBoardList", announcementBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}

	}

	@Override
	public void regist(AnnouncementBoardVO announcementBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			int abno = announcementBoardDAO.selectSeqNextValue(session);

			announcementBoard.setAbno(abno);
			announcementBoardDAO.insertAnnouncementBoard(session, announcementBoard);
			
			if (announcementBoard.getAnnouncementBoardAttachList() != null)
				for (AnnouncementBoardAttachVO announcementBoardAttach : announcementBoard.getAnnouncementBoardAttachList()) {
					announcementBoardAttach.setAbno(abno);
					announcementBoardAttach.setAttacher(announcementBoard.getWriter());
					announcementBoardAttachDAO.insertAnnouncementBoardAttach(session, announcementBoardAttach);
				}
		} finally {
			session.close();
		}

	}

	@Override
	public AnnouncementBoardVO read(int abno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			AnnouncementBoardVO announcementBoard = announcementBoardDAO.selectAnnouncementBoardByAbno(session, abno);
			announcementBoardDAO.increaseViewCnt(session, abno);
			
			addAnnouncementBoardAttachList(session, announcementBoard);

			return announcementBoard;
		} finally {
			session.close();
		}

	}

	@Override
	public AnnouncementBoardVO getAnnouncementBoard(int abno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			AnnouncementBoardVO announcementBoard = announcementBoardDAO.selectAnnouncementBoardByAbno(session, abno);
			
			addAnnouncementBoardAttachList(session, announcementBoard);

			return announcementBoard;
		} finally {
			session.close();
		}

	}

	@Override
	public void modify(AnnouncementBoardVO announcementBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			announcementBoardDAO.updateAnnouncementBoard(session, announcementBoard);
			
			if (announcementBoard.getAnnouncementBoardAttachList() != null)
				for (AnnouncementBoardAttachVO announcementBoardAttach : announcementBoard.getAnnouncementBoardAttachList()) {
					announcementBoardAttachDAO.insertAnnouncementBoardAttach(session, announcementBoardAttach);
				}
		} finally {
			session.close();
		}

	}

	@Override
	public void remove(int abno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			announcementBoardDAO.deleteAnnouncementBoard(session, abno);
		} finally {
			session.close();
		}

	}
	
	private void addAnnouncementBoardAttachList(SqlSession session, AnnouncementBoardVO announcementBoard) throws SQLException {
		
		if (announcementBoard == null)
			return;
		
		int abno = announcementBoard.getAbno();
		List<AnnouncementBoardAttachVO> announcementBoardAttachList = announcementBoardAttachDAO.selectAnnouncementBoardAttachesByAbno(session, abno);
		
		announcementBoard.setAnnouncementBoardAttachList(announcementBoardAttachList);
	}

	@Override
	public AnnouncementBoardAttachVO getAnnouncementBoardAttachByAano(int aano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			AnnouncementBoardAttachVO announcementBoardAttach = announcementBoardAttachDAO.selectAnnouncementBoardAttachByAano(session, aano);
			
			return announcementBoardAttach;
		} finally {
			session.close();
		}

	}

	@Override
	public void removeAnnouncementBoardAttachByAano(int aano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			announcementBoardAttachDAO.deleteAnnouncementBoardAttach(session, aano);
		} finally {
			session.close();
		}

	}

}
