package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.AppointmentAttachDAO;
import com.jsp.dao.AppointmentBoardDAO;
import com.jsp.dto.AppointmentAttachVO;
import com.jsp.dto.AppointmentBoardVO;

public class AppointmentBoardServiceImpl implements AppointmentBoardService {

	private SqlSessionFactory sqlSessionFactory;
	private AppointmentBoardDAO appointmentBoardDAO;
	private AppointmentAttachDAO appointmentAttachDAO;
	
	
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setAppointmentBoardDAO(AppointmentBoardDAO appointmentBoardDAO) {
		this.appointmentBoardDAO = appointmentBoardDAO;
	}

	public void setAppointmentAttachDAO(AppointmentAttachDAO appointmentAttachDAO) {
		this.appointmentAttachDAO = appointmentAttachDAO;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<AppointmentBoardVO> appointmentBoardList = appointmentBoardDAO.selectBoardCriteria(session, cri);
			if(appointmentBoardList != null) {
				for(AppointmentBoardVO appointmentBoard : appointmentBoardList) {
					addAttachList(session,appointmentBoard);
				}
			}
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(appointmentBoardDAO.selectBoardCriteriaTotalCount(session, cri));
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("appointmentBoardList", appointmentBoardList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		}finally {
			session.close();
		}
	}

	@Override
	public void regist(AppointmentBoardVO appointmentBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int bno = appointmentBoardDAO.selectSeqNextValue(session);
			appointmentBoard.setBno(bno);
			appointmentBoardDAO.insertBoard(session, appointmentBoard);
			if(appointmentBoard.getAppointmentAttachList() != null) {
				for(AppointmentAttachVO appointmentAttach : appointmentBoard.getAppointmentAttachList()) {
					appointmentAttach.setBno(bno);
					appointmentAttach.setAttacher(appointmentBoard.getWriter());
					appointmentAttachDAO.insertAttach(session, appointmentAttach);
				}
			}
		}finally {
			session.close();
		}

	}

	@Override
	public AppointmentBoardVO read(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
		
				AppointmentBoardVO appointmentBoard = appointmentBoardDAO.selectBoardByBno(session, bno);
				appointmentBoardDAO.increaseViewCnt(session, bno);
				
				addAttachList(session,appointmentBoard);
				
				return appointmentBoard;
			
		}finally {
			session.close();
		}
	}

	@Override
	public AppointmentBoardVO getBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			AppointmentBoardVO appointmentBoard = appointmentBoardDAO.selectBoardByBno(session, bno);
			
			addAttachList(session, appointmentBoard);
			
			return appointmentBoard;
		}finally {
			session.close();
		}
	}

	@Override
	public void modify(AppointmentBoardVO appointmentBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			appointmentBoardDAO.updateBoard(session, appointmentBoard);
			if(appointmentBoard.getAppointmentAttachList() != null)
				for(AppointmentAttachVO appointmentAttach : appointmentBoard.getAppointmentAttachList()) {
					appointmentAttachDAO.insertAttach(session, appointmentAttach);
					
				}
		}finally {
			session.close();
		}


	}

	@Override
	public void remove(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			appointmentBoardDAO.deleteBoard(session, bno);
		}finally {
			session.close();
		}

	}

	@Override
	public AppointmentAttachVO getAttachByAno(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			AppointmentAttachVO appointmentAttach = appointmentAttachDAO.selectAttachByAno(session, ano);
			return appointmentAttach;
		}finally {
			session.close();
		}
	}
	
	private void addAttachList(SqlSession session, AppointmentBoardVO appointmentBoard) throws SQLException{
		if(appointmentBoard == null )
			return;
		
		int bno = appointmentBoard.getBno();
		List<AppointmentAttachVO> appointmentAttachList = appointmentAttachDAO.selectAttachByBno(session, bno);
		
		appointmentBoard.setAppointmentAttachList(appointmentAttachList);
	}

}
