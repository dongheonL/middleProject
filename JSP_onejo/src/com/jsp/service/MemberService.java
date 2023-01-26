package com.jsp.service;

import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;

public interface MemberService {

	public Map<String, Object> getMemberListForPage(SearchCriteria cri) throws Exception;
	
	public int getMemberListCount(SearchCriteria cri) throws Exception;
	
	public MemberVO getMemberById(String id) throws Exception;
	
	public MemberVO getMemberByNickName(String nickName) throws Exception;
	
	public void regist(MemberVO member) throws Exception;
	
	public void modify(MemberVO member) throws Exception;
	
	public void remove(String id) throws Exception;
}
