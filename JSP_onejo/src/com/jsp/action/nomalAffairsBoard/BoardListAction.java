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
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");

		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);

		boolean criFlag = true;
		criFlag = criFlag && pageParam != null && !pageParam.isEmpty() && perPageNumParam != null
				&& !perPageNumParam.isEmpty();
		if (criFlag) {
			try {
				cri.setPage(Integer.parseInt(pageParam));
				cri.setPerPageNum(Integer.parseInt(perPageNumParam));
			} catch (Exception e) {
				response.sendError(response.SC_BAD_REQUEST);
				return null;
			}
		}
		try {
			Map<String, Object> dataMap = nomalAffairsBoardService.getList(cri);
			request.setAttribute("dataMap", dataMap);
			return url;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
