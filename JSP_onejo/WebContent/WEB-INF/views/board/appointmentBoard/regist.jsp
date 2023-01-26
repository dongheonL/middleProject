<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${loginUser.id }" var="id" />


<!-- title_area start -->
	<div class="title_area" style="background-color: #95c1e0;">

		<h2 class="pageTitle"
			style="margin-left: 20px; font-family: 'Jeju Gothic';">임용시험</h2>
		<!-- 페이지 입력 밑 -->
		<div class="location">
			<i class="fa-solid fa-house"
				style="font-size: 25px; color: black;"></i> <span class="f_nav">시험정보</span>
			<span class="tit"><strong>정보 등록</strong></span>
			<!-- 페이지 입력 밑 -->
		</div>

	</div>
					
<div class="subCntBody clearfix">

	<div class="cntBody clearfix">			
					
	 <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card  card-primary">
					<div class="card-header">
						<h4>글등록</h4>
					</div><!--end card-header  -->
					
					<div class="card-foot">
						<button type="button" style="background-color:#89C4E1; color:white; padding:10px; border-radius:5px;" id="registBtn" onclick="regist_go();">등 록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" style="background-color:#DD5353; color:white; padding:10px; border-radius:5px;" id="cancelBtn" onclick="history.go(-1);">취 소</button>
					</div><!--end card-footer  -->
					
						<div class="card-body">
							<form enctype="multipart/form-data" role="form" method="post" action="regist.do" name="registForm">
								<input type="text" id="writer" hidden="" name="writer" class="form-control" value="${loginUser.id }">

								<div class="form-group">
									<label for="title">제 목</label> 
									<input type="text" id="title" name='title' class="form-control" placeholder="제목을 쓰세요">
								</div>
								<div class="form-group">
									<label for="content">내 용</label>
									<textarea class="form-control" name="content" id="content" rows="5" placeholder="1000자 내외로 작성하세요."></textarea>
							
								</div>
								<div class="form-group">
									<div class="card">
										<div class="card-header">
											<h5 style="display: inline; line-height: 40px;">첨부파일 :</h5>
											&nbsp;&nbsp;
									<button onclick="addFile_go();" type="button" id="addFileBtn" style="background-color: #1C315E; padding: 10px; border-radius: 4px;">Add File</button>
								       </div>	
								       <div class="card-footer fileInput"></div>							
								</div>
							</div>
						</form>
					</div><!--end card-body  -->
					
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    
    
<script>

	function regist_go(){
	
		var inputs = document.querySelectorAll('input[name="uploadFile"]');
	
		for(var input of inputs){
			//console.log(input.name+" : "+input.value);
			if(input.value==""){
				alert("파일을 선택하세요.");
				input.focus();
				input.click();
				return;
			}
		}	
		
		
		var formData = {
				title : "제목은 필수입니다."					
		}
		
		var flag=true;
		Object.keys(formData).forEach(function(name){			
			if($("input[name='"+name+"']").val()==""){ //form.title.value
				$("input[name='"+name+"']").attr("placeholder",formData[name]);
				$("input[name='"+name+"']").attr("class","form-control is-invalid");
				$("input[name='"+name+"']").focus();
				flag = flag && false; 
			}else{
				$("input[name='"+name+"']").attr("class","form-control");
			}			
		});
		
		if(flag) $("form[role='form']").submit();
		
	}
	
	var dataNum=0;
	
	function addFile_go(){
		//alert("add file btn");
		
		if($('input[name="uploadFile"]').length >=5){
			alert("파일추가는 5개까지만 가능합니다.");
			return;
		}
		
		var div=$('<div>').addClass("inputRow").attr("data-no",dataNum);		
		var input=$('<input>').attr({"type":"file","name":"uploadFile"}).css("display","inline");
		div.append(input).append("<button onclick='remove_go("+dataNum+");' style='border:0;outline:0;' class='badge bg-red' type='button'>X</button>");		
		$('.fileInput').append(div);
		dataNum++;		
	}
	
	function remove_go(dataNum){
		//alert(dataNum);
		$('div[data-no="'+dataNum+'"]').remove();
	}
	
	window.onload=function(){
		$('.fileInput').on('change',"input[name='uploadFile']",function(event){
			//alert($(this).val());			
			var input = $(this)[0];
			//alert(input.files[0].size);
			if(input.files[0].size > 1024*1024*40){
				alert("첨부파일크기는 40MB 이하만 가능합니다.");
				input.value="";				
			}
			
		});	
		
		summernote_go($('#content'),'<%=request.getContextPath()%>');
	}
	
</script>