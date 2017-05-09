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

    <title>座位信息列表</title>
    <script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<script type="text/javascript">	
		var List = [];
		function init(){
			var obj={
					type:"post",
					url:"${basePath}seat/list",
					dataTpye:"json",
					contentType:"application/json"
					};
			$.ajax(obj).done(function(res){
				$("#resultList").empty();
				var list = res.result;
				for(var i = 0; i<list.length; i++){
					var u = list[i];
					var result;
					var selType = document.getElementById("selectLibrary").options;
		            for (var j = 0; j < selType.length; j++) {
		            	if(selType[j].value == u.pid){
		            		result = selType[j].text;
		            	}
		            }
					$("<tr>").append($("<th>").text(u.id))
					.append($("<th>").text(u.name))
					.append($("<th>").text(u.state))
					.append($("<th>").text(result))
					.append($("<th>").text(u.level))
					.append($("<th>").text(u.description))
					.appendTo($("#resultList"));
				}
			});
		}
		
		function selectSeat() {
			$.ajax({
				type:"post",
				url:"${basePath}seat/list",
				contentType:"application/json",
				cache : false,
				async : false,
				success : function(data) {
					var list=data.result;
					 $('#select').empty();
			         $('#select').append("<option value='"+1+"'>--请选择座位信息--</option>");  
			            for(var i in list){
			                $('#select').append("<option value='"+list[i].id+"'>"+list[i].name+"</option>");  
			            }
				}
			});
		}
		
		function selectLibrary() {
			$.ajax({
				type:"post",
				url:"${basePath}library/list",
				contentType:"application/json",
				cache : false,
				async : false,
				success : function(data) {
					var list=data.result;
					 $('#selectLibrary').empty();
			         $('#selectLibrary').append("<option value='"+1+"'>--请选择图书馆信息--</option>");  
			            for(var i in list){
			                $('#selectLibrary').append("<option value='"+list[i].id+"'>"+list[i].name+"</option>");  
			            }
				}
			});
		}

		$(function(){
			$("#addData").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=register]").show();
				var data={
						"name":$("input[name=name]").val(),
						"state":$("input[name=state]").val(),
						"pid":$("select[name=Sel_Library]").val(),
						"level":$("input[name=level]").val(),
						"description":$("input[name=description]").val(),
						};
				var obj={
						type:"POST",
						url:"${basePath}seat/add",
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
			$("#Search").on("click",function(){
				$("div[name=result]").show();
				$("div[name=register]").hide();
				if($("select[name=Sel_Seat]").val() == 1){
					init();
				}else{
					var data={
							"id":$("select[name=Sel_Seat]").val()
							};
						var obj={
							type:"POST",
							url:"${basePath}seat/get",
							data:JSON.stringify(data),
							dataTpye:"json",
							contentType:"application/json"
							};
					$.ajax(obj).done(function(res){
						if(res.code == -1){
							alert("操作失败");
						}else{
							$("#resultList").empty();
							var list = res.result;
								var u = list;
								$("<tr>").append($("<th>").text(u.id))
								.append($("<th>").text(u.name))
								.append($("<th>").text(u.address))
								.append($("<th>").text(u.start))
								.append($("<th>").text(u.end))
								.append($("<th>").text(u.description))
								.append($("<th>").text(u.isOpen))
								.append($("<th>").text(u.level))
								.appendTo($("#resultList"));
						}
					});
				}
			});
		});
		
	</script>
  </head>
  
  <body onload="selectSeat();selectLibrary();init();">
		<div width="100%" align="center"><h3>座位信息列表</h3></div>
		<hr>
		<div align="right">
			座位名称
			<select name="Sel_Seat" id="select""></select>
			<button class="btn btn-primary" type="submit" id="Search">查询座位</button>
			<button class="btn btn-primary" type="submit" id="add">添加座位</button>
		</div>
		<hr>
		<div style="width:100%; height: 100%;">
			<div name="result" width="100%" align="center">
				<div>
					<table class="table table-striped" border="1">
						<thead>
							<tr>
								<th>座位编号</th>
								<th>座位名称</th>
								<th>当前座位状态</th>
								<th>图书馆名称</th>
								<th>所在楼层</th>
								<th>描述</th>
							</tr>
						</thead>
						<tbody id="resultList"></tbody>
					</table>
				</div>
			</div>
			<div name="register" style="display:none;" align="center">
				<h3>添加座位</h3>	
				<hr>
				<table class="table table-striped" style="width: 40%;text-align: center">
					<tr>
						<td>座位名称:</td><td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>当前座位状态:</td><td><input type="text" name="state" /></td>
					</tr>
					<tr>
						<td>图书馆名称:</td>
						<td><select name="Sel_Library" id="selectLibrary"></select></td>
					</tr>
					<tr>
						<td>所在楼层:</td><td><input type="text" name="level" /></td>
					</tr>
					<tr>
						<td>描述:</td><td><input type="text" name="description" /></td>
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
