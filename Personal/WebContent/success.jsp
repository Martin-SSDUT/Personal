<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="static/css/bootstrap.css">
<base href="<%=basePath%>">
<title>登录成功</title>
</head>
<body>
	<div class="" style="height: 30%; padding: 2%; text-align: center;">
		<%-- <h1 class="content-title">${loginName}</h1><br> --%>
		<h1 class="content-title">欢迎登录安监题库</h1>
	</div>
	<div class="row">
		<div class="col-sm-6 col-md-4 col-lg-2"></div>
		<div class="col-sm-6 col-md-4 col-lg-3 ">
			<div class="thumbnail" style="height: 336px;">
				<a href="searchInfo.jsp" title="搜索题目" target="_blank"
					onclick=""> <img class="lazy" src="static/img/search.jpg"
					width="100%" height="150">
				</a>
				<div class="content">
					<h1 class="content-title" style="text-align: center;">搜 索 题 目
					</h1>
				</div>
			</div>
		</div>
		<div class="col-sm-6 col-md-4 col-lg-2"></div>
		<div class="col-sm-6 col-md-4 col-lg-3 ">
			<div class="thumbnail" style="height: 336px;">
				<a href="WholeInfoServlet" title="题库列表"
					target="_blank"> <img class="lazy"
					src="static/img/search.jpg" width="100%" height="10">
				</a>
				<div class="content">
					<h1 class="content-title" style="text-align: center;">题 库 列 表
					</h1>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
