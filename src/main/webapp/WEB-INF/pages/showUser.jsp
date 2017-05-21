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

    <title>用户信息列表</title>
    <script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<script type="text/javascript">	
		function init(){
			var data={
					
			};
			var obj={
					type:"post",
					url:"${basePath}/user/showUser",
					data:JSON.stringify(data),
					dataTpye:"json",
					contentType:"application/json"
					};
			$.ajax(obj).done(function(res){
				$("#resultList").empty();
				var list = res.result;
				for(var i=0;i<list.length;i++){
					var u = list;
					$("<tr>").append($("<th>").text(u[i].id))
					.append($("<th>").text(u[i].username))
					.append($("<th>").text(u[i].age))
					.append($("<th>").text(u[i].email))
					.append($("<th>").text(new Date(u[i].birth).Format("yyyy-MM-dd")))
					//.append($("<th>").text(u[i].birth))
					.append($("<th>").text(u[i].phone))
					.append($("<th>").text(u[i].stuId))
					.appendTo($("#resultList"));
				}
			});
		}
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
	</script>
  </head>
  
  <body onload="init();">
		<div width="100%" align="center"><h3>用户信息列表</h3></div>
		<hr>
		<div style="width:100%; height: 100%;">
			<div name="usertitle" width="100%" align="center">
				<div>
					<table class="table table-striped" border="1">
						<thead>
							<tr>
								<th>用户编号</th>
								<th>用户姓名</th>
								<th>年龄</th>
								<th>邮箱</th>
								<th>生日</th>
								<th>手机号</th>
								<th>学号</th>
							</tr>
						</thead>
						<tbody id="resultList"></tbody>
					</table>
				</div>
			</div>
		</div>
  </body>
</html>
