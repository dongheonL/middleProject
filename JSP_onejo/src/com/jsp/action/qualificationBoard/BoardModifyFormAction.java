package com.jsp.action.qualificationBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.QualificationAttachVO;
import com.jsp.dto.QualificationBoardVO;
import com.jsp.service.QualificationBoardService;

public class BoardModifyFormAction implements Action {

	public QualificationBoardService boardService;

	public void setBoardService(QualificationBoardService boardService) {
		this.boardService = boardService;

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/qualificationBoard/modify";

		int bno = Integer.parseInt(request.getParameter("bno"));

		try {
			QualificationBoardVO board = boardService.getBoard(bno);

			List<QualificationAttachVO> renamedAttachList=
					MakeFileName.parseFileNameFromQualificationAttaches(board.getQualificationAttachList(), "\\$\\$");
			board.setQualificationAttachList(renamedAttachList);
			
			request.setAttribute("board", board);

			return url;
		} catch (Exception e) {
			// error 작성
			e.printStackTrace();
			throw e;
		}
	}

}