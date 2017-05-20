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
					.append($("<th>").text(new Date(u.time).Format("yyyy-MM-dd HH:mm:ss")))
					.appendTo($("#resultList"));
				}
			});
		}
		
		$(function(){
			$("#addData").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=register]").show();
				$("div[name=delete]").hide();
				var data={
						"title":$("input[name=title]").val(),
						"message":$("textarea[name=message]").val(),
						};
				var obj={
						type:"POST",
						url:"${basePath}msg/add",
						data:JSON.stringify(data),
						dataTpye:"json",
						contentType:"application/json"
						};
				$.ajax(obj).done(function(res){
					init();
					$("div[name=result]").show();
					$("div[name=register]").hide();
					$("div[name=delete]").hide();
				});
			});
			
			$("#deleteData").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=delete]").show();
				$("div[name=register]").hide();
				var data={
						"id":$("select[name=deleSelect]").val()
						};
				var obj={
						type:"POST",
						url:"${basePath}msg/delete",
						data:JSON.stringify(data),
						dataTpye:"json",
						contentType:"application/json"
						};
				$.ajax(obj).done(function(res){
					init();
					$("div[name=result]").show();
					$("div[name=register]").hide();
					$("div[name=delete]").hide();
				});
			});
			
			$("#updateData").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=delete]").show();
				$("div[name=register]").hide();
				var data={
						"id":$("select[name=deleSelect]").val()
						};
				var obj={
						type:"POST",
						url:"${basePath}msg/update",
						data:JSON.stringify(data),
						dataTpye:"json",
						contentType:"application/json"
						};
				$.ajax(obj).done(function(res){
					init();
					$("div[name=result]").show();
					$("div[name=register]").hide();
					$("div[name=delete]").hide();
				});
			});
			
		
			$("#add").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=register]").show();
				$("div[name=delete]").hide();
			});
			$("#delete").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=register]").hide();
				$("div[name=delete]").show();
				selectMsg();
			});
			
			$("#return").on("click",function(){
				$("div[name=result]").show();
				$("div[name=register]").hide();
				$("div[name=delete]").hide();
			});
			
			$("#return2").on("click",function(){
				$("div[name=result]").show();
				$("div[name=register]").hide();
				$("div[name=delete]").hide();
			});
		});
		
		Date.prototype.Format = function(formatStr)   
		{   
		    var str = formatStr;   
		    var Week = ['日','一','二','三','四','五','六'];  
		    str=str.replace(/yyyy|YYYY/,this.getFullYear());
		    str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));
		    str=str.replace(/MM/,this.getMonth()>9?this.getMonth().toString():'0' + this.getMonth());
		    str=str.replace(/M/g,this.getMonth());
		    str=str.replace(/w|W/g,Week[this.getDay()]);
		    str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());   
		    str=str.replace(/d|D/g,this.getDate());
		    str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());   
		    str=str.replace(/h|H/g,this.getHours());
		    str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());   
		    str=str.replace(/m/g,this.getMinutes());
		    str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());   
		    str=str.replace(/s|S/g,this.getSeconds());
		    return str;   
		}
		
		function selectMsg() {
			$.ajax({
				type:"post",
				url:"${basePath}msg/list",
				contentType:"application/json",
				cache : false,
				async : false,
				success : function(data) {
					var list=data.result;
					 $('#select').empty();
			         $('#select').append("<option value='"+1+"'>--请选择信息标题--</option>");  
			            for(var i in list){
			                $('#select').append("<option value='"+list[i].id+"'>"+list[i].title+"</option>");  
			            }
				}
			});
		}
	</script>
  </head>
  
  <body onload="init();">
		<div width="100%" align="center"><h3>系统信息列表</h3></div>
		<hr>
		<div align="right">
			<button class="btn btn-primary" type="submit" id="add">添加消息</button>
			<button class="btn btn-primary" type="submit" id="delete">管理消息</button>
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
						<td>消息内容:</td><td><textarea rows="10" cols="50" name="message"></textarea></td>
					</tr>
				</table>
				<div>
					<button class="btn btn-primary" type="submit" id="addData">添加</button>
					<button class="btn btn-primary" type="submit" id="return">返回</button>
				</div>
			</div>
			<div name="delete" style="display:none;" align="center">
				<h3>管理消息</h3>	
				<hr>
				<div style="width: 40%;text-align: center">
					消息标题:<select id = "select" name = "deleSelect"></select>
				</div>
				<hr>
				<div>
					<button class="btn btn-primary" type="submit" id="deleteData">删除</button>
					<button class="btn btn-primary" type="submit" id="return2">返回</button>
				</div>
			</div>
		</div>
		<hr>
  </body>
</html>
