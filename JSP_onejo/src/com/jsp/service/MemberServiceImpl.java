package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.SearchCriteria;
import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO memberDAO;
	SqlSessionFactory sqlSessionFactory;
	SqlSession sqlSession;
	
	
	

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) { 
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
	@Override
	public Map<String, Object> getMemberListForPage(SearchCriteria cri) throws Exception { //트랜잭션 처리 예시
		Map<String, Object> dataMap = new HashMap<String, Object>();
		sqlSession = sqlSessionFactory.openSession(false);
		
		try {
			List<MemberVO> memberList = memberDAO.selectSearchMemberList(sqlSession, cri);
			dataMap.put("memberList", memberList);
			sqlSession.commit();
			
			return dataMap;
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		

	}

	@Override
	public int getMemberListCount(SearchCriteria cri) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			int count =memberDAO.selectSearchMemberListCount(sqlSession, cri);
			return count;
		}finally {
			if(sqlSession!=null) sqlSession.close(); //finally 는 에러터져도 무조건 세션닫는걸 실행하라고 꼭해야함
		}
		
	}

	@Override
	public MemberVO getMemberById(String id) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(sqlSession, id);
			return member;
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	@Override
	public MemberVO getMemberByNickName(String nickName) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(sqlSession, nickName);
			return member;
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}

	@Override
	public void regist(MemberVO member) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		try {
			memberDAO.insertMember(sqlSession, member);
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
	}

	@Override
	public void modify(MemberVO member) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		try {
			memberDAO.updateMember(sqlSession, member);
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
	}

	@Override
	public void remove(String id) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		try {
			memberDAO.deleteMember(sqlSession, id);
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
	}

}
