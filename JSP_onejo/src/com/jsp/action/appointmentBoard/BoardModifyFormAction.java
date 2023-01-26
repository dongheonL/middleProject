package com.jsp.action.appointmentBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.AppointmentAttachVO;
import com.jsp.dto.AppointmentBoardVO;
import com.jsp.service.AppointmentBoardService;

public class BoardModifyFormAction implements Action {

	public AppointmentBoardService boardService;

	public void setBoardService(AppointmentBoardService boardService) {
		this.boardService = boardService;

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/appointmentBoard/modify";

		int bno = Integer.parseInt(request.getParameter("bno"));

			AppointmentBoardVO board = boardService.getBoard(bno);

			List<AppointmentAttachVO> renamedAttachList=
					MakeFileName.parseFileNameFromAppointmentAttaches(board.getAppointmentAttachList(), "\\$\\$");
			board.setAppointmentAttachList(renamedAttachList);
			
			request.setAttribute("board", board);

			return url;
	}

}