<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" href="static/css/common_form.css">
</head>
<body>
	<header>
        <div class="header-line"></div>
    </header>
	<div class="content">
		<img class="content-logo" src="static/img/logo.png" alt="logo">
		<h1 class="content-title">登录</h1>
		<div class="content-form">
			<form method="post" action="LoginServlet">
				<div id="change_margin_1">
					<input class="user" type="text" name="loginName" placeholder="请输入用户名"">
				</div>
				<div id="change_margin_2">
					<input class="password" type="password" name="pwd"
						placeholder="请输入密码"">
				</div>
				<div id="change_margin_3">
					<input class="content-form-signup" type="submit" name="login"
						value="登录">
					<!--  <input class="content-form-signup" type="reset"  name="reset" value="重置"><br> -->
				</div>
			</form>
		</div>
		<div class="content-login-description">没有账户？</div>
		<div>
			<a class="content-login-link" href="signUp.jsp">注册</a>
		</div>
	</div>
</body>
</html>
