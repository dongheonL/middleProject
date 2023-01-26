package com.jsp.action.teacherAffairsBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.dto.TeacherAffairsBoardVO;
import com.jsp.service.TeacherAffairsBoardService;

public class BoardModifyFormAction implements Action{
	
	private TeacherAffairsBoardService teacherAffairsBoardService;

	public void setTeacherAffairsBoardService(TeacherAffairsBoardService teacherAffairsBoardService) {
		this.teacherAffairsBoardService = teacherAffairsBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/teacherAffairsBoard/modify";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		try {
			TeacherAffairsBoardVO teacherAffairsBoard = teacherAffairsBoardService.getTeacherAffairsBoard(bno);

			List<TeacherAffairsAttachVO> renamedAttachList = MakeFileName.parseFileNameFromTeacherAffairsAttaches(teacherAffairsBoard.getTeacherAffairsAttachList(), "\\$\\$");
			teacherAffairsBoard.setTeacherAffairsAttachList(renamedAttachList);
			
			request.setAttribute("teacherAffairsBoard", teacherAffairsBoard);

			return url;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
