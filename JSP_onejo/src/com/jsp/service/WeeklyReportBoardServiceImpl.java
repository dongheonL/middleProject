package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.WeeklyReportAttachDAO;
import com.jsp.dao.WeeklyReportBoardDAO;
import com.jsp.dto.WeeklyReportAttachVO;
import com.jsp.dto.WeeklyReportBoardVO;

public class WeeklyReportBoardServiceImpl implements WeeklyReportBoardService {

	private SqlSessionFactory sqlSessionFactory;
	private WeeklyReportBoardDAO weeklyReportBoardDAO;
	private WeeklyReportAttachDAO weeklyReportAttachDAO;
	

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setWeeklyReportBoardDAO(WeeklyReportBoardDAO weeklyReportBoardDAO) {
		this.weeklyReportBoardDAO = weeklyReportBoardDAO;
	}

	public void setWeeklyReportAttachDAO(WeeklyReportAttachDAO weeklyReportAttachDAO) {
		this.weeklyReportAttachDAO = weeklyReportAttachDAO;
	}

	@Override
	public Map<String, Object> getBoardListForPage(SearchCriteria cri) throws SQLException {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<WeeklyReportBoardVO> boardList = weeklyReportBoardDAO.selectBoardCriteria(session, cri);
			if(boardList !=null) {
				for(WeeklyReportBoardVO board : boardList) {
					addAttachList(session, board);
				}
			}
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(weeklyReportBoardDAO.selectBoardCriteriaTotalCount(session, cri));
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("boardList", boardList);
			dataMap.put("pageMaker", pageMaker);
			return dataMap;
		}finally {
			session.close();
		}
		
	}

	@Override
	public void regist(WeeklyReportBoardVO board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int bno = weeklyReportBoardDAO.selectSeqNextValue(session);
			board.setBno(bno);
			weeklyReportBoardDAO.insertBoard(session, board);
			
			if(board.getAttachList() !=null) {
				for(WeeklyReportAttachVO attach : board.getAttachList() ) {
					attach.setBno(bno);
					attach.setAttacher(board.getWriter());
					weeklyReportAttachDAO.insertAttach(session, attach);
				}
			}
			
		}finally {
			session.close();
		}

	}

	@Override
	public WeeklyReportBoardVO read(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			WeeklyReportBoardVO board = weeklyReportBoardDAO.selectBoardByBno(session, bno);
			weeklyReportBoardDAO.increaseViewCnt(session, bno);
			addAttachList(session, board);
			
			return board;
		}finally {
			session.close();
		}
		
	}

	@Override
	public WeeklyReportBoardVO getBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			WeeklyReportBoardVO board = weeklyReportBoardDAO.selectBoardByBno(session, bno);
			addAttachList(session, board);
			
			return board;
		}finally {
			session.close();
		}
	}

	@Override
	public void modify(WeeklyReportBoardVO board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			weeklyReportBoardDAO.updateBoard(session, board);
			if (board.getAttachList() != null)
				for (WeeklyReportAttachVO attach : board.getAttachList()) {					
					weeklyReportAttachDAO.insertAttach(session, attach);
				}
		}finally {
			session.close();
		}

	}

	@Override
	public void remove(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			weeklyReportBoardDAO.deleteBoard(session, bno);
		}finally {
			session.close();
		}

	}
	
	private void addAttachList(SqlSession session, WeeklyReportBoardVO board) throws SQLException {

		if (board == null)
			return;

		int bno = board.getBno();
		List<WeeklyReportAttachVO> attachList = weeklyReportAttachDAO.selectAttachesByBno(session, bno);

		board.setAttachList(attachList);
	}

	@Override
	public WeeklyReportAttachVO getAttachByAno(int ano) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			WeeklyReportAttachVO attach = weeklyReportAttachDAO.selectAttachByAno(session, ano);
			return attach;
		}finally {
			session.close();
		}
		
	}
	@Override
	public void removeAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			weeklyReportAttachDAO.deleteAttach(session, ano);

		} finally {
			session.close();
		}

	}

}
