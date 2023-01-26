package com.jsp.service;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.jsp.command.SearchCriteria;
import com.jsp.context.ApplicationContext;
import com.jsp.context.ApplicationContextLoader;
import com.jsp.dto.NotificationAttachVO;
import com.jsp.dto.NotificationBoardVO;




public class TestNotificationBoardService {
	
	private NotificationBoardService notificationBoardService;
	{
		String beanConfigXml = "build/classes/com/jsp/context/application-context.xml";
		try {
			ApplicationContextLoader.build(beanConfigXml);
			Map<String, Object> container = ApplicationContext.getApplicationContext();
			notificationBoardService = (NotificationBoardService)container.get("notificationBoardService");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetList() throws Exception{
		SearchCriteria cri = new SearchCriteria();
		Map<String, Object>dataMap = notificationBoardService.getBoardListForPage(cri);
		
		List<NotificationBoardVO> boardList = (List<NotificationBoardVO>)dataMap.get("boardList");
		
		Assert.assertEquals(2, boardList.size());
	}
	
	@Test
	public void testGetBoard() throws Exception{
		int bno=1;
		NotificationBoardVO board = notificationBoardService.getBoard(bno);
		Assert.assertNotNull(board);
		Assert.assertNotNull(board.getAttachList());
	}
	
	@Test
	public void testReadBoard() throws Exception{
		int bno = 1;
		NotificationBoardVO readBoard = notificationBoardService.read(bno);
		NotificationBoardVO getBoard = notificationBoardService.getBoard(bno);
		Assert.assertNotNull(readBoard);
		Assert.assertNotNull(readBoard.getAttachList());
		Assert.assertEquals(getBoard.getViewcnt()-1, readBoard.getViewcnt());
	}
	
//	@Test
//	public void testInsertBoard() throws Exception{
//		NotificationBoardVO board = new NotificationBoardVO("serviceTest", "serviceTest", "test");
//		NotificationAttachVO attach = new NotificationAttachVO("serviceTest", "serviceTest", "serviceTest");
//		NotificationAttachVO attach2 = new NotificationAttachVO("serviceTest2", "serviceTest2", "serviceTest2");
//		NotificationAttachVO attach3 = new NotificationAttachVO("serviceTest3", "serviceTest3", "serviceTest3");
//		List<NotificationAttachVO> attachList = new ArrayList<NotificationAttachVO>();
//		attachList.add(attach);
//		attachList.add(attach2);
//		attachList.add(attach3);
//		board.setAttachList(attachList);
//		notificationBoardService.regist(board);
//		SearchCriteria cri = new SearchCriteria(1, 10, "t", "serviceTest");
//		Map<String,Object>dataMap = notificationBoardService.getBoardListForPage(cri);
//		List<NotificationBoardVO> boardList = (List<NotificationBoardVO>)dataMap.get("boardList");
//		Assert.assertEquals(1, boardList.size());
//		Assert.assertEquals(3, boardList.get(0).getAttachList().size());
//		
//	}
	
//	@Test
//	public void testUpdateBoard() throws Exception{
//		NotificationBoardVO targetBoard = notificationBoardService.getBoard(2);
//		Assert.assertNotNull(targetBoard);
//		String update="update";
//		targetBoard.setContent(update);
//		targetBoard.setTitle(update);
//		notificationBoardService.modify(targetBoard);
//		NotificationBoardVO updateBoard = notificationBoardService.getBoard(2);
//		Assert.assertEquals(update, updateBoard.getContent());
//		Assert.assertEquals(update, updateBoard.getTitle());
//		
//	}
	
//	@Test
//	public void deleteBoard() throws Exception{
//		int bno=2;
//		NotificationBoardVO targetBoard = notificationBoardService.getBoard(bno);
//		Assert.assertNotNull(targetBoard);
//		notificationBoardService.remove(bno);
//		NotificationBoardVO deleteBoard = notificationBoardService.getBoard(bno);
//		Assert.assertNull(deleteBoard);
//		
//	}
	@Test
	public void testGetAttach() throws Exception {
		NotificationAttachVO nullAttach = notificationBoardService.getAttachByAno(2);
		Assert.assertNull(nullAttach);
		NotificationAttachVO attach = notificationBoardService.getAttachByAno(1);
		Assert.assertNotNull(attach);
	}

}
