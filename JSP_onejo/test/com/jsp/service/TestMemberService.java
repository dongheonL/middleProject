package com.jsp.service;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.jsp.command.SearchCriteria;
import com.jsp.context.ApplicationContext;
import com.jsp.context.ApplicationContextLoader;
import com.jsp.dto.MemberVO;


public class TestMemberService {

	private MemberService memberService;// = new MemberServiceImpl();
	{
		String beanConfigXml = "build/classes/com/jsp/context/application-context.xml";
		try {
			ApplicationContextLoader.build(beanConfigXml);
			Map<String,Object> container = ApplicationContext.getApplicationContext();			
			memberService=(MemberService)container.get("memberService");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testGetMember()throws Exception{
		String id = "test";
		
		MemberVO member = memberService.getMemberById(id);
		
		Assert.assertEquals(id, member.getId());
	} 	
	
	@Test
	public void testMemberList()throws Exception{
		SearchCriteria cri = new SearchCriteria();
		Map<String,Object> dataMap = memberService.getMemberListForPage(cri);

		List<MemberVO> memberList = (List<MemberVO>)dataMap.get("memberList");
		
		Assert.assertEquals(1,memberList.size() );
	}
	
	@Test
	public void testInsert() throws Exception{
		MemberVO member = new MemberVO("test3", "test3", "test3", "test3", "test3", "test3", "test3", 1, 1, "test3", "test3", "test3");
	
		memberService.regist(member);
	}
	
	@Test
	public void testUpdate() throws Exception{
		MemberVO updateMember = memberService.getMemberById("test2");
		updateMember.setPwd("testUpdate");
		memberService.modify(updateMember);
		MemberVO targetUpdateMember = memberService.getMemberById("test2");
		Assert.assertEquals(updateMember.getPwd(), targetUpdateMember.getPwd());
	}
	
	@Test
	public void testDelete() throws Exception{
		MemberVO member = memberService.getMemberById("test2");
		Assert.assertNotNull(member);
		memberService.remove("test2");
		MemberVO deleteMember = memberService.getMemberById("test2");
		Assert.assertNull(deleteMember);
	}
	
	@Test
	public void testGetListCount() throws Exception{
		SearchCriteria cri = new SearchCriteria();
		int count = memberService.getMemberListCount(cri);
		Assert.assertEquals(2, count);
	}
	
	@Test
	public void testGetNickName() throws Exception{
		String name = "test";
		MemberVO member = memberService.getMemberByNickName(name);
		Assert.assertNotNull(member);
	}
	

	
	
	
}





