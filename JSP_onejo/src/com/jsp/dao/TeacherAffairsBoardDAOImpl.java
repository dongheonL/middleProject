package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.TeacherAffairsBoardVO;

public class TeacherAffairsBoardDAOImpl implements TeacherAffairsBoardDAO{

	@Override
	public List<TeacherAffairsBoardVO> selectTeacherAffairsBoardCriteria(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<TeacherAffairsBoardVO> teacherAffairsBoardList=
		   session.selectList("TeacherAffairsBoard-Mapper.selectSearchTeacherAffairsBoardList",cri,rowBounds);	
			
		return teacherAffairsBoardList;
	}

	@Override
	public int selectTeacherAffairsBoardCriteriaTotalCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count=session.selectOne("TeacherAffairsBoard-Mapper.selectSearchTeacherAffairsBoardListCount",cri);
		return count;
	}

	@Override
	public void insertTeacherAffairsBoard(SqlSession session, TeacherAffairsBoardVO teacherAffairsBoard) throws SQLException {		
		session.update("TeacherAffairsBoard-Mapper.insertTeacherAffairsBoard",teacherAffairsBoard);		
	}

	@Override
	public int selectSeqNextValue(SqlSession session) throws SQLException {
		int bno=session.selectOne("TeacherAffairsBoard-Mapper.selectTeacherAffairsBoardSeqNext");
		return bno;
	}

	@Override
	public TeacherAffairsBoardVO selectTeacherAffairsBoardByBno(SqlSession session, int bno) throws SQLException {
		TeacherAffairsBoardVO teacherAffairsBoard=session.selectOne("TeacherAffairsBoard-Mapper.selectTeacherAffairsBoardByBno",bno);
		return teacherAffairsBoard;
	}

	@Override
	public void increaseViewCnt(SqlSession session, int bno) throws SQLException {
		session.update("TeacherAffairsBoard-Mapper.increaseViewCnt",bno);
	}
	
	@Override
	public void updateTeacherAffairsBoard(SqlSession session,TeacherAffairsBoardVO teacherAffairsBoard) throws SQLException {
		session.update("TeacherAffairsBoard-Mapper.updateTeacherAffairsBoard",teacherAffairsBoard);
	}

	@Override
	public void deleteTeacherAffairsBoard(SqlSession session,int bno) throws SQLException {
		session.update("TeacherAffairsBoard-Mapper.deleteTeacherAffairsBoard",bno);
	}

}
