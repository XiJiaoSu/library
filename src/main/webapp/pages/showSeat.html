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
		$(function(){
			$("#showAllSeats").on("click",function(){
				var data={
						
						};
				var obj={
						type:"POST",
						url:"${basePath}showUser",
						data:JSON.stringify(data),
						dataTpye:"json",
						contentType:"application/json"
						};
				$.ajax(obj).done(function(res){
					$("#seatList").empty();
					createTable(res);
				});
			});
			function createTable(res){
				if(res.code == -1){
					
				}else{
					var list=res.result;
					for(var i=0;i<list.length;i++){
						var u=list[i];
						$("<tr>").append($("<th>").text(u.id))
						.append($("<th>").text(u.username))
						.append($("<th>").text(u.password))
						.append($("<th>").text(u.age))
						.append($("<th>").text(u.email))
						.append($("<th>").text(u.birth))
						.append($("<th>").text(u.phone))
						.append($("<th>").text(u.stuId))
						.appendTo($("#seatList"));
					}
				}
			}
		});
	</script>
  </head>
  
  <body>
		<div width="100%" align="center"><h3>座位信息列表</h3></div>
		<hr>
		<div align="right">
			<input type="text" id="txtSearch"/>
			<button class="btn btn-primary" type="submit" id="Search">查询</button>
		</div>
		<hr>
		<div style="width:100%; height: 100%;">
			<div name="usertitle" width="100%" align="center">
				<div>
					<table class="table table-striped" border="1">
						<thead>
							<tr>
								<th>座位编号</th>
								<th>所在教室</th>
								<th>预定状态</th>
								<th>年龄</th>
								<th>邮箱</th>
								<th>生日</th>
								<th>手机号</th>
								<th>学号</th>
							</tr>
						</thead>
						<tbody id="seatList"></tbody>
					</table>
				</div>
			</div>
		</div>
  </body>
</html>
