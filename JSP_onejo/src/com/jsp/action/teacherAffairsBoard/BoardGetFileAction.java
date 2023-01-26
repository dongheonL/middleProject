package com.jsp.action.teacherAffairsBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.service.TeacherAffairsBoardService;

public class BoardGetFileAction implements Action{
	
	private TeacherAffairsBoardService teacherAffairsBoardService;

	public void setTeacherAffairsBoardService(TeacherAffairsBoardService teacherAffairsBoardService) {
		this.teacherAffairsBoardService = teacherAffairsBoardService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		TeacherAffairsAttachVO teacherAffairsAttach = teacherAffairsBoardService.getTeacherAffairsAttachByAno(ano);
		
		String fileName = teacherAffairsAttach.getFileName();
		String savedPath = teacherAffairsAttach.getUploadPath();
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		
		return url;
	}

}







