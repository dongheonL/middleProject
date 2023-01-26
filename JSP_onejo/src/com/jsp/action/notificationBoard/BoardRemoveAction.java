package com.jsp.action.notificationBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.NotificationBoardService;

public class BoardRemoveAction implements Action {

	private NotificationBoardService notificationBoardService;
	

	public void setNotificationBoardService(NotificationBoardService notificationBoardService) {
		this.notificationBoardService = notificationBoardService;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/notificationBoard/remove_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			notificationBoardService.remove(bno);
		}catch (Exception e) {
			e.printStackTrace();			
			throw e;
		}
		return url;
	}

}
