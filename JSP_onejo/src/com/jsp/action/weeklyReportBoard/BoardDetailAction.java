package com.jsp.action.weeklyReportBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.MemberVO;
import com.jsp.dto.WeeklyReportAttachVO;
import com.jsp.dto.WeeklyReportBoardVO;
import com.jsp.service.MemberService;
import com.jsp.service.WeeklyReportBoardService;

public class BoardDetailAction implements Action {

	private WeeklyReportBoardService weeklyReportBoardService;
	private MemberService memberService;
	
	public void setWeeklyReportBoardService(WeeklyReportBoardService weeklyReportBoardService) {
		this.weeklyReportBoardService = weeklyReportBoardService;
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/weeklyReportBoard/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String from = request.getParameter("from");
		
		try {
			
			WeeklyReportBoardVO board = null;
			if(from !=null && from.equals("list")) {
				board = weeklyReportBoardService.read(bno);
				url="redirect:/board/weeklyReportBoard/detail.do?bno="+bno;
			}else {
				board = weeklyReportBoardService.getBoard(bno);
			}
			
			List<WeeklyReportAttachVO> renameAttachList = 
					MakeFileName.parseFileNameFromWeeklyReportAttaches(board.getAttachList(), "\\$\\$");
			board.setAttachList(renameAttachList);
			request.setAttribute("board", board);
			
			MemberVO member = memberService.getMemberById(board.getWriter());
			request.setAttribute("member", member);
			return url;
		}catch (Exception e) {
			e.printStackTrace();			
			url=null;
			throw e;
		}
			
		
		
		
	}

}
