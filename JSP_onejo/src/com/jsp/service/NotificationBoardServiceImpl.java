package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.NotificationAttachDAO;
import com.jsp.dao.NotificationBoardDAO;
import com.jsp.dto.NotificationAttachVO;
import com.jsp.dto.NotificationBoardVO;

public class NotificationBoardServiceImpl implements NotificationBoardService {

	private SqlSessionFactory sqlSessionFactory;
	private NotificationBoardDAO notificationBoardDAO;
	private NotificationAttachDAO notificationAttachDAO;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setNotificationBoardDAO(NotificationBoardDAO notificationBoardDAO) {
		this.notificationBoardDAO = notificationBoardDAO;
	}

	public void setNotificationAttachDAO(NotificationAttachDAO notificationAttachDAO) {
		this.notificationAttachDAO = notificationAttachDAO;
	}

	@Override
	public Map<String, Object> getBoardListForPage(SearchCriteria cri) throws SQLException {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<NotificationBoardVO> boardList = notificationBoardDAO.selectBoardCriteria(session, cri);
			if(boardList !=null) {
				for(NotificationBoardVO board : boardList) {
					addAttachList(session, board);
				}
			}
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(notificationBoardDAO.selectBoardCriteriaTotalCount(session, cri));
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("boardList", boardList);
			dataMap.put("pageMaker", pageMaker);
			return dataMap;
		}finally {
			session.close();
		}
		
	}

	

	@Override
	public NotificationBoardVO read(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			NotificationBoardVO board = notificationBoardDAO.selectBoardByBno(session, bno);
			notificationBoardDAO.increaseViewCnt(session, bno);
			addAttachList(session, board);
			
			return board;
		}finally {
			session.close();
		}
		
	}

	@Override
	public NotificationBoardVO getBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			NotificationBoardVO board = notificationBoardDAO.selectBoardByBno(session, bno);
			addAttachList(session, board);
			
			return board;
		}finally {
			session.close();
		}
	}
	
	@Override
	public void regist(NotificationBoardVO board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int bno = notificationBoardDAO.selectSeqNextValue(session);
			board.setBno(bno);
			notificationBoardDAO.insertBoard(session, board);
			
			if(board.getAttachList() !=null) {
				for(NotificationAttachVO attach : board.getAttachList() ) {
					attach.setBno(bno);
					attach.setAttacher(board.getWriter());
					notificationAttachDAO.insertAttach(session, attach);
				}
			}
			
		}finally {
			session.close();
		}

	}

	@Override
	public void modify(NotificationBoardVO board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			notificationBoardDAO.updateBoard(session, board);
			notificationBoardDAO.updateBoard(session, board);
			if (board.getAttachList() != null)
				for (NotificationAttachVO attach : board.getAttachList()) {					
					notificationAttachDAO.insertAttach(session, attach);
				}
		}finally {
			session.close();
		}

	}

	@Override
	public void remove(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			notificationBoardDAO.deleteBoard(session, bno);
		}finally {
			session.close();
		}

	}
	
	private void addAttachList(SqlSession session, NotificationBoardVO board) throws SQLException {

		if (board == null)
			return;

		int bno = board.getBno();
		List<NotificationAttachVO> attachList = notificationAttachDAO.selectAttachesByBno(session, bno);

		board.setAttachList(attachList);
	}

	@Override
	public NotificationAttachVO getAttachByAno(int ano) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			NotificationAttachVO attach = notificationAttachDAO.selectAttachByAno(session, ano);
			return attach;
		}finally {
			session.close();
		}
		
	}
	
	@Override
	public void removeAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			notificationAttachDAO.deleteAttach(session, ano);

		} finally {
			session.close();
		}

	}







}
