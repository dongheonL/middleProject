package com.jsp.action.qualificationBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.MemberVO;
import com.jsp.dto.QualificationAttachVO;
import com.jsp.dto.QualificationBoardVO;
import com.jsp.service.MemberService;
import com.jsp.service.QualificationBoardService;

public class BoardDetailAction implements Action {
	private MemberService memberService;
	private QualificationBoardService qualificationBoardService;
	public void setBoardService(QualificationBoardService boardService) {
		this.qualificationBoardService = boardService;
	}


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/qualificationBoard/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String from = request.getParameter("from");
		
		try {
			QualificationBoardVO board =null;
			if(from !=null && from.equals("list")) {
				board = qualificationBoardService.read(bno);
				
				url="redirect:/board/qualificationBoard/detail.do?bno="+ bno;
			}else {
				board = qualificationBoardService.getBoard(bno);
			}
			
			List<QualificationAttachVO> renamedAttachList= MakeFileName.parseFileNameFromQualificationAttaches(board.getQualificationAttachList(), "\\$\\$");
			board.setQualificationAttachList(renamedAttachList);
			
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
