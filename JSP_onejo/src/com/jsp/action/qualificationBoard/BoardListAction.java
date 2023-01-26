package com.jsp.action.qualificationBoard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.service.QualificationBoardService;

public class BoardListAction implements Action {
	private QualificationBoardService qualificationBoardService;
	public void setQualificationBoardService(QualificationBoardService qualificationBoardService) {
		this.qualificationBoardService = qualificationBoardService;
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/qualificationBoard/list";
		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		if(page==null) page="1";
		if(perPageNum==null) perPageNum="10";
		
		SearchCriteria cri = new SearchCriteria(page,perPageNum,searchType,keyword);
				
		//처리 : service		
		Map<String, Object> dataMap = qualificationBoardService.getList(cri);

		//결과 : request.setAttribute()
		request.setAttribute("dataMap", dataMap);
		
		
		return url;
	}

}
