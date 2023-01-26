<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="qualificationBoardList" value="${dataMap.qualificationBoardList }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="totalCount" value="${dataMap.pageMaker.totalCount }" />

<!-- title_area start -->
	<div class="title_area">

		<h2 class="pageTitle"
			style="margin-left: 20px; font-family: 'Jeju Gothic';">검정고시</h2>
		<!-- 페이지 입력 밑 -->
		<div class="location">
			<i class="fa-solid fa-house"
				style="font-size: 25px; color: black;"></i> <span class="f_nav">시험정보</span>
			<span class="tit"><strong>검정고시</strong></span>
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
		
			<input type="hidden" name="srch1NM" value="COL1_CNTS"> 
			<input type="hidden" name="srch2NM" value="STATUS_YN">
			
			
         <div class="inform_bg mb20"></div>
         
         <div class="inform_bg mb20"></div>
		     <section class=“boardTop”>
					<p class="board-total">
						<span>전체<strong style="font-weight: bold;">
								${totalCount }</strong>건
						</span>
					</p>
					  
		    <fieldset class="board-srch">
            <div>
               <select style="width: 100px;" name="perPageNum" id="perPageNum">
                  <option value="10" ${cri.perPageNum == 10 ? 'selected="selected"' : '' }>정렬개수</option>
                  <option value="2"  ${cri.perPageNum == 2 ? 'selected="selected"' : '' }>2개씩</option>
                  <option value="3"  ${cri.perPageNum == 3 ? 'selected="selected"' : '' }>3개씩</option>
                  <option value="5"  ${cri.perPageNum == 5 ? 'selected="selected"' : '' }>5개씩</option>
               </select> <select name="searchType" title="검색할 명을 선택해주세요" class="selTxt">
                  <option value="t"  ${cri.searchType=='t' ? 'selected="selected"':'' }>제목</option>
                  <option value="c"  ${cri.searchType=='c' ? 'selected="selected"':'' }>내용</option>
                  <option value="tc" ${cri.searchType=='tc' ? 'selected="selected"':'' }>제목+내용</option>
                  <option value="w"  ${cri.searchType=='w' ? 'selected="selected"':'' }>작성자</option>
                  <option value="cw" ${cri.searchType=='cw' ? 'selected="selected"':'' }>내용+작성자</option>
               </select> 
               <input name="keyword" class="txt inpTxt" title="검색어를 입력해주세요"
                  type="text" placeholder="검색어를 입력하세요." value="${cri.keyword }">
               <button class="btnSearch" onclick="javascript:list_go(1);"
                  title="검색실행">검색</button>
            </div>
         </fieldset>
			 		
			</section>
		
			 <div class="board-text">
			     <table class="wb">
			    	 <caption>일반직 및 교원의 대한 번호 제목 작성자 작성일 조회수 정보를 제공합니다.</caption>
			     <thead>
					<tr style=“font-size:3em;”>
					   <th style=“width:10%”>번호</th>
					   <th style=“width:20%”>제목</th>
			  	 	   <th style=““>첨부파일</th>
					   <th style=“width:7%”>작성자</th>
				       <th>작성일자</th>
					   <th style=“width:10%”>조회수</th>
					 </tr>
			     </thead>
			     <tbody>
			               <c:forEach items="${qualificationBoardList }"  var="qualificationBoard">
	    						<tr onmouseover="this.style.backgroundColor='#EFF8FF'"
								onfocus="this.style.backgroundColor='#EFF8FF'"
								onmouseout="this.style.backgroundColor=''"
								onblur="this.style.backgroundColor=''" align="center"
								style="padding: 20px;">
								<td>${qualificationBoard.bno }</td>
								<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden;
								  white-space: nowrap; text-overflow: ellipsis;">
									<a href="javascript:submit_go('detail.do?bno=${qualificationBoard.bno}&from=list','상세보기');">
										<span class="col-sm-12 ">${qualificationBoard.title }</span>
									</a>
					     	   </td>
								
								<td><c:if test="${!empty qualificationBoard.qualificationAttachList}">
										<img src="<%=request.getContextPath()%>/resources/images/comm/board/icon/ic_add_file.gif"
											alt="첨부파일" width="14" height="14" align="absmiddle"
											border="0/">
									</c:if>
									<c:if test="${empty qualificationBoard.qualificationAttachList}">
										 <span>-</span>
									</c:if>
									
								</td>
								<td>${qualificationBoard.writer }</td>
								<td><fmt:formatDate value="${qualificationBoard.regDate }" pattern="yyyy-MM-dd" /></td>
								<td>${qualificationBoard.viewcnt }</td>
							    </tr>		
							</c:forEach>		
			          <c:if test="${empty qualificationBoardList}">
							<tr>
								<td colspan="5" class="text-center">해당내용이 없습니다.</td>
							</tr>
					  </c:if>
			          
			        </tbody>
			        </table>  	 
			    </div>
				<div class="card-footer" style="background: white;">
						
						<button type="button" style="background-color:#89C4E1; color:white; padding:10px; border-radius:5px;" id="registBtn" onclick="Go_write();">글 등 록</button>
					<div style="display:${!empty qualificationBoardList ? 'visible' : 'none' };">
						<%@ include file="/WEB-INF/module/pagination.jsp"%>
					</div>
				</div>
		 
</div>
</div>
<form name="infoMngForm" method="POST">
	<dl class="databox">
		<dd>총무과 이동헌 / 010-2055-2307</dd>
		
		<dd class="col_red">게재된 내용 및 운영에 대한 개선사항이 있으면 자료관리 담당자에게 연락하시기 바랍니다.
				        
		<p class="fR pt10">
		</p>
		
		</dd>
		
	</dl>

</form>		

		
				<!-- subCntBody 메인페이지 끝입니다 -->
<script>
function Go_write() {
	location.href="registForm.do";
}
</script>

<script>
function submit_go(url,bno){	
	location.href=url+"?bno="+bno;
}
</script>	
