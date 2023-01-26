package com.jsp.action.notificationBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.NotificationAttachVO;
import com.jsp.dto.NotificationBoardVO;
import com.jsp.service.NotificationBoardService;

public class BoardModifyFormAction  implements Action{

	private NotificationBoardService notificationBoardService;
	

	public void setNotificationBoardService(NotificationBoardService notificationBoardService) {
		this.notificationBoardService = notificationBoardService;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/notificationBoard/modify";
		int bno = Integer.parseInt(request.getParameter("bno"));
		NotificationBoardVO board =notificationBoardService.getBoard(bno);
		
		List<NotificationAttachVO> renamedAttachList=
				MakeFileName.parseFileNameFromNotificationAttaches(board.getAttachList(), "\\$\\$");
		board.setAttachList(renamedAttachList);
		
		request.setAttribute("board", board);
		return url;
	}
	

}
