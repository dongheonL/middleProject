package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.AppointmentAttachVO;
import com.jsp.dto.AppointmentBoardVO;

public interface AppointmentBoardService {

	    // 리스트조회
		Map<String, Object> getList(SearchCriteria cri) throws SQLException;

		// 글작성
		void regist(AppointmentBoardVO appointmentBoard) throws SQLException;

		// 글읽기(조회수증가)
		AppointmentBoardVO read(int bno) throws SQLException;

		// 글조회
		AppointmentBoardVO getBoard(int bno) throws SQLException;

		// 글수정
		void modify(AppointmentBoardVO appointmentBoard) throws SQLException;

		// 글삭제
		void remove(int bno) throws SQLException;
		
		//첨부파일 조회
		AppointmentAttachVO getAttachByAno(int ano)throws SQLException;
}
