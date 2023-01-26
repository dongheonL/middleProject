package com.jsp.action.weeklyReportBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.WeeklyReportAttachVO;
import com.jsp.service.WeeklyReportBoardService;

public class BoardGetFileAction implements Action{
	
	private WeeklyReportBoardService weeklyReportBoardService;

	public void setWeeklyReportBoardService(WeeklyReportBoardService weeklyReportBoardService) {
		this.weeklyReportBoardService = weeklyReportBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		WeeklyReportAttachVO attach = weeklyReportBoardService.getAttachByAno(ano);
		
		String fileName = attach.getFileName();
		String savedPath = attach.getUploadPath();
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		
		return url;
	}

}







