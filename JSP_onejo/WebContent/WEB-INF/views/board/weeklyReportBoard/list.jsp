<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="boardList" value="${dataMap.boardList }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="totalCount" value="${dataMap.pageMaker.totalCount }" />

<!-- title_area start -->
<div class="title_area">

	<h2 class="pageTitle"
		style="margin-left: 20px; font-family: 'Jeju Gothic';">주간업무</h2>
	<!-- 페이지 입력 밑 -->
	<div class="location">
		<i class="fa-solid fa-house" style="font-size: 25px; color: black;"></i>
		<span class="f_nav">정보마당</span> <span class="tit"><strong
			style="text-decoration: underline; font-weight: bold;">주간업무</strong></span>
		<!-- 페이지 입력 밑 -->
	</div>

</div>
<!-- title_area end -->

<!-- subCntBody 메인페이지입니다 -->
<div class="subCntBody clearfix">





	<div class="cntBody clearfix">

		<div class="noti_txt">
			<p class="bul1">자료 업로드시 기본 폰트외 사용 금지(윤서체, 한양체 등)</p>
		</div>

		<input type="hidden" name="srch1NM" value="COL1_CNTS"> <input
			type="hidden" name="srch2NM" value="STATUS_YN">

		<div class="inform_bg mb20"></div>

		<div class="inform_bg mb20"></div>
		<section class="boardTop">
			<p class="board-total">
				<span>전체<strong style="font-weight: bold;">
						${totalCount }</strong>건
				</span>
			</p>
			<!-- 게시판 검색 -->

			<fieldset class="board-srch">
				<div>
					<select style="width: 100px;" name="perPageNum" id="perPageNum">
						<option value="10"
							${cri.perPageNum == 10 ? 'selected="selected"' : '' }>정렬개수</option>
						<option value="2"
							${cri.perPageNum == 2 ? 'selected="selected"' : '' }>2개씩</option>
						<option value="3"
							${cri.perPageNum == 3 ? 'selected="selected"' : '' }>3개씩</option>
						<option value="5"
							${cri.perPageNum == 5 ? 'selected="selected"' : '' }>5개씩</option>
					</select> <select name="searchType" title="검색할 명을 선택해주세요" class="selTxt">
						<option value="t"
							${cri.searchType=='t' ? 'selected="selected"':'' }>제목</option>
						<option value="c"
							${cri.searchType=='c' ? 'selected="selected"':'' }>내용</option>
						<option value="tc"
							${cri.searchType=='tc' ? 'selected="selected"':'' }>제목+내용</option>
						<option value="w"
							${cri.searchType=='w' ? 'selected="selected"':'' }>작성자</option>
						<option value="cw"
							${cri.searchType=='cw' ? 'selected="selected"':'' }>내용+작성자</option>
					</select> <input name="keyword" class="txt inpTxt" title="검색어를 입력해주세요"
						type="text" placeholder="검색어를 입력하세요." value="${cri.keyword }">
					<button class="btnSearch" onclick="javascript:list_go(1);"
						title="검색실행">검색</button>
				</div>
			</fieldset>

			<!-- //게시판 검색 -->
		</section>

		<div class="board-text">
			<table class="wb">
				<caption>주간업무의 대한 번호 제목 첨부 조회수 작성일정보를 제공합니다</caption>
				<colgroup>
					<col style="width: 7%">
					<col style="width: auto;">
					<col style="width: 7%">
					<col style="width: 7%">
					<col style="width: 15%">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">첨부</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty boardList }">
						<c:forEach items="${boardList }" var="board">

							<tr onmouseover="this.style.backgroundColor='#EFF8FF'"
								onfocus="this.style.backgroundColor='#EFF8FF'"
								onmouseout="this.style.backgroundColor=''"
								onblur="this.style.backgroundColor=''" align="center"
								style="padding: 20px;">
								<td>${board.bno }</td>
								<td class="link text-center"><a
									href="detail.do?bno=${board.bno }&from=list" border="0"
									title=${board.title } style="text-decoration: none;">${board.title }
								</a></td>
								<td><c:if test="${!empty board.attachList}">
										<img
											src="<%=request.getContextPath()%>/resources/images/comm/board/icon/ic_add_file.gif"
											alt="첨부파일" width="14" height="14" align="absmiddle"
											border="0/">
									</c:if></td>


								<td>${board.viewcnt }</td>
								<td><fmt:formatDate value="${board.regDate }"
										pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</c:if>

					<c:if test="${empty boardList }">
						<tr>
							<td colspan="5" class="text-center">해당내용이 없습니다.</td>
						</tr>
					</c:if>


				</tbody>
			</table>
			<div class="card-footer" style="background: white;">
				<c:if test="${not empty loginUser }">
					<div class="btnGrp">
						<a href="#" onclick="Go_write();"
							title="글쓰기"><span>글쓰기</span></a>
					</div>
				</c:if>
				<div style="display:${!empty boardList ? 'visible' : 'none' };">
				<%@ include file="/WEB-INF/module/pagination.jsp"%>
				</div>
			</div>
		</div>

	</div>


</div>
<!-- subCntBody 메인페이지 끝입니다 -->
<script>
function Go_write() {
	location.href="registForm.do";
}
</script>