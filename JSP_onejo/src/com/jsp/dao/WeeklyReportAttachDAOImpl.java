package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.WeeklyReportAttachVO;

public class WeeklyReportAttachDAOImpl implements WeeklyReportAttachDAO {

	@Override
	public List<WeeklyReportAttachVO> selectAttachesByBno(SqlSession session, int bno) throws SQLException {
		List<WeeklyReportAttachVO> weeklyReportAttachList=session.selectList("WeeklyReportAttach-Mapper.selectAttachByBno",bno);
		return weeklyReportAttachList;
	}

	@Override
	public WeeklyReportAttachVO selectAttachByAno(SqlSession session, int ano) throws SQLException {
		WeeklyReportAttachVO attach=session.selectOne("WeeklyReportAttach-Mapper.selectAttachByAno",ano);
		return attach;
	}

	@Override
	public void insertAttach(SqlSession session, WeeklyReportAttachVO attach) throws SQLException {
		session.update("WeeklyReportAttach-Mapper.insertAttach",attach);

	}

	@Override
	public void deleteAttach(SqlSession session, int ano) throws SQLException {
		session.update("WeeklyReportAttach-Mapper.deleteAttach",ano);	

	}

	@Override
	public void deleteAllAttach(SqlSession session, int bno) throws SQLException {
		session.update("WeeklyReportAttach-Mapper.deleteAllAttach",bno);	

	}

}
