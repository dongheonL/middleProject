package com.jsp.action.nomalAffairsBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.NomalAffairsBoardService;

public class BoardRemoveAction implements Action{
	private NomalAffairsBoardService nomalAffairsBoardService;

	public void setNomalAffairsBoardService(NomalAffairsBoardService nomalAffairsBoardService) {
		this.nomalAffairsBoardService = nomalAffairsBoardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/nomalAffairsBoard/remove_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			//DB 내용 삭제
			nomalAffairsBoardService.remove(bno);		
			return url;
		}catch (Exception e) {			
			e.printStackTrace();			
			throw e;
		}
	}

}
