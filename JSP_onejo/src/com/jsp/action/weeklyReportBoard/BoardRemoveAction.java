package com.jsp.action.weeklyReportBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.WeeklyReportBoardService;

public class BoardRemoveAction implements Action {

	private WeeklyReportBoardService weeklyReportBoardService;
	
	public void setWeeklyReportBoardService(WeeklyReportBoardService weeklyReportBoardService) {
		this.weeklyReportBoardService = weeklyReportBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/weeklyReportBoard/remove_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			weeklyReportBoardService.remove(bno);
		}catch (Exception e) {
			e.printStackTrace();			
			throw e;
		}
		return url;
	}

}
