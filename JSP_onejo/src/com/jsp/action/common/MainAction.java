package com.jsp.action.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.service.NomalAffairsBoardService;

public class MainAction implements Action{
	
	private NomalAffairsBoardService nomalAffairsBoardService;

	public void setNomalAffairsBoardService(NomalAffairsBoardService nomalAffairsBoardService) {
		this.nomalAffairsBoardService = nomalAffairsBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/common/main";
		
		//입력
		SearchCriteria cri = new SearchCriteria(1,5,"","");
		
		
		//처리 : service		
		Map<String, Object> dataMap = nomalAffairsBoardService.getList(cri);

		//결과 : request.setAttribute()
		request.setAttribute("dataMap", dataMap);
		
		return url;
	}

}
