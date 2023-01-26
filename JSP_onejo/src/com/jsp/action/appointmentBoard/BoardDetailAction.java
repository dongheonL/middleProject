package com.jsp.action.appointmentBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.AppointmentAttachVO;
import com.jsp.dto.AppointmentBoardVO;
import com.jsp.dto.MemberVO;
import com.jsp.service.AppointmentBoardService;
import com.jsp.service.MemberService;

public class BoardDetailAction implements Action {

	private AppointmentBoardService appointmentBoardService;
	
	private MemberService memberService;
	public void setBoardService(AppointmentBoardService boardService) {
		this.appointmentBoardService = boardService;
	}


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/appointmentBoard/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String from = request.getParameter("from");
		
		try {
			AppointmentBoardVO board =null;
			if(from !=null && from.equals("list")) {
				board = appointmentBoardService.read(bno);
				
				url="redirect:/board/appointmentBoard/detail.do?bno="+ bno;
			}else {
				board = appointmentBoardService.getBoard(bno);
			}
			
			List<AppointmentAttachVO> renamedAttachList= MakeFileName.parseFileNameFromAppointmentAttaches(board.getAppointmentAttachList(), "\\$\\$");
			board.setAppointmentAttachList(renamedAttachList);
			
			request.setAttribute("board", board);
			MemberVO member = memberService.getMemberById(board.getWriter());
			request.setAttribute("member", member);
			
			return url;
			
		}catch(Exception e) {
			e.printStackTrace();
			url=null;
			throw e;
		}
	}

}
