package com.jsp.action.nomalAffairsBoard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.action.utils.GetUploadPath;
import com.jsp.action.utils.MultipartHttpServletRequestParser;
import com.jsp.controller.FileUploadResolver;
import com.jsp.dto.NomalAffairsAttachVO;
import com.jsp.dto.NomalAffairsBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.NomalAffairsBoardService;

public class BoardRegistAction implements Action{
	
	private NomalAffairsBoardService nomalAffairsBoardService;

	public void setNomalAffairsBoardService(NomalAffairsBoardService nomalAffairsBoardService) {
		this.nomalAffairsBoardService = nomalAffairsBoardService;
	}
	
	final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	final private int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	final private int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/nomalAffairsBoard/regist_success";
		
		MultipartHttpServletRequestParser multi = null;
		
		List<NomalAffairsAttachVO> nomalAffairsAttachList = null;
		
		try {
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, 
															MAX_FILE_SIZE,MAX_REQUEST_SIZE);
			String uploadPath = GetUploadPath.getUploadPath("nomalAffairsBoard.upload");
			
			FileItem[] fileItems = multi.getFileItems("uploadFile");
					
			List<File> fileList = FileUploadResolver.fileUpload(fileItems,uploadPath);
			if (fileList != null) {
				nomalAffairsAttachList = new ArrayList<NomalAffairsAttachVO>();
				for (File file : fileList) {
					NomalAffairsAttachVO nomalAffairsAttach = new NomalAffairsAttachVO();
					nomalAffairsAttach.setFileName(file.getName());
					nomalAffairsAttach.setUploadPath(uploadPath);
					nomalAffairsAttach.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));

					nomalAffairsAttachList.add(nomalAffairsAttach);
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
		NomalAffairsBoardVO nomalAffairsBoard = new NomalAffairsBoardVO();
		nomalAffairsBoard.setContent(multi.getParameter("content"));;
		nomalAffairsBoard.setWriter(multi.getParameter("writer"));
		String title = HTMLInputFilter.htmlSpecialChars(multi.getParameter("title"));
		nomalAffairsBoard.setTitle(title);
		nomalAffairsBoard.setNomalAffairsAttachList(nomalAffairsAttachList);
		nomalAffairsBoardService.regist(nomalAffairsBoard);
		return url;
	}

}
