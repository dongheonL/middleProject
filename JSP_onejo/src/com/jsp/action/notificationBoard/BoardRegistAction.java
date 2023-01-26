package com.jsp.action.notificationBoard;

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
import com.jsp.dto.NotificationAttachVO;
import com.jsp.dto.NotificationBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.NotificationBoardService;

public class BoardRegistAction implements Action {


	private NotificationBoardService notificationBoardService;
	
	
	public void setNotificationBoardService(NotificationBoardService notificationBoardService) {
		this.notificationBoardService = notificationBoardService;
	}

	// 1. 입력 : commons-fileupload.jar 패키지를 이용하여 FileItem 형태로 변화된 MultipartResolver 를
	// 받아 PdsVO 를 완성함.
	// 업로드 파일 환경 설정
	final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	final private int MAX_FILE_SIZE = 1024 * 1024 * 50; // 50MB
	final private int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/notificationBoard/regist_success";

		MultipartHttpServletRequestParser multi = null;
		List<NotificationAttachVO> attachList = null;

		try {
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);

			// 파일처리
			// 실제 저장 경로를 설정.
			String uploadPath = GetUploadPath.getUploadPath("notificationBoard.upload");
			// 파일 저장후 List<File>를 리턴
			FileItem[] fileItems = multi.getFileItems("uploadFile");

			List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);
			// List<File> -> List<AttachVO>
			if (fileList != null) {
				attachList = new ArrayList<NotificationAttachVO>();
				for (File file : fileList) {
					NotificationAttachVO attach = new NotificationAttachVO();
					// DB에 저장할 attach에 file 내용 추가.
					attach.setFileName(file.getName());
					attach.setUploadPath(uploadPath);
					attach.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));

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
		// DB

		NotificationBoardVO board = new NotificationBoardVO();
		board.setContent(multi.getParameter("content"));
		board.setWriter(multi.getParameter("writer"));
		String title = HTMLInputFilter.htmlSpecialChars(multi.getParameter("title"));
		board.setTitle(title);
		board.setAttachList(attachList);
		notificationBoardService.regist(board);

		return url;

	}

}
