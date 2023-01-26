package com.jsp.action.nomalAffairsBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.NomalAffairsAttachVO;
import com.jsp.service.NomalAffairsBoardService;

public class BoardGetFileAction implements Action{
	
	private NomalAffairsBoardService nomalAffairsBoardService;	
	public void setPdsService(NomalAffairsBoardService nomalAffairsBoardService) {
		this.nomalAffairsBoardService = nomalAffairsBoardService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		NomalAffairsAttachVO nomalAffairsAttach = nomalAffairsBoardService.getNomalAffairsAttachByAno(ano);
		
		String fileName = nomalAffairsAttach.getFileName();
		String savedPath = nomalAffairsAttach.getUploadPath();
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		
		return url;
	}

}







