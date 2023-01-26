package com.jsp.action.teacherAffairsBoard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.service.TeacherAffairsBoardService;

public class BoardListAction implements Action {

	private TeacherAffairsBoardService teacherAffairsBoardService;

	public void setTeacherAffairsBoardService(TeacherAffairsBoardService teacherAffairsBoardService) {
		this.teacherAffairsBoardService = teacherAffairsBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				String url = "/board/teacherAffairsBoard/list";
				//입력
				String page = request.getParameter("page");
				String perPageNum = request.getParameter("perPageNum");
				String searchType = request.getParameter("searchType");
				String keyword = request.getParameter("keyword");
				
				if(page==null) page="1";
				if(perPageNum==null) perPageNum="10";
				
				SearchCriteria cri = new SearchCriteria(page,perPageNum,searchType,keyword);
						
				//처리 : service		
				Map<String, Object> dataMap = teacherAffairsBoardService.getList(cri);

				//결과 : request.setAttribute()
				request.setAttribute("dataMap", dataMap);
				
				
				return url;
	}
 
}
