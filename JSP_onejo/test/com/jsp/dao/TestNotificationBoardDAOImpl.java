package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.command.SearchCriteria;
import com.jsp.datasource.MySqlSessionFactory;
import com.jsp.dto.NotificationBoardVO;

public class TestNotificationBoardDAOImpl {

	private SqlSessionFactory sessionFactory = new MySqlSessionFactory();
	private SqlSession session;
	private NotificationBoardDAO boardDAO = new NotificationBoardDAOImpl();
	
	@Before
	public void init() {
		session = sessionFactory.openSession(false);
		session.commit();
	}
	
	@After
	public void destroy() {
		if(session!=null) {
			session.close();
			session.rollback();
		}
	}
	
	@Test
	public void getBoardList() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		
		List<NotificationBoardVO> boardList = boardDAO.selectBoardCriteria(session, cri);
		Assert.assertEquals(1, boardList.size());
	}
	
	@Test
	public void testSelectBoardByBno()throws Exception {
		
		int bno = 1;	
		
		NotificationBoardVO board = boardDAO.selectBoardByBno(session, bno);
		
		Assert.assertNotNull(board);
	}
	@Test
	public void testSelectBoardListCount() throws Exception{
		SearchCriteria cri = new SearchCriteria();
		int count = boardDAO.selectBoardCriteriaTotalCount(session, cri);
		Assert.assertEquals(1, count);
	}
	@Test
	public void testInsertBoard()throws Exception{
		NotificationBoardVO board = new NotificationBoardVO("1", "1", "test");
		Assert.assertNull(boardDAO.selectBoardByBno(session, board.getBno()));
		boardDAO.insertBoard(session, board);
		Assert.assertNotNull(boardDAO.selectBoardByBno(session, board.getBno()));
	}
	
	@Test
	public void testUpdateBoard() throws Exception{
		NotificationBoardVO board = boardDAO.selectBoardByBno(session, 1);
		board.setTitle("test");
		board.setContent("test");
		board.setViewcnt(2);
		boardDAO.updateBoard(session, board);
		NotificationBoardVO testBoard= boardDAO.selectBoardByBno(session, board.getBno());
		Assert.assertEquals(board.getTitle(), testBoard.getTitle());
		Assert.assertEquals(board.getContent(), testBoard.getContent());

	}
	
	@Test
	public void testDeleteBoard() throws Exception{
		NotificationBoardVO board = boardDAO.selectBoardByBno(session, 1);
		Assert.assertNotNull(board);
		boardDAO.deleteBoard(session, board.getBno());
		NotificationBoardVO deleteBoard = boardDAO.selectBoardByBno(session, board.getBno());
		Assert.assertNull(deleteBoard);
	}
}
