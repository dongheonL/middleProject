package com.jsp.action.weeklyReportBoard;

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
import com.jsp.dto.WeeklyReportAttachVO;
import com.jsp.dto.WeeklyReportBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.WeeklyReportBoardService;

public class BoardModifyAction implements Action {
	private WeeklyReportBoardService weeklyReportBoardService;
	
	

	public void setWeeklyReportBoardService(WeeklyReportBoardService weeklyReportBoardService) {
		this.weeklyReportBoardService = weeklyReportBoardService;
	}

	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 50MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/weeklyReportBoard/modify_success";
		
		MultipartHttpServletRequestParser multi = null;
		List<WeeklyReportAttachVO> attachList = null;
		
		try {
			multi =  new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
			
			// 파일 삭제 및 DB삭제
			String[] deleteFiles = multi.getParameterValues("deleteFile");
			if(deleteFiles!=null && deleteFiles.length > 0) {
				for (String anoStr : deleteFiles) {
					int ano = Integer.parseInt(anoStr);
					WeeklyReportAttachVO attach = weeklyReportBoardService.getAttachByAno(ano);
					String filePath = attach.getUploadPath() + File.separator + attach.getFileName();
					File targetFile = new File(filePath);
					if(targetFile.exists()) {
						targetFile.delete();
					}
					weeklyReportBoardService.removeAttachByAno(ano); // DB 삭제
					
				}
			}
			// 추가된 파일 저장
			FileItem[] fileItems = multi.getFileItems("uploadFile");
			if (fileItems != null && fileItems.length > 0) {
				// 파일저장
				String uploadPath = GetUploadPath.getUploadPath("weeklyReportBoard.upload");
				List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);

				// attaches
				attachList = new ArrayList<WeeklyReportAttachVO>();
				if (fileList.size() > 0) {
					for (File file : fileList) {
						WeeklyReportAttachVO attach = new WeeklyReportAttachVO();
						attach.setFileName(file.getName());
						attach.setUploadPath(uploadPath);
						attach.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));
						attachList.add(attach);
						attach.setBno(Integer.parseInt(multi.getParameter("bno")));
						attach.setAttacher(multi.getParameter("writer"));
					}
				}
				
			}
						
		}catch (NotMultipartFormDataException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		WeeklyReportBoardVO board = new WeeklyReportBoardVO();
		board.setBno(Integer.parseInt(multi.getParameter("bno")));
		String title = HTMLInputFilter.htmlSpecialChars(multi.getParameter("title"));
		board.setTitle(title);
		board.setWriter(multi.getParameter("writer"));
		board.setContent(multi.getParameter("content"));
		board.setAttachList(attachList);
		
		
		try {

			// DB 수정
			weeklyReportBoardService.modify(board);

			request.setAttribute("board", board);

			return url;

		} catch (Exception e) {
			// Exception 처리
			e.printStackTrace();
			throw e;
		}
		
	}

}
