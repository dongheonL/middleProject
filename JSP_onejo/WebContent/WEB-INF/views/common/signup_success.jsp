<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>
	alert("회원등록에 성공했습니다.\n 로그인 페이지로 이동합니다.");
	
	location.href="<%=request.getContextPath()%>/common/loginForm.do";
</script>