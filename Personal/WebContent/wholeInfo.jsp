<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<link rel="stylesheet" href="static/css/bootstrap.css">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/common_table.css">
<base href="<%=basePath%>">
<title>题库列表</title>
</head>
  
 <body>
	<div class="modal-content" style="height:1050px;">
		<div class="modal-header" style="padding:5px">
			<div>
			</div>
		</div>
		<div class="modal-body" style="padding:5px">
			<div id="resListDiv" style="height:85%;overflow:auto; "> 
				<table width="100%"  border="1" cellpadding="0" class="table-1"
					id="resList" style="">
					<tr>
			  			<th>ID</th>
				  		<th>题目类型</th>
				  		<th>问题</th>
				  		<th>答案</th>
			  		</tr>
					<c:forEach var="QA" items="${QAAll}"  varStatus="status"> 
		       		<tr>
				       <td>${QA.id}</td>
				       <td>${QA.type}</td>
				       <td>${QA.question}</td>
				       <td>${QA.answer}</td>
				   	</tr>
		    		</c:forEach>  
				</table>
   			</div>
		</div>
	</div>
  
  </body>
</html>
