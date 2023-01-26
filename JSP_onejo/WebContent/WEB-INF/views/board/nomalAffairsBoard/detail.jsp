<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="attachList" value=" ${nomalAffairsBoard.nomalAffairsAttachList } " />

<div class="title_area">

	<h2 class="pageTitle">일반직인사</h2>

	<div class="location">
		<a href="/main.do?s=dje" class="home" title="대전광역시교육청 홈페이지 메인으로 바로가기">HOME</a>
		<span class="f_nav">정보마당</span> <span class="f_nav">인사정보</span> <span
			class="tit"><strong
			style="text-decoration: underline; font-weight: bold;">일반직인사</strong></span>
		${nomalAffairsBoard.title }

	</div>
</div>

<div class="subCntBody clearfix">

	<div class="cntBody clearfix">

		<!--insert 테이블-->

		<article class="board-text">
			<h2 class="tit" style="padding-left: 20px;">${nomalAffairsBoard.title}</h2>
			<ul class="infoBox">
				<li><strong>작성자</strong>${member.name }</li>
				<li><strong>작성일</strong> <fmt:formatDate
						value="${nomalAffairsBoard.regDate }" pattern="yyyy-MM-dd" /></li>
				<li><strong>조회수</strong>${nomalAffairsBoard.viewcnt }</li>
			</ul>
			<ul class="infoBox_last">
				<li><strong>연락처</strong> ${member.phone }</li>
			</ul>

			<div class="viewBox">
				<p>${nomalAffairsBoard.content }</p>
			</div>
			<div style="border-bottom: 1px solid #d7d7d7"></div>
			<div class="fieldBox">
				<dl>
					<dt>첨부파일</dt>
					<dd>
						<c:forEach items="${nomalAffairsBoard.nomalAffairsAttachList }" var="nomalAffairsAttach">
							<a
								href="<%=request.getContextPath()%>/board/nomalAffairsBoard/getFile.do?ano=${nomalAffairsAttach.ano }">
								${nomalAffairsAttach.fileName }</a>

						</c:forEach>

						<br>
					</dd>
				</dl>
			</div>
			<p class="pt10"></p>
				
			<div class="btnGrp">
				<a href="list.do"> <span>목록</span>
				</a>
				<p class="pt10"></p>
			</div>
			<c:if test="${loginUser.id eq nomalAffairsBoard.writer }">
			<div class="btnGrp">
				<a href="javascript:removeCheck();"> <span>삭제</span>
				</a>
				<p class="pt10"></p>
			</div>
			</c:if>
			<c:if test="${loginUser.id eq nomalAffairsBoard.writer }">
			<div class="btnGrp">
				<a href="javascript:Submit_go('<%=request.getContextPath() %>/board/nomalAffairsBoard/modifyForm.do',${nomalAffairsBoard.bno })"> <span>수정</span>
				</a>
				<p class="pt10"></p>
			</div>
			</c:if>

			<!--insert 테이블 끝-->
		</article>
	</div>

	<form name="infoMngForm" method="POST">

		<dl class="databox">
			<dt>자료관리</dt>

			<dd>${member.department }&nbsp;${member.name }&nbsp;/${member.phone }</dd>
			<dd class="col_red">
				게재된 내용 및 운영에 대한 개선사항이 있으면 자료관리 담당자에게 연락하시기 바랍니다.

				<p class="fR pt10"></p>

			</dd>
		</dl>

	</form>

</div>
<script>
function removeCheck() {

	 if (confirm("정말 삭제하시겠습니까??") == true){    //확인

		 Submit_go('<%=request.getContextPath() %>/board/nomalAffairsBoard/remove.do',${nomalAffairsBoard.bno });

	 }else{   //취소
	     return false;
	 }
	}
	

function Submit_go(url,bno){	
	location.href=url+"?bno="+bno;
}
</script>    
