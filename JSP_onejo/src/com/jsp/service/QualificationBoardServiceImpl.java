package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.QualificationAttachDAO;
import com.jsp.dao.QualificationBoardDAO;
import com.jsp.dto.QualificationAttachVO;
import com.jsp.dto.QualificationBoardVO;

public class QualificationBoardServiceImpl implements QualificationBoardService {

	private SqlSessionFactory sqlSessionFactory;
	private QualificationBoardDAO qualificationBoardDAO;
	private QualificationAttachDAO qualificationAttachDAO;
	private List<QualificationAttachVO> qualificationAttachList;
	
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setQualificationBoardDAO(QualificationBoardDAO qualificationBoardDAO) {
		this.qualificationBoardDAO = qualificationBoardDAO;
	}

	public void setQualificationAttachDAO(QualificationAttachDAO qualificationAttachDAO) {
		this.qualificationAttachDAO = qualificationAttachDAO;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<QualificationBoardVO> qualificationBoardList = qualificationBoardDAO.selectBoardCriteria(session, cri);
			if(qualificationBoardList != null)
				for(QualificationBoardVO qualificationBoard : qualificationBoardList)
					addAttachList(session,qualificationBoard);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(qualificationBoardDAO.selectBoardCriteriaTotalCount(session, cri));
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("qualificationBoardList", qualificationBoardList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		}finally {
			session.close();
		}
	}

	@Override
	public void regist(QualificationBoardVO qualificationBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int bno = qualificationBoardDAO.selectSeqNextValue(session);
			qualificationBoard.setBno(bno);
			qualificationBoardDAO.insertBoard(session, qualificationBoard);
			if(qualificationBoard.getQualificationAttachList() != null)
				for(QualificationAttachVO QualificationAttach : qualificationBoard.getQualificationAttachList()) {
					QualificationAttach.setBno(bno);
					QualificationAttach.setAttacher(qualificationBoard.getWriter());
					qualificationAttachDAO.insertAttach(session, QualificationAttach);
				}
		}finally {
			session.close();
		}

	}

	@Override
	public QualificationBoardVO read(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
		
				QualificationBoardVO qualificationBoard = qualificationBoardDAO.selectBoardByBno(session, bno);
				qualificationBoardDAO.increaseViewCnt(session, bno);
				
				addAttachList(session,qualificationBoard);
				
				return qualificationBoard;
			
		}finally {
			session.close();
		}
	}

	@Override
	public QualificationBoardVO getBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			QualificationBoardVO qualificationBoard = qualificationBoardDAO.selectBoardByBno(session, bno);
			
			addAttachList(session, qualificationBoard);
			
			return qualificationBoard;
		}finally {
			session.close();
		}
	}

	@Override
	public void modify(QualificationBoardVO qualificationBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			qualificationBoardDAO.updateBoard(session, qualificationBoard);
			if(qualificationBoard.getQualificationAttachList() != null)
				for(QualificationAttachVO qualificationAttach : qualificationBoard.getQualificationAttachList()) {
					qualificationAttachDAO.insertAttach(session, qualificationAttach);
				}
		
		
		}finally {
			session.close();
		}


	}

	@Override
	public void remove(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			qualificationBoardDAO.deleteBoard(session, bno);
		}finally {
			session.close();
		}

	}

	@Override
	public QualificationAttachVO getAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			QualificationAttachVO qualificationAttach = qualificationAttachDAO.selectAttachByAno(session, ano);
			return qualificationAttach;
		}finally {
			session.close();
		}
	}
	
	private void addAttachList(SqlSession session, QualificationBoardVO qualificationBoard) throws SQLException{
		if(qualificationBoard == null )
			return;
		
		int bno = qualificationBoard.getBno();
		List<QualificationAttachVO> qualificationattachList = qualificationAttachDAO.selectAttachByBno(session, bno);
		
		qualificationBoard.setQualificationAttachList(qualificationAttachList);
	}

}
