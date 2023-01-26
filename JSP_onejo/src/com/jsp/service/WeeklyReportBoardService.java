package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.WeeklyReportAttachVO;
import com.jsp.dto.WeeklyReportBoardVO;


public interface WeeklyReportBoardService {

	// 리스트조회
	Map<String, Object> getBoardListForPage(SearchCriteria cri) throws SQLException;


	// 글읽기(조회수증가)
	WeeklyReportBoardVO read(int bno) throws SQLException;

	// 글조회
	WeeklyReportBoardVO getBoard(int bno) throws SQLException;

	// 글작성
	void regist(WeeklyReportBoardVO board) throws SQLException;

	// 글수정
	void modify(WeeklyReportBoardVO board) throws SQLException;

	// 글삭제
	void remove(int bno) throws SQLException;
	
	WeeklyReportAttachVO getAttachByAno(int ano)throws Exception;
	
	public void removeAttachByAno(int ano) throws SQLException;
}
