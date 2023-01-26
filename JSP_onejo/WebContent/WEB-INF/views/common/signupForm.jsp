<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!-- subCntBody 메인페이지입니다 -->
<div class="subCntBody clearfix">


	<!-- Outer Row -->
	<div class="row justify-content-center">

		<div class="col">

				<div class="card-body p-0">
					<!-- Nested Row within Card Body -->
					<div class="row">

						<div class="col-lg-12">
							<div class="p-5">

								<div class="card card-primary mx-auto" style="width: 70%;">
									<div class="card-header">
										<h3 class="card-title">회원가입</h3>
									</div>
									<!--end card-header  -->
									<div class="card-body">

										<form class="user" role="form" method="post"
											action="signup.do">
											<div class="form-group">
												<label for="id"><span>아이디</span></label>
												<div class="input-group">
													<input id="id" class="form-control" type="text" name="id"
														maxlength="12" placeholder="영문 대소문자와 숫자 4~12자리로 입력해야합니다."
														onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;);">
													<span class="input-group-append-smt">
														<button type="button"
															style="border-radius: 3px; padding: 10px;"
															class="btn btn-primary " onclick="idCheck_go();">중복확인</button>
													</span>
												</div>
											</div>
											<div class="form-group">
												<label for="pwd"><span>비밀번호</span> </label> <input
													type="password" class="form-control form-control-user"
													id="pwd" name="pwd" placeholder="">
											</div>
											<div class="form-group">
												<label for="repwd"><span>비밀번호 재확인</span> </label> <input
													type="password" class="form-control form-control-user"
													id="repwd" name="repwd" placeholder=""> <span
													style="display: none;" id="pwdcheck_text"
													style="color: red;">재확인 비밀번호가 일치하지 않습니다.</span>
											</div>
											<div class="form-group">
												<label for="name"><span>이름</span> </label> <input
													type="text" id="name"
													class="form-control form-control-user" name="name"
													maxlength="3" placeholder="ex)홍길동">
											</div>

											<div class="form-group">
												<label for="phone"><span>휴대폰번호</span> </label> <input
													type="tel" id="phone"
													class="form-control form-control-user" name="phone"
													placeholder="숫자만입력해주세요." maxlength="11">
											</div>

											<div class="form-group">
												<label for="email"><span>이메일</span> </label> <input
													type="text" id="email"
													class="form-control form-control-user" name="email"
													placeholder="ex)qwer@qwe.com">

											</div>

											<div class="form-group">
												<label for="address"><span>주소</span> </label> <input
													type="text" id="address"
													class="form-control form-control-user" name="address"
													placeholder="ex)대전광역시 서구 둔산동 111번지">
											</div>

											<div class="form-group">
												<label for="department"><span>부서</span> </label> <select
													name="department"
													class="form-control form-control-user input_department">
													<option value="false"></option>
													<option value="중등교육과">중등교육과</option>
													<option value="고등교육과">고등교육과</option>
													<option value="초등교육과">초등교육과</option>
													<option value="행정과">행정과</option>
													<option value="총무과">총무과</option>
												</select>
											</div>

										</form>
										<div style="margin-top: 20px;">
											<button type="button" class="btn btn-primary btn-block mx-auto "
												id="loginBtn"
												style="display: block; width: 97%; border-radius: 3px;"
												onclick="signup_go()">회원가입</button>
										</div>
									</div>
									<!--end card-footer  -->
								</div>
								<!-- end card -->
							</div>














						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


<!--subCntBody 메인페이지 끝입니다 -->


<script>
	var password = document.getElementById("pwd");
	var confirm_password = document.getElementById("repwd");

	function validatePassword() {
		if (password.value != confirm_password.value) {
			$("#pwdcheck_text").css("color", "red");
			$("#pwdcheck_text").css("display", "block");

		} else {
			$("#pwdcheck_text").css("display", "none");

		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>




<script>
<!-- 아이디 중복체크 -->
var checkedID ="";
function idCheck_go(){
	//alert("id check btn click");
	
	var input_ID=$('input[name="id"]');
	
	if(input_ID.val().length<4 || input_ID.val().length>12){
		alert("사용할수 없는 아이디입니다.");
		return;
	}
		

	 $.ajax({
		 url : "idCheck.do?id="+input_ID.val().trim(),    	 	
    	 success : function(result){
   		  if(result.toUpperCase() == "DUPLICATED"){
                 alert("중복된 아이디 입니다.");
                 $('input[name="id"]').focus();
   		  }else{
              alert("사용가능한 아이디 입니다.");
              checkedID=input_ID.val().trim();
              $('input[name="id"]').val(input_ID.val().trim());             
           } 
    	 },
    	 error:function(data){
    		 alert("시스템장애로 가입이 불가합니다.");
    	 }
	 });
}

</script>


<script>
	function signup_go() {

		var formData = {
			id : "아이디를 입력해주세요.",
			pwd : "비밀번호를 입력해주세요.",
			repwd : "재확인 비밀번호를 입력해주세요.",
			name : "이름을 입력해주세요.",
			email : "이메일을 입력해주세요.",
			phone : "휴대폰번호를 입력해주세요.",
			address : "주소를 입력해주세요."
		}

		var flag = true;
		Object.keys(formData).forEach(
				function(name) {
					if ($("input[name='" + name + "']").val() == "") { //form.title.value
						$("input[name='" + name + "']").attr("placeholder",
								formData[name]);
						$("input[name='" + name + "']").attr("class",
								"form-control is-invalid");
						$("input[name='" + name + "']").focus();
						flag = flag && false;
					} else {
						$("input[name='" + name + "']").attr("class",
								"form-control");
					}
				});

		if ($(".input_department").val() == "false") {
			$(".input_department").addClass("form-control is-invalid");
			flag = flag && false;
		} else {
			$(".input_department").removeClass("is-invalid");

		}

		if ($("#email").val().indexOf('@') == -1) {
			$("#email").addClass("is-invalid");
			$("#email").attr("placeholder", "이메일 형식이 아닙니다.");
			flag = flag && false;
			$("#email").focus();
		} else {
			$("#email").removeClass("is-invalid");
		}
		if ($("#pwd").val() != $("#repwd").val())
			flag = flag && false;

		if (Number.isNaN($("#phone").val()))
			flag = flag && false;
		
		if($('input[name="id"]').val()!=checkedID){
		    alert("아이디 중복 확인이 필요합니다.");
		    flag = flag && false;
		}
		
		if (flag)
			$("form[role='form']").submit();

	}
</script>