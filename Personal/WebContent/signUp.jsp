<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=0.5,target-densitydpi=device-dpi,minimum-scale=1,maximum-scale=1.5,user-scalable=1" />
<title>注册</title>
<link rel="stylesheet" href="static/css/common_form.css">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/base.css">
</head>
<body>
	<header>
		<div class="header-line"></div>
	</header>
	<div class="content">
		<img class="content-logo" src="static/img/logo.png" alt="logo">
		<h1 class="content-title">创建账户</h1>
		<div class="content-form">
			<form method="post" action="">
				<div id="change_margin_1">
					<input id="signUpName" class="user" type="text" name="signUpName"
						placeholder="请输入用户名" onkeydown="keyup_submit(event);">
				</div>
				<div id="change_margin_2">
					<input id="password" class="password" type="password"
						name="password" placeholder="请输入密码"
						onkeydown="keyup_submit(event);">
				</div>
				<div id="change_margin_3">
					<input id="register-btn" class="content-form-signup" name="signUp"
						style="text-align: center" value="创建账户">
					<!--  <input class="content-form-signup" type="reset"  name="reset" value="重置"><br> -->
				</div>
			</form>
		</div>
		<div class="content-login-description">已经拥有账户？</div>
		<div>
			<a class="content-login-link" href="login.jsp">登录</a>
		</div>
	</div>
	<div class="update_wrap">
		<div class="modal inmodal fade" id="resultModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-lg" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true"></span><span class="sr-only"></span>
						</button>
						<h4 class="modal-title" id="modalHeader" style="display:none;" align="center"></h4>
						<!-- <small class="font-bold">这里可以显示副标题。 -->
					</div>
					<div class="modal-body" id="modalBody">
	        			<div id="infoArea" style="display:true;text-algin:center">
	        				<h4 id="info" class="modal-title" align="center" style="font-weight:bold; font-size:36px;"></h4>
	        			</div>
					</div>

					<div class="modal-footer" >
						<button type="button" class="btn btn-white" data-dismiss="modal" style="display:none">关闭</button>
						<a href="login.jsp">
							<button type="button" class="btn btn-primary" id="loginButton" style="display:none">登录
							</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="javascript/jquery-1.11.1.min.js"></script>
<script type="text/JavaScript" charset="utf-8">
	$(function() {
		window.scrollTo({ 
		    top: 100, 
		    left: 412,
		    behavior: "smooth" 
		});
	});
	function keyup_submit(e) {
		var event = window.event || e;
		if (event.keyCode == 13) {
			$("#register-btn").click();
		}
	};
	$("#register-btn").click(function() {
		$.ajax({
			type : "post",
			url : "SignUpServlet",
			data : {
				"signUpName" : $("#signUpName").val(),
				"password" : $("#password").val()
			},
			success : function(data) {
				if (data == "success") {
					console.log("register success");
					var info = document.getElementById("info");
					info.innerHTML = "注册成功！正在跳转登录页...";
					$("#resultModal").modal("show");
					setTimeout(function() {
						window.location.href = "login.jsp";
			        },  2000);
				} else if(data == "lose") {
					console.log("register lose");
					var info = document.getElementById("info");
					info.innerHTML = "用户名已存在";
					$("#resultModal").modal("show");
				} else if(data == "info empty"){
					console.log("register info is empty");
					var info = document.getElementById("info");
					info.innerHTML = "用户名和密码不能为空";
					$("#resultModal").modal("show");
				}
			}
		});
	});
</script>
<script src="javascript/bootstrap.min.js"></script>
</html>