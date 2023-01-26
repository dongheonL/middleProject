package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NotificationAttachVO;
import com.jsp.dto.NotificationBoardVO;




public interface NotificationBoardService {

	// 리스트조회
	Map<String, Object> getBoardListForPage(SearchCriteria cri) throws SQLException;


	// 글읽기(조회수증가)
	NotificationBoardVO read(int bno) throws SQLException;

	// 글조회
	NotificationBoardVO getBoard(int bno) throws SQLException;

	// 글작성
	void regist(NotificationBoardVO board) throws SQLException;

	// 글수정
	void modify(NotificationBoardVO board) throws SQLException;

	// 글삭제
	void remove(int bno) throws SQLException;
	
	NotificationAttachVO getAttachByAno(int ano)throws Exception;
	
	public void removeAttachByAno(int ano) throws SQLException;
}
