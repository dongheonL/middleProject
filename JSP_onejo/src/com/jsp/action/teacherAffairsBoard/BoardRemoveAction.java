package com.jsp.action.teacherAffairsBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.TeacherAffairsBoardService;

public class BoardRemoveAction implements Action{
	private TeacherAffairsBoardService teacherAffairsBoardService;

	public void setTeacherAffairsBoardService(TeacherAffairsBoardService teacherAffairsBoardService) {
		this.teacherAffairsBoardService = teacherAffairsBoardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/teacherAffairsBoard/remove_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			//DB 내용 삭제
			teacherAffairsBoardService.remove(bno);		
			return url;
		}catch (Exception e) {			
			e.printStackTrace();			
			throw e;
		}
	}

}
