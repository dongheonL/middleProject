package com.jsp.action.teacherAffairsBoard;

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
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.dto.TeacherAffairsBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.TeacherAffairsBoardService;

public class BoardModifyAction implements Action{
	
	private TeacherAffairsBoardService teacherAffairsBoardService;

	public void setTeacherAffairsBoardService(TeacherAffairsBoardService teacherAffairsBoardService) {
		this.teacherAffairsBoardService = teacherAffairsBoardService;
	}
	
	final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	final private int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	final private int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/teacherAffairsBoard/modify_success";
		
		MultipartHttpServletRequestParser multi = null;
		List<TeacherAffairsAttachVO> teacherAffairsAttachList = null;

		try {
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);

			// 파일 삭제 및 DB삭제
			String[] deleteFiles = multi.getParameterValues("deleteFile");
			if (deleteFiles != null && deleteFiles.length > 0) {
				for (String anoStr : deleteFiles) {
					int ano = Integer.parseInt(anoStr);
					TeacherAffairsAttachVO teacherAffairsAttach = teacherAffairsBoardService.getTeacherAffairsAttachByAno(ano);
					String filePath = teacherAffairsAttach.getUploadPath() + File.separator + teacherAffairsAttach.getFileName();
					File targetFile = new File(filePath);
					if (targetFile.exists()) {
						targetFile.delete(); // 파일 삭제
					}
					teacherAffairsBoardService.remove(ano); // DB 삭제
				}
			}

			// 추가된 파일 저장
			FileItem[] fileItems = multi.getFileItems("uploadFile");
			if (fileItems != null && fileItems.length > 0) {
				// 파일저장
				String uploadPath = GetUploadPath.getUploadPath("teacherAffairsBoard.upload");
				List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);

				// attaches
				teacherAffairsAttachList = new ArrayList<TeacherAffairsAttachVO>();
				if (fileList.size() > 0)
					for (File file : fileList) {
						TeacherAffairsAttachVO teacherAffairsAttach = new TeacherAffairsAttachVO();
						teacherAffairsAttach.setFileName(file.getName());
						teacherAffairsAttach.setUploadPath(uploadPath);
						teacherAffairsAttach.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));
						teacherAffairsAttachList.add(teacherAffairsAttach);
						teacherAffairsAttach.setBno(Integer.parseInt(multi.getParameter("bno")));
						teacherAffairsAttach.setAttacher(multi.getParameter("writer"));
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
		teacherAffairsBoard.setBno(Integer.parseInt(multi.getParameter("bno")));
		teacherAffairsBoard.setTitle(multi.getParameter("title"));
		teacherAffairsBoard.setWriter(multi.getParameter("writer"));
		teacherAffairsBoard.setContent(multi.getParameter("content"));
		teacherAffairsBoard.setTeacherAffairsAttachList(teacherAffairsAttachList);

		try {

			// DB 수정
			teacherAffairsBoardService.modify(teacherAffairsBoard);

			request.setAttribute("teacherAffairsBoard", teacherAffairsBoard);

			return url;

		} catch (Exception e) {
			// Exception 처리
			e.printStackTrace();
			throw e;
		}
	}

}
