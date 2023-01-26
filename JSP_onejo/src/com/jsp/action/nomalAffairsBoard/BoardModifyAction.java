package com.jsp.action.nomalAffairsBoard;

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
import com.jsp.dto.NomalAffairsAttachVO;
import com.jsp.dto.NomalAffairsBoardVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.NomalAffairsBoardService;

public class BoardModifyAction implements Action{
	
	private NomalAffairsBoardService nomalAffairsBoardService;

	public void setNomalAffairsBoardService(NomalAffairsBoardService nomalAffairsBoardService) {
		this.nomalAffairsBoardService = nomalAffairsBoardService;
	}
	
	final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	final private int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	final private int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/nomalAffairsBoard/modify_success";
		
		MultipartHttpServletRequestParser multi = null;
		List<NomalAffairsAttachVO> nomalAffairsAttachList = null;

		try {
			multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);

			// 파일 삭제 및 DB삭제
			String[] deleteFiles = multi.getParameterValues("deleteFile");
			if (deleteFiles != null && deleteFiles.length > 0) {
				for (String anoStr : deleteFiles) {
					int ano = Integer.parseInt(anoStr);
					NomalAffairsAttachVO nomalAffairsAttach = nomalAffairsBoardService.getNomalAffairsAttachByAno(ano);
					String filePath = nomalAffairsAttach.getUploadPath() + File.separator + nomalAffairsAttach.getFileName();
					File targetFile = new File(filePath);
					if (targetFile.exists()) {
						targetFile.delete(); // 파일 삭제
					}
					nomalAffairsBoardService.remove(ano); // DB 삭제
				}
			}

			// 추가된 파일 저장
			FileItem[] fileItems = multi.getFileItems("uploadFile");
			if (fileItems != null && fileItems.length > 0) {
				// 파일저장
				String uploadPath = GetUploadPath.getUploadPath("nomalAffairsBoard.upload");
				List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);

				// attaches
				nomalAffairsAttachList = new ArrayList<NomalAffairsAttachVO>();
				if (fileList.size() > 0)
					for (File file : fileList) {
						NomalAffairsAttachVO attach = new NomalAffairsAttachVO();
						attach.setFileName(file.getName());
						attach.setUploadPath(uploadPath);
						attach.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));
						nomalAffairsAttachList.add(attach);
						attach.setBno(Integer.parseInt(multi.getParameter("bno")));
						attach.setAttacher(multi.getParameter("writer"));
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
		nomalAffairsBoard.setBno(Integer.parseInt(multi.getParameter("bno")));
		nomalAffairsBoard.setTitle(multi.getParameter("title"));
		nomalAffairsBoard.setWriter(multi.getParameter("writer"));
		nomalAffairsBoard.setContent(multi.getParameter("content"));
		nomalAffairsBoard.setNomalAffairsAttachList(nomalAffairsAttachList);

		try {

			// DB 수정
			nomalAffairsBoardService.modify(nomalAffairsBoard);

			request.setAttribute("nomalAffairsBoard", nomalAffairsBoard);

			return url;

		} catch (Exception e) {
			// Exception 처리
			e.printStackTrace();
			throw e;
		}
	}

}
