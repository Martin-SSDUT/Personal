<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=0.5,target-densitydpi=device-dpi,minimum-scale=1,maximum-scale=1.5,user-scalable=1" />
<meta name="renderer" content="webkit">
<base href="<%=basePath%>">
<title>搜索题目</title>

<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/base.css">
<link rel="stylesheet" href="static/css/style.css">
<link rel="stylesheet" href="static/css/common_table.css">
</head>

<body>
	<div class="fans-bg bg18" id="fansBg"></div>
	<div class="wxpromotion-container pb10">
		<div class="w12">
			<div class="fans-header clearfix">
				<!-- <div class="logo fl">
					<img style="height:50px;width:50px;"
						src="static/img/logo.png">
				</div> -->
			</div>
			<div class="fans-tit ac fs28">
				<div class="" style="height: 8%; padding: 2%; text-align: center;">
					<h1 class="content-title" style="color: #4cb4e7">题目搜索</h1>
				</div>
			</div>

			<form name="SearchForm" id="SearchForm">
				<div class="fans-search mt15">
					<div class="input-group fans-group ac ">
						<input type="text" class="form-control fs16 ac mb10"
							id="fansSearch" placeholder="" name="searchInfo"  onkeydown="keyup_submit(event);">
						<p class="fansInputTip ac">请输入关键词搜索题目</p>
						<button class="btn btn-default hide mt20" type="button"
							name="search" value="search" id="fansSearch-btn"
							data-toggle="modal">
							查询 "<span></span>"
						</button>
					</div>
				</div>
				<div class="fans-search mt15 search"
					style="font-size: 20px; margin-left: 33%;">
					<div class="wxpromot-group row mt15">
						<div class="col-xs-2 cr79 pr">题目类型：</div>
						<ul class="col-xs-10 pl">
							<li class="unlimited active"><a
								href="javascript:timuleixingbuxian();">不限</a></li>
							<li><a href="javascript:danxuan();">单选</a></li>
							<li><a href="javascript:duoxuan();">多选</a></li>
							<li><a href="javascript:panduan();">判断</a></li>
						</ul>
					</div>
					<div class="wxpromot-group row mt15">
						<div class="col-xs-2 cr79 pr">搜索范围：</div>
						<ul class="col-xs-10 pl">
							<li class="unlimited active"><a
								href="javascript:sousuofanweibuxian();">不限</a></li>
							<li><a href="javascript:question();">按题干</a></li>
							<li><a href="javascript:answer();">按答案</a></li>
						</ul>
					</div>
				</div>
				<div style="display: none">
					<input type="text" id="questionType" name="questionType"> <input
						type="text" id="searchRange" name="searchRange">
				</div>
			</form>
			
		</div>
	</div>
	<div class="update_wrap">
		<div class="modal inmodal fade" id="resultModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-lg" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="modalHeader" style="display:none;" align="center"></h4>
						<!-- <small class="font-bold">这里可以显示副标题。 -->
					</div>
					<div class="modal-body" id="modalBody">
						<div id="successInfoArea" class="ztree" style="max-height:350px;overflow:auto;"> 
							<table width="100%"  border="1" cellpadding="0" class="table-1"
								id="resList" style="">
								<!-- 此部分内容通过ajax获取 -->
								
							</table>
	        			</div>
	        			<div id="loseInfoArea" style="display:none;">
	        				<h4 id="modalHeader" class="modal-title" align="center" style="font-weight:bold; font-size:36px;">未登录不能进行查询</h4>
	        			</div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
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
	<script type="text/JavaScript" charset="utf-8" >
		$(function() {
			$("#questionType").val("不限");
			$("#searchRange").val("不限");
		});
		function keyup_submit(e){
			var event = window.event || e; 
			    if (event.keyCode == 13){
			    	$("#fansSearch-btn").click();
			    }
		};
		$("#fansSearch-btn").click(function() {
			$.ajax({
				type : "post",
				url : "SearchServlet",
				data : {
					"searchInfo" : $("#fansSearch").val(),
					"questionType" : $("#questionType").val(),
					"searchRange" : $("#searchRange").val(),
				},
				success : function(data) {
					if (data == "lose"){
						console.log("lose");
						var successInfoArea = document.getElementById("successInfoArea");
						successInfoArea.style.display = "none";
						var loseInfoArea = document.getElementById("loseInfoArea");
						loseInfoArea.style.cssText="display:true;text-algin:center";
						var loginButton = document.getElementById("loginButton");
						loginButton.style.cssText="display:true";
					}else{
						console.log("success");
						console.log(data);
						var QAALL = data;
						//console.log(QAALL.length);
						var html = "<tr><th>ID</th><th>题目类型</th><th>问题</th><th>答案</th></tr>";
						for (var i = 0; i < QAALL.length; i++) { //遍历data数组
							var QA = QAALL[i];
							html += "<tr>"
							+ "<td>" + QA.id + "</td>"
							+ "<td>" + QA.type + "</td>"
							+ "<td>" + QA.question + "</td>"
							+ "<td>" + QA.answer + "</td>"
									+ "</tr>"
						}
						$("#resList").html(html);
					}
					$("#resultModal").modal("show");
				}
			});
		});
		function timuleixingbuxian() {
			$("#questionType").val("不限");
		}
		function danxuan() {
			$("#questionType").val("单选");
		}
		function duoxuan() {
			$("#questionType").val("多选");
		}
		function panduan() {
			$("#questionType").val("判断");
		}
		function sousuofanweibuxian() {
			$("#searchRange").val("不限");
		}
		function question() {
			$("#searchRange").val("按题干");
		}
		function answer() {
			$("#searchRange").val("按答案");
		}
	</script>
	<script src="javascript/bootstrap.min.js"></script>
	<script src="javascript/arcsearch.js" type="text/JavaScript"></script>
</html>
