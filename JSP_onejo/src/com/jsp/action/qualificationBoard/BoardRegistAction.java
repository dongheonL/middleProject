package com.jsp.action.qualificationBoard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.action.Action;
import com.jsp.action.utils.GetUploadPath;
import com.jsp.action.utils.MultipartHttpServletRequestParser;
import com.jsp.controller.FileUploadResolver;
import com.jsp.dto.QualificationAttachVO;
import com.jsp.dto.QualificationBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.QualificationBoardService;

public class BoardRegistAction implements Action {

	private QualificationBoardService boardService;
	public void setBoardService(QualificationBoardService boardService) {
		this.boardService = boardService;
	}
	
	final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	final private int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	final private int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/qualificationBoard/regist_success";
		
		MultipartHttpServletRequestParser multi = null;
		
		List<QualificationAttachVO> attachList=null;
		
		try {
			
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			String uploadPath = GetUploadPath.getUploadPath("appointmentboard.upload");
			
			FileItem[] fileItems = multi.getFileItems("uploadFile");
			
			List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);
			
			if(fileList != null) {
				attachList = new ArrayList<QualificationAttachVO>();
				for(File file : fileList) {
					QualificationAttachVO attach = new QualificationAttachVO();
					
					attach.setFileName(file.getName());
					attach.setUploadPath(uploadPath);
					attach.setFileType(file.getName().substring(file.getName().lastIndexOf(".")+1));
					
					attachList.add(attach);
				}
			}
			
		} catch (NotMultipartFormDataException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		QualificationBoardVO board = new QualificationBoardVO();
		board.setContent(multi.getParameter("content"));
		board.setWriter(multi.getParameter("writer"));
		board.setTitle(multi.getParameter("title"));
		board.setQualificationAttachList(attachList);
		boardService.regist(board);
 		
		
		
		return url;
	}

}
