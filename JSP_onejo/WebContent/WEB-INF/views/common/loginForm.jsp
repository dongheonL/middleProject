<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<title>로그인</title>

<!-- Content Header (Page header) -->
<section class="content-header"  style="height: 200px;">
	<div class="container-fluid"></div>
</section>

<section class="content container-fluid">
	<div class="row">
	<div class="col-3"></div>
		<div class="col-md-6">
			<div class="card card-primary">
				<div class="card-header">
					<h3 class="card-title">로그인</h3>
				</div>
				<!--end card-header  -->
				<div class="card-body">
					<form role="form" method="post" action="login.do">
						<div class="card-body">
							<div class="form-group">
								<label for="id">아이디</label> <input type="text"
									class="form-control" id="id" name="id">
							</div>
							<div class="form-group">
								<label for="pwd">비밀번호</label> <input type="password"
									class="form-control" id="pwd" name="pwd" placeholder="">
							</div>
						</div>

						<div class="card-footer">
							<div style="margin-top: 20px;">
								<button type="button" class="btn btn-primary btn-block"
									onclick="login_go();">로그인</button>
							</div>
							<div style="margin-top: 20px;">
								<button type="button" class="btn btn-primary btn-block"
									onclick="location.href='signupForm.do'">회원가입</button>
							</div>
						</div>
					</form>
					<!--end card-footer  -->
				</div>
				<!-- end card -->
			</div>
			<!-- end col-md-12 -->
		</div>
		<div class="col-3"></div>
		</div>
		<!-- end row -->
</section>

<script>
	function login_go() {

		var formData = {
			id : "아이디를 입력해주세요.",
			pwd : "비밀번호를 입력해주세요."
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

		if (flag)
			$("form[role='form']").submit();

	}
</script>