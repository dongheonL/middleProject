package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.NomalAffairsAttachDAO;
import com.jsp.dao.NomalAffairsBoardDAO;
import com.jsp.dto.NomalAffairsAttachVO;
import com.jsp.dto.NomalAffairsBoardVO;

public class NomalAffairsBoardServiceImpl implements NomalAffairsBoardService{

	private SqlSessionFactory sqlSessionFactory;
	private NomalAffairsBoardDAO nomalAffairsBoardDAO;
	private NomalAffairsAttachDAO nomalAffairsAttachDAO;

	public void setNomalAffairsAttachDAO(NomalAffairsAttachDAO nomalAffairsAttachDAO) {
		this.nomalAffairsAttachDAO = nomalAffairsAttachDAO;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setNomalAffairsBoardDAO(NomalAffairsBoardDAO nomalAffairsBoardDAO) {
		this.nomalAffairsBoardDAO = nomalAffairsBoardDAO;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<NomalAffairsBoardVO> nomalAffairsBoardList = nomalAffairsBoardDAO.selectNomalAffairsBoardCriteria(session, cri);
			if(nomalAffairsBoardList != null) {
				for(NomalAffairsBoardVO nomalAffairsBoard : nomalAffairsBoardList) {
					addNomalAttachList(session, nomalAffairsBoard);
				}
			}
			
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(nomalAffairsBoardDAO.selectNomalAffairsBoardCriteriaTotalCount(session, cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("nomalAffairsBoardList", nomalAffairsBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(NomalAffairsBoardVO nomalAffairsBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int bno = nomalAffairsBoardDAO.selectSeqNextValue(session);

			nomalAffairsBoard.setBno(bno);
			nomalAffairsBoardDAO.insertNomalAffairsBoard(session, nomalAffairsBoard);
			
			if(nomalAffairsBoard.getNomalAffairsAttachList() != null) {
				for(NomalAffairsAttachVO noamlAffairsattach : nomalAffairsBoard.getNomalAffairsAttachList()) {
					noamlAffairsattach.setBno(bno);
					noamlAffairsattach.setAttacher(nomalAffairsBoard.getWriter());
					nomalAffairsAttachDAO.insertNomalAffairsAttach(session, noamlAffairsattach);
				}
			}

		} finally {
			session.close();
		}

	}

	@Override
	public NomalAffairsBoardVO read(int bno) throws SQLException {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {

			NomalAffairsBoardVO nomalAffairsBoard = nomalAffairsBoardDAO.selectNomalAffairsBoardByBno(session, bno);
			nomalAffairsBoardDAO.increaseViewCnt(session, bno);
			
			addNomalAttachList(session, nomalAffairsBoard);

			return nomalAffairsBoard;
			
		} finally {
			session.close();
		}
	}

	@Override
	public NomalAffairsBoardVO getNomalAffairsBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			NomalAffairsBoardVO nomalAffairsBoard = nomalAffairsBoardDAO.selectNomalAffairsBoardByBno(session, bno);
			
			addNomalAttachList(session, nomalAffairsBoard);

			return nomalAffairsBoard;
		} finally {
			session.close();
		}
	}


	@Override
	public void modify(NomalAffairsBoardVO nomalAffairsBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			nomalAffairsBoardDAO.updateNomalAffairsBoard(session, nomalAffairsBoard);
			if (nomalAffairsBoard.getNomalAffairsAttachList() != null)
				for (NomalAffairsAttachVO nomalaffairsattach : nomalAffairsBoard.getNomalAffairsAttachList()) {					
					nomalAffairsAttachDAO.insertNomalAffairsAttach(session, nomalaffairsattach);
				}
			
		} finally {
			session.close();
		}
	}
	

	@Override
	public void remove(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			nomalAffairsBoardDAO.deleteNomalAffairsBoard(session, bno);
			
		} finally {
			session.close();
		}
	}
	private void addNomalAttachList(SqlSession session,NomalAffairsBoardVO nomalAffairsBoard)throws SQLException{
		if(nomalAffairsBoard == null) {
			return;
		}
		int bno = nomalAffairsBoard.getBno();
		List<NomalAffairsAttachVO> nomalAffairsAttachList = nomalAffairsAttachDAO.selectNomalAffairsAttachesByBno(session, bno);
		
		nomalAffairsBoard.setNomalAffairsAttachList(nomalAffairsAttachList);
	}

	@Override
	public void removeNomalAffairsAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			nomalAffairsAttachDAO.deleteNomalAffairsAttach(session, ano);

		} finally {
			session.close();
		}
	}

	@Override
	public NomalAffairsAttachVO getNomalAffairsAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			NomalAffairsAttachVO nomalAffairsAttach = nomalAffairsAttachDAO.selectNomalAffairsAttachByAno(session, ano);
			
			return nomalAffairsAttach;
		}finally {
			session.close();
		}
	}
}
