package com.jsp.action.appointmentBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.AppointmentAttachVO;
import com.jsp.service.AppointmentBoardService;

public class BoardGetFileAction implements Action {

	private AppointmentBoardService boardService;
	public void setBoardService(AppointmentBoardService boardService) {
		this.boardService = boardService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		AppointmentAttachVO attach =boardService.getAttachByAno(ano);
		
		String fileName = attach.getFileName();
		String savedPath = attach.getUploadPath();
		
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		
		
		
		return url;
	}

}
