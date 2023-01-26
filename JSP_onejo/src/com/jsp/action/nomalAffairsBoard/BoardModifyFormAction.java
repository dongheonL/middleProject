package com.jsp.action.nomalAffairsBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.action.utils.MakeFileName;
import com.jsp.dto.NomalAffairsAttachVO;
import com.jsp.dto.NomalAffairsBoardVO;
import com.jsp.service.NomalAffairsBoardService;

public class BoardModifyFormAction implements Action{
	
	private NomalAffairsBoardService nomalAffairsBoardService;

	public void setNomalAffairsBoardService(NomalAffairsBoardService nomalAffairsBoardService) {
		this.nomalAffairsBoardService = nomalAffairsBoardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/nomalAffairsBoard/modify";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		try {
			NomalAffairsBoardVO nomalAffairsBoard = nomalAffairsBoardService.getNomalAffairsBoard(bno);

			List<NomalAffairsAttachVO> renamedAttachList = MakeFileName.parseFileNameFromNomalAffairsAttaches(nomalAffairsBoard.getNomalAffairsAttachList(), "\\$\\$");
			nomalAffairsBoard.setNomalAffairsAttachList(renamedAttachList);
			
			request.setAttribute("nomalAffairsBoard", nomalAffairsBoard);

			return url;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
