<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="static/css/common_form.css">
</head>
<body>
    <header>
        <div class="header-line"></div>
    </header>
    <div class="content">
        <img class="content-logo" src="static/img/logo.png" alt="logo">
        <h1 class="content-title">创建账户</h1>
        <div class="content-form">
            <form method="post" action=""">
                <div id="change_margin_1">
                    <input class="user" type="text" name="user" placeholder="请输入用户名"">
                </div>
                <div id="change_margin_2">
                    <input class="password" type="password" name="password" placeholder="请输入密码" ">
                </div>
                <div id="change_margin_3">
                    <input class="content-form-signup" type="submit" value="创建账户">
                </div>
            </form>
        </div>
        <div class="content-login-description">已经拥有账户？</div>
        <div><a class="content-login-link" href="login.jsp">登录</a></div>
    </div>
</body>
</html>