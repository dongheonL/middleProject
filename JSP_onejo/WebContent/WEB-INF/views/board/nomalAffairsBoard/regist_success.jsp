<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("작성하신 글이 정상적으로 등록되었습니다.");
	location.href="<%=request.getContextPath()%>/board/nomalAffairsBoard/list.do"
// 	window.location.reload(true);
</script>  