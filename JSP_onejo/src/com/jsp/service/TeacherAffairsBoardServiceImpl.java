package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.TeacherAffairsAttachDAO;
import com.jsp.dao.TeacherAffairsBoardDAO;
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.dto.TeacherAffairsBoardVO;


public class TeacherAffairsBoardServiceImpl implements TeacherAffairsBoardService{
	private SqlSessionFactory sqlSessionFactory;
	private TeacherAffairsBoardDAO teacherAffairsBoardDAO;
	private TeacherAffairsAttachDAO teacherAffairsAttachDAO;

	public void setTeacherAffairsAttachDAO(TeacherAffairsAttachDAO teacherAffairsAttachDAO) {
		this.teacherAffairsAttachDAO = teacherAffairsAttachDAO;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setTeacherAffairsBoardDAO(TeacherAffairsBoardDAO teacherAffairsBoardDAO) {
		this.teacherAffairsBoardDAO = teacherAffairsBoardDAO;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<TeacherAffairsBoardVO> teacherAffairsBoardList = teacherAffairsBoardDAO.selectTeacherAffairsBoardCriteria(session, cri);
			if(teacherAffairsBoardList != null) {
				for(TeacherAffairsBoardVO teacherAffairsBoard : teacherAffairsBoardList) {
					addTeacherAttachList(session, teacherAffairsBoard);
				}
			}
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(teacherAffairsBoardDAO.selectTeacherAffairsBoardCriteriaTotalCount(session, cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("teacherAffairsBoardList", teacherAffairsBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(TeacherAffairsBoardVO teacherAffairsBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int bno = teacherAffairsBoardDAO.selectSeqNextValue(session);

			teacherAffairsBoard.setBno(bno);
			teacherAffairsBoardDAO.insertTeacherAffairsBoard(session, teacherAffairsBoard);
			
			if(teacherAffairsBoard.getTeacherAffairsAttachList() != null) {
				for(TeacherAffairsAttachVO teacherAffairsattach : teacherAffairsBoard.getTeacherAffairsAttachList()) {
					teacherAffairsattach.setBno(bno);
					teacherAffairsattach.setAttacher(teacherAffairsBoard.getWriter());
					teacherAffairsAttachDAO.insertTeacherAffairsAttach(session, teacherAffairsattach);
				}
			}

		} finally {
			session.close();
		}

	}

	@Override
	public TeacherAffairsBoardVO read(int bno) throws SQLException {
		
		SqlSession session = sqlSessionFactory.openSession();
		try {

			TeacherAffairsBoardVO teacherAffairsBoard = teacherAffairsBoardDAO.selectTeacherAffairsBoardByBno(session, bno);
			teacherAffairsBoardDAO.increaseViewCnt(session, bno);
			
			addTeacherAttachList(session, teacherAffairsBoard);

			return teacherAffairsBoard;
			
		} finally {
			session.close();
		}
	}

	@Override
	public TeacherAffairsBoardVO getTeacherAffairsBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			TeacherAffairsBoardVO teacherAffairsBoard = teacherAffairsBoardDAO.selectTeacherAffairsBoardByBno(session, bno);
			
			addTeacherAttachList(session, teacherAffairsBoard);

			return teacherAffairsBoard;
		} finally {
			session.close();
		}
	}


	@Override
	public void modify(TeacherAffairsBoardVO teacherAffairsBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			teacherAffairsBoardDAO.updateTeacherAffairsBoard(session, teacherAffairsBoard);		
			
		} finally {
			session.close();
		}
	}
	

	@Override
	public void remove(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			teacherAffairsBoardDAO.deleteTeacherAffairsBoard(session, bno);
			
		} finally {
			session.close();
		}
	}
	private void addTeacherAttachList(SqlSession session,TeacherAffairsBoardVO teacherAffairsBoard)throws SQLException{
		if(teacherAffairsBoard == null) {
			return;
		}
		int bno = teacherAffairsBoard.getBno();
		List<TeacherAffairsAttachVO> teacherAffairsAttachList = teacherAffairsAttachDAO.selectTeacherAffairsAttachesByBno(session, bno);
		
		teacherAffairsBoard.setTeacherAffairsAttachList(teacherAffairsAttachList);
	}

	@Override
	public TeacherAffairsAttachVO getTeacherAffairsAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			TeacherAffairsAttachVO teacherAffairsAttach = teacherAffairsAttachDAO.selectTeacherAffairsAttachByAno(session, ano);
			return teacherAffairsAttach;
		}finally {
			session.close();
		}
	}

	@Override
	public void removeTeacherAffairsAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			teacherAffairsAttachDAO.deleteTeacherAffairsAttach(session, ano);

		} finally {
			session.close();
		}
		
	}
}
