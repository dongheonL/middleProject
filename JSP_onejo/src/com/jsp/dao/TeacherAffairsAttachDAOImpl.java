package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.TeacherAffairsAttachVO;

public class TeacherAffairsAttachDAOImpl implements TeacherAffairsAttachDAO{

	@Override
	public List<TeacherAffairsAttachVO> selectTeacherAffairsAttachesByBno(SqlSession session, int bno) throws SQLException {
		List<TeacherAffairsAttachVO> teacheerffairsattachList=session.selectList("TeacherAffairsAttach-Mapper.selectTeacherAffairsAttachByBno",bno);
		return teacheerffairsattachList;
	}

	@Override
	public TeacherAffairsAttachVO selectTeacherAffairsAttachByAno(SqlSession session, int ano) throws SQLException {
		TeacherAffairsAttachVO teacheerffairsattach=session.selectOne("TeacherAffairsAttach-Mapper.selectTeacherAffairsAttachByAno",ano);
		return teacheerffairsattach;
	}

	@Override
	public void insertTeacherAffairsAttach(SqlSession session, TeacherAffairsAttachVO teacherffairsattach) throws SQLException {
		session.update("TeacherAffairsAttach-Mapper.insertTeacherAffairsAttach",teacherffairsattach);
	}

	@Override
	public void deleteTeacherAffairsAttach(SqlSession session, int ano) throws SQLException {
		session.update("TeacherAffairsAttach-Mapper.deleteTeacherAffairsAttach",ano);
	}

	@Override
	public void deleteAllTeacherAffairsAttach(SqlSession session, int bno) throws SQLException {
		session.update("TeacherAffairsAttach-Mapper.deleteAllTeacherAffairsAttach",bno);
	}
	

}
