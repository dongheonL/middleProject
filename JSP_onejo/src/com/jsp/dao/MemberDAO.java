package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;

public interface MemberDAO {

	List<MemberVO> selectSearchMemberList(SqlSession sqlSession,SearchCriteria cri ) throws Exception;
	
	int selectSearchMemberListCount(SqlSession sqlSession, SearchCriteria cri) throws Exception;
	
	MemberVO selectMemberById(SqlSession sqlSession, String id) throws Exception;
	
	MemberVO selectMemberByNickName(SqlSession sqlSession, String nickName) throws Exception;
	
	void insertMember(SqlSession sqlSession, MemberVO member) throws Exception;
	
	void updateMember(SqlSession sqlSession, MemberVO member) throws Exception;
	
	void deleteMember(SqlSession sqlSession, String id) throws Exception;
}
