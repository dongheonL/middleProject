package com.jsp.action.weeklyReportBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.WeeklyReportAttachVO;
import com.jsp.dto.WeeklyReportBoardVO;
import com.jsp.service.WeeklyReportBoardService;

public class BoardModifyFormAction  implements Action{

	private WeeklyReportBoardService weeklyReportBoardService;
	
	public void setWeeklyReportBoardService(WeeklyReportBoardService weeklyReportBoardService) {
		this.weeklyReportBoardService = weeklyReportBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/weeklyReportBoard/modify";
		int bno = Integer.parseInt(request.getParameter("bno"));
		WeeklyReportBoardVO board =weeklyReportBoardService.getBoard(bno);
		
		List<WeeklyReportAttachVO> renamedAttachList=
				MakeFileName.parseFileNameFromWeeklyReportAttaches(board.getAttachList(), "\\$\\$");
		board.setAttachList(renamedAttachList);
		
		request.setAttribute("board", board);
		return url;
	}
	

}
