package com.jsp.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.command.SearchCriteria;
import com.jsp.datasource.MySqlSessionFactory;
import com.jsp.dto.MemberVO;

public class TestMemberDAOImpl {

	private SqlSessionFactory factory = new MySqlSessionFactory();
	private MemberDAO memberDAO = new MemberDAOImpl();
	private SqlSession sqlSession;
	
	
	@Before
	public void init() {
		sqlSession = factory.openSession(false);
		sqlSession.commit();
	}
	
	@After
	public void destroy() {
	if(sqlSession!=null) {
		sqlSession.rollback();
		sqlSession.close();
	}
	}
	
	@Test
	public void testMemberList() throws Exception{
		
		SearchCriteria cri = new SearchCriteria();
		List<MemberVO> memberList=memberDAO.selectSearchMemberList(sqlSession, cri);
		Assert.assertEquals(2, memberList.size());
	}
		
	
	@Test
	public void testGetMemberId() throws Exception{
		String id = "test";
		MemberVO member=memberDAO.selectMemberById(sqlSession, id);
		Assert.assertEquals(id, member.getId());
	}
	
	@Test
	public void testMemberListCount()throws Exception{
		SearchCriteria cri = new SearchCriteria();
		int count =memberDAO.selectSearchMemberListCount(sqlSession, cri);
		Assert.assertEquals(count, 2);
	}
	
	@Test
	public void testInsertMember() throws Exception{
		MemberVO insertMember = 
	new MemberVO("test12", "test", "test", "test", "test", "test", "test", 1, 1, "test", "test", "test");
		
		memberDAO.insertMember(sqlSession, insertMember);
		MemberVO getMember =memberDAO.selectMemberById(sqlSession, insertMember.getId());
		Assert.assertEquals(insertMember.getId(),getMember.getId());
	}
	
	@Test
	public void testUpdate() throws Exception{
		
		String targetId = "test";
		MemberVO targetMember = memberDAO.selectMemberById(sqlSession, targetId);
		targetMember.setName("kaka");
		targetMember.setEmail("ehdgjs@naver.com");
		targetMember.setPwd("pwdpwd");
		targetMember.setPhone("010-2313-3213");
		targetMember.setPicture("c:\\");
		
		memberDAO.updateMember(sqlSession, targetMember);
		MemberVO getMember = memberDAO.selectMemberById(sqlSession, targetId);
		Assert.assertEquals(targetMember.getName(), getMember.getName());
		Assert.assertEquals(targetMember.getEmail(), getMember.getEmail());
		Assert.assertEquals(targetMember.getPwd(), getMember.getPwd());
		Assert.assertEquals(targetMember.getPhone(), getMember.getPhone());
		Assert.assertEquals(targetMember.getPicture(), getMember.getPicture());
		
	}
	
	@Test 
	public void testDeleteMember() throws Exception{
		
		String targetId = "test";
		
		MemberVO deletMember = memberDAO.selectMemberById(sqlSession, targetId);
		Assert.assertNotNull(deletMember);
		
		memberDAO.deleteMember(sqlSession, targetId);
		
		MemberVO getMember = memberDAO.selectMemberById(sqlSession, targetId);
		Assert.assertNull(getMember);
		
	}
	@Test
	public void testGetMemberNickName() throws Exception{
		String memberNickName = "test";
		MemberVO member =memberDAO.selectMemberByNickName(sqlSession, memberNickName);
		Assert.assertEquals(memberNickName, member.getNickName());
	}
}

