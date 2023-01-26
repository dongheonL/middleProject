package com.jsp.action.nomalAffairsBoard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.service.NomalAffairsBoardService;

public class BoardListAction implements Action {

	private NomalAffairsBoardService nomalAffairsBoardService;

	public void setNomalAffairsBoardService(NomalAffairsBoardService nomalAffairsBoardService) {
		this.nomalAffairsBoardService = nomalAffairsBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				String url = "/board/nomalAffairsBoard/list";
				String page = request.getParameter("page");
				String perPageNum = request.getParameter("perPageNum");
				String searchType = request.getParameter("searchType");
				String keyword = request.getParameter("keyword");
				
				if(page==null) page="1";
				if(perPageNum==null) perPageNum="10";
				
				SearchCriteria cri = new SearchCriteria(page,perPageNum,searchType,keyword);
				
				//처리 : service		
				Map<String, Object> dataMap = nomalAffairsBoardService.getList(cri);

				//결과 : request.setAttribute()
				request.setAttribute("dataMap", dataMap);
				
				
				return url;
	}
 
}
