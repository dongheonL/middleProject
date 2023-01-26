package com.jsp.action.teacherAffairsBoard;

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
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.dto.TeacherAffairsBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.TeacherAffairsBoardService;

public class BoardRegistAction implements Action{
	
	private TeacherAffairsBoardService teacherAffairsBoardService;

	public void setTeacherAffairsBoardService(TeacherAffairsBoardService teacherAffairsBoardService) {
		this.teacherAffairsBoardService = teacherAffairsBoardService;
	}
	
	final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	final private int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	final private int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/teacherAffairsBoard/regist_success";
		
		MultipartHttpServletRequestParser multi = null;
		
		List<TeacherAffairsAttachVO> teacherAffairsAttachList = null;
		
		try {
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, 
															MAX_FILE_SIZE,MAX_REQUEST_SIZE);
			String uploadPath = GetUploadPath.getUploadPath("teacherAffairsBoard.upload");
			
			FileItem[] fileItems = multi.getFileItems("uploadFile");
					
			List<File> fileList = FileUploadResolver.fileUpload(fileItems,uploadPath);
			if (fileList != null) {
				teacherAffairsAttachList = new ArrayList<TeacherAffairsAttachVO>();
				for (File file : fileList) {
					TeacherAffairsAttachVO teacherAffairsAttach = new TeacherAffairsAttachVO();
					teacherAffairsAttach.setFileName(file.getName());
					teacherAffairsAttach.setUploadPath(uploadPath);
					teacherAffairsAttach.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));

					teacherAffairsAttachList.add(teacherAffairsAttach);
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
		TeacherAffairsBoardVO teacherAffairsBoard = new TeacherAffairsBoardVO();
		teacherAffairsBoard.setContent(multi.getParameter("content"));;
		teacherAffairsBoard.setWriter(multi.getParameter("writer"));
		String title = HTMLInputFilter.htmlSpecialChars(multi.getParameter("title"));
		teacherAffairsBoard.setTitle(title);
		teacherAffairsBoard.setTeacherAffairsAttachList(teacherAffairsAttachList);
		teacherAffairsBoardService.regist(teacherAffairsBoard);
		return url;
	}

}
