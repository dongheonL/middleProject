package com.jsp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jsp.context.ApplicationContext;
import com.jsp.context.ApplicationContextLoader;
import com.jsp.dto.WeeklyReportAttachVO;
import com.jsp.dto.WeeklyReportBoardVO;

public class TestWeeklyReportBoardService {

	private WeeklyReportBoardService weeklyReportBoardService;
	{
		String beanConfigXml = "build/classes/com/jsp/context/application-context.xml";
		try {
			ApplicationContextLoader.build(beanConfigXml);
			Map<String,Object> container = ApplicationContext.getApplicationContext();
			weeklyReportBoardService = (WeeklyReportBoardService)container.get("weeklyReportBoardService");
					
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

//	@Test
//	public void testGetList() throws Exception{
//		SearchCriteria cri = new SearchCriteria();
//		Map<String, Object>dataMap = weeklyReportBoardService.getBoardListForPage(cri);
//		
//		List<WeeklyReportBoardVO> boardList = (List<WeeklyReportBoardVO>)dataMap.get("boardList");
//		
//		Assert.assertEquals(1, boardList.size());
//	}
	
//	@Test
//	public void testGetBoard() throws Exception{
//		int bno=1;
//		WeeklyReportBoardVO board = weeklyReportBoardService.getBoard(bno);
//		Assert.assertNotNull(board);
//		Assert.assertNotNull(board.getAttachList());
//	}
//	
//	@Test
//	public void testReadBoard() throws Exception{
//		int bno = 1;
//		WeeklyReportBoardVO readBoard = weeklyReportBoardService.read(bno);
//		WeeklyReportBoardVO getBoard = weeklyReportBoardService.getBoard(bno);
//		Assert.assertNotNull(readBoard);
//		Assert.assertNotNull(readBoard.getAttachList());
//		Assert.assertEquals(getBoard.getViewcnt()-1, readBoard.getViewcnt());
//	}
	
//	@Test
//	public void testInsertBoard() throws Exception{
//		WeeklyReportBoardVO board = new WeeklyReportBoardVO("주간업무 협의회 자료(2017년 1월 셋째주)", "주간업무 협의회 자료(2017년 1월 셋째주)", "test");
//		WeeklyReportAttachVO attach = new WeeklyReportAttachVO("serviceTest", "serviceTest", "serviceTest");
//		WeeklyReportAttachVO attach2 = new WeeklyReportAttachVO("serviceTest2", "serviceTest2", "serviceTest2");
//		WeeklyReportAttachVO attach3 = new WeeklyReportAttachVO("serviceTest3", "serviceTest3", "serviceTest3");
//		List<WeeklyReportAttachVO> attachList = new ArrayList<WeeklyReportAttachVO>();
//		attachList.add(attach);
//		attachList.add(attach2);
//		attachList.add(attach3);
//		board.setAttachList(attachList);
//		weeklyReportBoardService.regist(board);
//		SearchCriteria cri = new SearchCriteria(1, 10, "t", "serviceTest");
//		Map<String,Object>dataMap = weeklyReportBoardService.getBoardListForPage(cri);
//		List<WeeklyReportBoardVO> boardList = (List<WeeklyReportBoardVO>)dataMap.get("boardList");
//		Assert.assertEquals(1, boardList.size());
//		Assert.assertEquals(3, boardList.get(0).getAttachList().size());
//		
//	}
	@Test
	public void testInsertBoard() throws Exception{
		WeeklyReportBoardVO board = new WeeklyReportBoardVO("주간업무 협의회 자료(2017년 10월 셋째주)", "주간업무 협의회 자료(2017년 1월 셋째주)", "test");
		WeeklyReportAttachVO attach = new WeeklyReportAttachVO("serviceTest", "serviceTest", "serviceTest");
		List<WeeklyReportAttachVO> attachList = new ArrayList<WeeklyReportAttachVO>();
		attachList.add(attach);
		board.setAttachList(attachList);
		weeklyReportBoardService.regist(board);
		
	}

//	@Test
//	public void testUpdateBoard() throws Exception{
//		WeeklyReportBoardVO targetBoard = weeklyReportBoardService.getBoard(2);
//		Assert.assertNotNull(targetBoard);
//		String update="update";
//		targetBoard.setContent(update);
//		targetBoard.setTitle(update);
//		weeklyReportBoardService.modify(targetBoard);
//		WeeklyReportBoardVO updateBoard = weeklyReportBoardService.getBoard(2);
//		Assert.assertEquals(update, updateBoard.getContent());
//		Assert.assertEquals(update, updateBoard.getTitle());
//		
//	}
	
//	@Test
//	public void deleteBoard() throws Exception{
//		int bno=2;
//		WeeklyReportBoardVO targetBoard = weeklyReportBoardService.getBoard(bno);
//		Assert.assertNotNull(targetBoard);
//		weeklyReportBoardService.remove(bno);
//		WeeklyReportBoardVO deleteBoard = weeklyReportBoardService.getBoard(bno);
//		Assert.assertNull(deleteBoard);
//		
//	}
//	@Test
//	public void testGetAttach() throws Exception {
//		WeeklyReportAttachVO nullAttach = weeklyReportBoardService.getAttachByAno(2);
//		Assert.assertNull(nullAttach);
//		WeeklyReportAttachVO attach = weeklyReportBoardService.getAttachByAno(1);
//		Assert.assertNotNull(attach);
//	}
}
