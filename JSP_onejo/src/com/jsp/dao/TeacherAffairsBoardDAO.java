package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.TeacherAffairsBoardVO;



public interface TeacherAffairsBoardDAO {
	List<TeacherAffairsBoardVO> selectTeacherAffairsBoardCriteria(SqlSession session,SearchCriteria cri) throws SQLException;
	int selectTeacherAffairsBoardCriteriaTotalCount(SqlSession session,SearchCriteria cri) throws SQLException;
	TeacherAffairsBoardVO selectTeacherAffairsBoardByBno(SqlSession session,int bno)throws SQLException;
	void insertTeacherAffairsBoard(SqlSession session,TeacherAffairsBoardVO teacherAffairsBoard)throws SQLException;
	void updateTeacherAffairsBoard(SqlSession session,TeacherAffairsBoardVO teacherAffairsBoard)throws SQLException;
	void deleteTeacherAffairsBoard(SqlSession session,int bno)throws SQLException;
	int selectSeqNextValue(SqlSession session) throws SQLException;
	void increaseViewCnt(SqlSession session,int bno)throws SQLException;
}
