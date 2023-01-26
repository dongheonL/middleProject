<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="appointmentAttachList" value=" ${board.appointmentAttachList } " />

<!-- title_area start -->
<div class="title_area" style="background-color: #95c1e0;">

	<h2 class="pageTitle"
		style="margin-left: 20px; font-family: 'Jeju Gothic';">임용시험</h2>
	<!-- 페이지 입력 밑 -->
	<div class="location">
		<i class="fa-solid fa-house" style="font-size: 25px; color: black;"></i>
		<span class="f_nav">시험정보</span> <span class="tit"><strong>임용시험</strong></span>
		<!-- 페이지 입력 밑 -->
	</div>

</div>
<!-- title_area end -->


<div class="subCntBody clearfix">

	<!-- 페이지뷰 -->

	<div class="cntBody clearfix">


		<!--insert 테이블-->
		<article class="board-text">
			<h2 class="tit" style="padding-left: 20px;">${board.title}</h2>
			<ul class="infoBox">
				<li><strong>작성자</strong>${member.name }</li>
				<li><strong>작성일</strong> <fmt:formatDate
						value="${board.regDate }" pattern="yyyy-MM-dd" /></li>
				<li><strong>조회수</strong>${board.viewcnt }</li>
			</ul>
			
			<ul class="infoBox_last">
				<li><strong>연락처</strong> ${member.phone }</li>
			</ul>
			
			<div class="viewBox">
				<p>${board.content }</p>
			</div>
			
			<div style="border-bottom: 1px solid #d7d7d7"></div>
			<div class='fieldBox'>
				<dl>
					<dt>첨부파일</dt>
					<dd>
						<c:forEach items="${board.appointmentAttachList }" var="attach">
							<a
								href="<%=request.getContextPath()%>/board/appointmentBoard/getFile.do?ano=${attach.ano }">
								${attach.fileName }</a>

						</c:forEach>

						<br>
					</dd>
				</dl>
			</div>
			<p class='pt10'></p>
			<div class='btnGrp'>
				<button type="button" id="modifyBtn" style="background-color:#2C74B3; color:white; padding:10px; border-radius:5px; margin:5px;"  onclick="Submit_go('list.do','${board.bno}');">목록</button>
			<p class="pt10"></p>
			</div>
			
			<c:if test="${loginUser.id eq board.writer }">
			<div class="btnGrp">
				<a href="javascript:removeCheck();"> <span>삭제</span>
				</a>
				<p class="pt10"></p>
			</div>
			</c:if>

			<c:if test="${loginUser.id eq board.writer }">
			<div class="btnGrp">
				<a href="javascript:Submit_go('<%=request.getContextPath() %>/board/appointmentBoard/modifyForm.do',${board.bno })"> <span>수정</span>
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


		<dd>유초등교육과 정은미 / 042-616-8293
		<dd>중등교육과 박근일 / 042-616-8343</dd>
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

		 Submit_go('<%=request.getContextPath() %>/board/appointmentBoard/remove.do',${board.bno });

	 }else{   //취소
	     return false;
	 }
	}
	

function Submit_go(url,bno){	
	location.href=url+"?bno="+bno;
}
</script>  