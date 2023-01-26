package com.jsp.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class SignupAction implements Action {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/common/signup_success";
		
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id").trim());
		member.setPwd(request.getParameter("pwd").trim());
		member.setName(request.getParameter("name").trim());
		member.setPhone(request.getParameter("phone").trim());
		member.setEmail(request.getParameter("email").trim());
		member.setAddress(request.getParameter("address").trim());
		member.setDepartment(request.getParameter("department"));
		
		try {
			memberService.regist(member);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		return url;
	}

}
