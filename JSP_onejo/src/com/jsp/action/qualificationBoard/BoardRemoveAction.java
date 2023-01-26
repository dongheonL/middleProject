package com.jsp.action.qualificationBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.QualificationBoardService;

public class BoardRemoveAction implements Action {

	private QualificationBoardService boardService;
	
	public void setBoardService(QualificationBoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/board/qualificationBoard/remove";
		
		int bno = Integer.parseInt("bno");
		
		try {
			boardService.remove(bno);
			return url;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
