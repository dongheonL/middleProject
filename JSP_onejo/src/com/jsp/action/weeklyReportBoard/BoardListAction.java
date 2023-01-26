package com.jsp.action.weeklyReportBoard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.service.WeeklyReportBoardService;

public class BoardListAction implements Action {

	private WeeklyReportBoardService weeklyReportBoardService;
	
	public void setWeeklyReportBoardService(WeeklyReportBoardService weeklyReportBoardService) {
		this.weeklyReportBoardService = weeklyReportBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/weeklyReportBoard/list";
		
		//입력
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);
		
		boolean criFlag = true;
		criFlag = criFlag && pageParam !=null
				          && !pageParam.isEmpty()
				          && perPageNumParam !=null
				          && !perPageNumParam.isEmpty();
		if(criFlag) {
			try {
				cri.setPage(Integer.parseInt(pageParam));
				cri.setPerPageNum(Integer.parseInt(perPageNumParam));
			}catch(Exception e) {
				response.sendError(response.SC_BAD_REQUEST);
				return null;
			}
		}
		try {
			Map<String,Object> dataMap = weeklyReportBoardService.getBoardListForPage(cri);
			request.setAttribute("dataMap", dataMap);
			return url;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
