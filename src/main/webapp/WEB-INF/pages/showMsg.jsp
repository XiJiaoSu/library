<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath",basePath);
%>

<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
    <title>系统信息列表</title>
    <script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<script type="text/javascript">	
		function init(){
			var obj={
					type:"post",
					url:"${basePath}msg/list",
					dataTpye:"json",
					contentType:"application/json"
					};
			$.ajax(obj).done(function(res){
				$("#resultList").empty();
				var list = res.result;
				for(var i = 0; i<list.length; i++){
					var u = list[i];
					$("<tr>").append($("<th>").text(u.id))
					.append($("<th>").text(u.title))
					.append($("<th>").text(u.message))
					.append($("<th>").text(u.time))
					.appendTo($("#resultList"));
				}
			});
		}
		
		$(function(){
			$("#addData").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=register]").show();
				var data={
						"name":$("input[name=title]").val(),
						"message":$("input[name=message]").val(),
						"time":$("input[name=time]").val(),
						};
				var obj={
						type:"POST",
						url:"${basePath}msg/add",
						data:JSON.stringify(data),
						dataTpye:"json",
						contentType:"application/json"
						};
				$.ajax(obj).done(function(res){
					createTableImg(res);
				});
			});
			function createTableImg(res){
					selectSeat();
					selectLibrary();
					init();
					$("div[name=result]").show();
					$("div[name=register]").hide();
			}
		
			$("#add").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=register]").show();
			});
			$("#return").on("click",function(){
				$("div[name=result]").show();
				$("div[name=register]").hide();
			});
		});
	</script>
  </head>
  
  <body onload="init();">
		<div width="100%" align="center"><h3>系统信息列表</h3></div>
		<hr>
		<div align="right">
			<button class="btn btn-primary" type="submit" id="add">添加消息</button>
		</div>
		<hr>
		<div style="width:100%; height: 100%;">
			<div name="result" width="100%" align="center">
				<div>
					<table class="table table-striped" border="1">
						<thead>
							<tr>
								<th>消息编号</th>
								<th>消息标题</th>
								<th>消息内容</th>
								<th>发布时间</th>
							</tr>
						</thead>
						<tbody id="resultList"></tbody>
					</table>
				</div>
			</div>
			<div name="register" style="display:none;" align="center">
				<h3>添加消息</h3>	
				<hr>
				<table class="table table-striped" style="width: 40%;text-align: center">
					<tr>
						<td>消息标题:</td><td><input type="text" name="title" /></td>
					</tr>
					<tr>
						<td>消息内容:</td><td><input type="text" name="message" /></td>
					</tr>
					<tr>
						<td>发布时间:</td>
						<td><input type="text" name="time"/></td>
					</tr>
				</table>
				<div><button class="btn btn-primary" type="submit" id="addData">添加</button>
					 <button class="btn btn-primary" type="submit" id="return">返回</button>
				</div>
			</div>
		</div>
		<hr>
  </body>
</html>
