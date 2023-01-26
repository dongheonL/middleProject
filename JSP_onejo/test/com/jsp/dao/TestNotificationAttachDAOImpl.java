package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.MySqlSessionFactory;
import com.jsp.dto.NotificationAttachVO;

public class TestNotificationAttachDAOImpl {

	SqlSessionFactory sessionFactory = new MySqlSessionFactory();
	NotificationAttachDAO attachDAO = new NotificationAttachDAOImpl();
	SqlSession session;
	
	@Before
	public void init() {
		session = sessionFactory.openSession(false);
		session.commit();
	}
	
	@After
	public void destroy() {
		if(session!=null) {
			session.close();
		}
		session.rollback();
	}
	
	@Test
	public void testSelectList() throws Exception {
		int bno = 1;
		List<NotificationAttachVO> attachList=attachDAO.selectAttachesByBno(session, bno);
	Assert.assertEquals(1, attachList.size());
	}

	@Test
	public void testSelectAttachByAno() throws Exception{
		int ano = 1;
		NotificationAttachVO attach = attachDAO.selectAttachByAno(session, ano);
		Assert.assertNotNull(attach);
	}
	
	@Test
	public void testInsertAttach() throws Exception{
		Assert.assertNull(attachDAO.selectAttachByAno(session, 8));
		NotificationAttachVO attach = new NotificationAttachVO("test", "test", "test");
		attachDAO.insertAttach(session, attach);
		Assert.assertNotNull(attachDAO.selectAttachByAno(session, 8));
	}
	
	@Test
	public void testDeleteAttach() throws Exception{
		Assert.assertNotNull(attachDAO.selectAttachByAno(session, 1));
		attachDAO.deleteAttach(session, 1);
		Assert.assertNull(attachDAO.selectAttachByAno(session, 1));
	}
}
