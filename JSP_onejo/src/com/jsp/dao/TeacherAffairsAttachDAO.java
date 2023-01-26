package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.TeacherAffairsAttachVO;

public interface TeacherAffairsAttachDAO {
	
	List<TeacherAffairsAttachVO> selectTeacherAffairsAttachesByBno(SqlSession session, int bno) throws SQLException;
	
	public TeacherAffairsAttachVO selectTeacherAffairsAttachByAno(SqlSession session,int ano)throws SQLException;
	
	public void insertTeacherAffairsAttach(SqlSession session,TeacherAffairsAttachVO teacheraffairsattach)throws SQLException;
	
	public void deleteTeacherAffairsAttach(SqlSession session,int ano)throws SQLException;
	
	public void deleteAllTeacherAffairsAttach(SqlSession session,int bno)throws SQLException;
}
