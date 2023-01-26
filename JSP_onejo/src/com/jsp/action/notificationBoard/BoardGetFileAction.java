package com.jsp.action.notificationBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.NotificationAttachVO;
import com.jsp.service.NotificationBoardService;

public class BoardGetFileAction implements Action{
	
private NotificationBoardService notificationBoardService;


	public void setNotificationBoardService(NotificationBoardService notificationBoardService) {
	this.notificationBoardService = notificationBoardService;
}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		NotificationAttachVO attach = notificationBoardService.getAttachByAno(ano);
		
		String fileName = attach.getFileName();
		String savedPath = attach.getUploadPath();
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		
		return url;
	}

}







