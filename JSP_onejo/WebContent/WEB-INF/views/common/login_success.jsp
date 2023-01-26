<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("${loginUser.name}님 환영합니다.");
	window.close();
	window.opener.location.reload(true);
</script>  