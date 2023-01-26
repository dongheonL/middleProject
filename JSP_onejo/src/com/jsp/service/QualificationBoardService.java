package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.QualificationAttachVO;
import com.jsp.dto.QualificationBoardVO;

public interface QualificationBoardService {

			Map<String, Object> getList(SearchCriteria cri) throws SQLException;

			void regist(QualificationBoardVO qualificationBoard) throws SQLException;

			QualificationBoardVO read(int bno) throws SQLException;

			QualificationBoardVO getBoard(int bno) throws SQLException;

			void modify(QualificationBoardVO qualificationBoard) throws SQLException;

			void remove(int bno) throws SQLException;
			
			QualificationAttachVO getAttachByAno(int ano)throws SQLException;
}
