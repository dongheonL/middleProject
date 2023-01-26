package com.jsp.action.appointmentBoard;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.AppointmentBoardService;

public class BoardRemoveAction implements Action {

	private AppointmentBoardService boardService;
	
	public void setBoardService(AppointmentBoardService boardService) {
		this.boardService = boardService;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/board/appointmentBoard/remove";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			boardService.remove(bno);
			return url;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
