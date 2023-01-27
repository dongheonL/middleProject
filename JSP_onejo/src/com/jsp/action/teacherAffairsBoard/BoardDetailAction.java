package com.jsp.action.teacherAffairsBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.dto.TeacherAffairsBoardVO;
import com.jsp.service.TeacherAffairsBoardService;

public class BoardDetailAction implements Action{

private TeacherAffairsBoardService teacherAffairsBoardService;

	
	public void setTeacherAffairsBoardService(TeacherAffairsBoardService teacherAffairsBoardService) {
	this.teacherAffairsBoardService = teacherAffairsBoardService;
}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/teacherAffairsBoard/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String from = request.getParameter("from");
		try {
			TeacherAffairsBoardVO teacherAffairsBoard = null;
			if(from != null && from.equals("list")) {
				teacherAffairsBoard = teacherAffairsBoardService.read(bno);
				url = "redirect:/board/teacherAffairsBoard/detail.do?bno=" + bno;
			}else {
				teacherAffairsBoard = teacherAffairsBoardService.getTeacherAffairsBoard(bno);
			}
			
			List<TeacherAffairsAttachVO> renamedAttachList=
					MakeFileName.parseFileNameFromTeacherAffairsAttaches(teacherAffairsBoard.getTeacherAffairsAttachList(), "\\$\\$");
			teacherAffairsBoard.setTeacherAffairsAttachList(renamedAttachList);
			
			request.setAttribute("teacherAffairsBoard", teacherAffairsBoard);
			
			return url;
		}catch(Exception e) {
			e.printStackTrace();			
			url=null;
			throw e;
		}
		
	}

}
