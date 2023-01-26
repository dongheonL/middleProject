<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set value="${loginUser.id }" var="id" />

<div class="title_area">

	<h2 class="pageTitle">주간업무</h2>

	<div class="location">
		<a href="/main.do?s=dje" class="home" title="대전광역시교육청 홈페이지 메인으로 바로가기">HOME</a>
		<span class="f_nav">정보마당</span> <span class="f_nav">소식알림방</span><span
			class="f_nav">주간업무</span> <span class="tit"><strong
			style="text-decoration: underline; font-weight: bold;">게시글
				수정</strong></span>


	</div>

</div>

<div class="subCntBody clearfix">

	<div class="cntBody clearfix">
		<section class="content container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card  card-primary">
						<div class="card-header">
							<h4>글 수정</h4>
						</div>
						<!--end card-header  -->
						<div class="card-body">
							<form enctype="multipart/form-data" role="form" method="post"
								action="modify.do" name="modifyForm">
								<input type="hidden" name="bno" value="${nomalAffairsBoard.bno }" />
								<input type="text" id="writer" hidden="" name="writer"
									class="form-control" value="${nomalAffairsBoard.writer }">

								<div class="form-group">
									<label for="title">제 목</label> <input type="text" id="title"
										name='title' class="form-control" placeholder="제목을 쓰세요"
										value="${nomalAffairsBoard.title }">
								</div>
								<div class="form-group">
									<label for="content">내 용</label>
									<textarea class="form-control" name="content" id="content"
										rows="5" placeholder="1000자 내외로 작성하세요.">
										${fn:escapeXml(nomalAffairsBoard.content) }
										</textarea>
								</div>
								<div class="form-group">
									<div class="card">
										<div class="card-header">
											<h5 style="display: inline; line-height: 40px;">첨부파일 :</h5>
											&nbsp;&nbsp;
											<div class="btn"
												style="background-color: #1C315E; color: white;"
												onclick="addFile_go();" type="button" id="addFileBtn">파일
												추가</div>
											<div class="card-footer fileInput">
												<ul
													class="mailbox-attachments d-flex align-items-stretch clearfix">
													<!-- 첨부파일 썸네일 -->

													<c:forEach items="${nomalAffairsBoard.nomalAffairsAttachList }" var="nomalAffairsAttach">
														<li class="attach-item thumb${nomalAffairsAttach.ano}"
															file-name="${nomalAffairsAttach.fileName }"
															target-ano="${nomalAffairsAttach.ano }">
															<div class="mailbox-attachment-info ">

																<a class="mailbox-attachment-name" name="attachedFile"
																	href="<%=request.getContextPath()%>/board/nomalAffairsBoard/getFile.do?ano=${nomalAffairsAttach.ano} ">
																	<i class="fas fa-paperclip"></i> ${nomalAffairsAttach.fileName }&nbsp;&nbsp;
																	<button type="button"
																		onclick="removeFile_go('thumb${nomalAffairsAttach.ano}');return false;"
																		style="border: 0; outline: 0;" class="badge bg-red">X</button>
																</a>
															</div>
														</li>
													</c:forEach>
												</ul>
												<br />
											</div>
										</div>
									</div>


								</div>
							</form>
						</div>
						<!--end card-body  -->
						<div class="card-footer" style="background-color: white;">
							<div class="btnGrp">
								<a href="#" title="수정버튼" onclick="modify_submit();"> <span>수정</span>
								</a> <a href="javascript:history.back();"> <span>취소</span>
								</a>
							</div>
						</div>
						<!--end card-footer  -->
					</div>
					<!-- end card -->
				</div>
				<!-- end col-md-12 -->
			</div>
			<!-- end row -->
		</section>




		<dl class="databox">
			<dt>자료관리</dt>

			<dd>행정과 이동헌 / 010-2055-2307</dd>
			<dd class="col_red">
				게재된 내용 및 운영에 대한 개선사항이 있으면 자료관리 담당자에게 연락하시기 바랍니다.

				<p class="fR pt10"></p>

			</dd>
		</dl>



	</div>
</div>
<script>
function remove_go(dataNum){
	//alert(dataNum);
	$('div[data-no="'+dataNum+'"]').remove();
}
</script>

<script>    
function modify_submit(){
	//alert("modify btn click");
	var form = $('form[name="modifyForm"]');
	
	
	//유효성 체크
	if($("input[name='title']").val()==""){
		alert(input.name+"은 필수입니다.");
		$("input[name='title']").focus();
		return;
	}
	
	//파일 첨부확인
	
	var files = document.querySelectorAll('input[name="uploadFile"]');
	for(var file of files){
		console.log(file.name+" : "+file.value);
		if(file.value==""){
			alert("파일을 선택하세요.");
			file.focus();
			return false;
		}
	}	
	
	form.submit();
}

window.onload=function(){
	summernote_go($('#content'),'<%=request.getContextPath()%>');
}

</script>

<script>
function removeFile_go(className){
	var li = $('li.'+className);
	
	if(!confirm(li.attr("file-name")+"을 정말 삭제하시겠습니까?")){
		return;
	}    
	
	li.remove();
	
	var input=$('<input>').attr({"type":"hidden",
		 "name":"deleteFile",
		 "value":li.attr("target-ano")
		}); 
	$('form[role="form"]').prepend(input);
}

var dataNum=0;

function addFile_go(){
	//alert("add file btn");
	
	var attachedFile=$('a[name="attachedFile"]').length; //기존파일
	var inputFile=$('input[name="uploadFile"]').length;	 //추가된 파일
	var attachCount=attachedFile+inputFile; //기존파일 + 추가된파일 개수
	
	if(attachCount >=5){
		alert("파일추가는 5개까지만 가능합니다.");
		return;
	}
	
	var div=$('<div>').addClass("inputRow").attr("data-no",dataNum);
	var input=$('<input>').attr({"type":"file","name":"uploadFile"}).css("display","inline");
	div.append(input).append("<button onclick='remove_go("+dataNum+");' style='border:0;outline:0;' class='badge bg-red' type='button'>X</button>");	
	$('.fileInput').append(div);	
	dataNum++;
}
</script>