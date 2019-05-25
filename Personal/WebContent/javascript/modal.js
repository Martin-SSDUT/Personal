$(function() {
	$("#questionType").val("不限");
	$("#searchRange").val("不限");

});
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
			console.log("success");
			var QAALL = data;
			console.log(QAALL.length);
			var html = "<tr><th>ID</th><th>题目类型</th><th>问题</th><th>答案</th></tr>";
			for (var i = 0; i < QAALL.length; i++) { //遍历data数组
				var QA = QAALL[i];
				if (i % 2 == 0) {
					backGroundColor = "#70F3FF"
				} else {
					backGroundColor = "#FAFF72"
				}
				html += "<tr>"
				+ "<td>" + QA.id + "</td>"
				+ "<td>" + QA.type + "</td>"
				+ "<td>" + QA.question + "</td>"
				+ "<td>" + QA.answer + "</td>"
						+ "</tr>"
			}
			$("#resList").html(html);
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
