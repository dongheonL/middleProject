package com.jsp.action.notificationBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.MemberVO;
import com.jsp.dto.NotificationAttachVO;
import com.jsp.dto.NotificationBoardVO;
import com.jsp.service.MemberService;
import com.jsp.service.NotificationBoardService;

public class BoardDetailAction implements Action {

	private NotificationBoardService notificationBoardService;
	private MemberService memberService;
	
	
	
	public void setNotificationBoardService(NotificationBoardService notificationBoardService) {
		this.notificationBoardService = notificationBoardService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/notificationBoard/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String from = request.getParameter("from");
		
		try {
			
			NotificationBoardVO board = null;
			if(from !=null && from.equals("list")) {
				board = notificationBoardService.read(bno);
				url="redirect:/board/notificationBoard/detail.do?bno="+bno;
			}else {
				board = notificationBoardService.getBoard(bno);
			}
			
			List<NotificationAttachVO> renameAttachList = 
					MakeFileName.parseFileNameFromNotificationAttaches(board.getAttachList(), "\\$\\$");
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
