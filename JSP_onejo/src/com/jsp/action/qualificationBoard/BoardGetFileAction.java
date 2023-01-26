package com.jsp.action.qualificationBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.QualificationAttachVO;
import com.jsp.service.QualificationBoardService;

public class BoardGetFileAction implements Action {

	private QualificationBoardService boardService;
	public void setBoardService(QualificationBoardService boardService) {
		this.boardService = boardService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		QualificationAttachVO attach =boardService.getAttachByAno(ano);
		
		String fileName = attach.getFileName();
		String savedPath = attach.getUploadPath();
		
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		
		
		
		return url;
	}

}
