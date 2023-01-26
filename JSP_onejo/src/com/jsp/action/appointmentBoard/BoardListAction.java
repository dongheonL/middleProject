package com.jsp.action.appointmentBoard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.service.AppointmentBoardService;

public class BoardListAction implements Action {

	private AppointmentBoardService appointmentBoardService;
	public void setAppointmentboadService(AppointmentBoardService appointmentboadService) {
		this.appointmentBoardService = appointmentboadService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/appointmentBoard/list";
		
		String searchType = request.getParameter("searchType");
        String keyword = request.getParameter("keyword");
        String perPageNumParam = request.getParameter("perPageNum");
        String pageParam=request.getParameter("page");
        
        SearchCriteria cri = new SearchCriteria();
        cri.setKeyword(keyword);
        cri.setSearchType(searchType);
        
        boolean criFlag = true;
        criFlag = criFlag && pageParam !=null
                        && !pageParam.isEmpty()
                        && perPageNumParam !=null
                        && !perPageNumParam.isEmpty();
        
        if(criFlag) {
              try {
                 cri.setPage(Integer.parseInt(pageParam));
                 cri.setPerPageNum(Integer.parseInt(perPageNumParam));
              }catch(Exception e) {
                 response.sendError(response.SC_BAD_REQUEST);
                 return null;
              }
        }
				
		//처리 : service		
		Map<String, Object> dataMap = appointmentBoardService.getList(cri);

		//결과 : request.setAttribute()
		request.setAttribute("dataMap", dataMap);
		
		
		return url;
	}

}
