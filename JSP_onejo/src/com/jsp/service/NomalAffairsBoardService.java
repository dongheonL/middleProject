package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.NomalAffairsAttachVO;
import com.jsp.dto.NomalAffairsBoardVO;


public interface NomalAffairsBoardService {
		Map<String, Object> getList(SearchCriteria cri) throws SQLException;

		void regist(NomalAffairsBoardVO nomalAffairsBoard) throws SQLException;

		NomalAffairsBoardVO read(int bno) throws SQLException;

		NomalAffairsBoardVO getNomalAffairsBoard(int bno) throws SQLException;

		void modify(NomalAffairsBoardVO nomalAffairsBoard) throws SQLException;

		void remove(int bno) throws SQLException;
		
		NomalAffairsAttachVO getNomalAffairsAttachByAno(int ano)throws SQLException;
		
		void removeNomalAffairsAttachByAno(int ano)throws SQLException;
}
