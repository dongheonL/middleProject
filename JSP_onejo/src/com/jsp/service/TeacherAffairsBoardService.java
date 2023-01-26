package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.TeacherAffairsAttachVO;
import com.jsp.dto.TeacherAffairsBoardVO;


public interface TeacherAffairsBoardService {
		Map<String, Object> getList(SearchCriteria cri) throws SQLException;

		void regist(TeacherAffairsBoardVO teacherAffairsBoard) throws SQLException;

		TeacherAffairsBoardVO read(int bno) throws SQLException;

		TeacherAffairsBoardVO getTeacherAffairsBoard(int bno) throws SQLException;

		void modify(TeacherAffairsBoardVO teacherAffairsBoard) throws SQLException;

		void remove(int bno) throws SQLException;
		
		TeacherAffairsAttachVO getTeacherAffairsAttachByAno(int ano)throws SQLException;
		
		void removeTeacherAffairsAttachByAno(int ano)throws SQLException;
}
