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
	
	<script type="text/javascript" src="./js/jquery.qrcode.min.js"></script>
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
					$("<tr>").append($("<th><a data-toggle='modal' data-target='#myModal' onclick='subgo(this)'>"+u.id+"</a>"))
					.append($("<th>").text(u.name))
					.append($("<th>").text(u.state))
					.append($("<th>").text(result))
					.append($("<th>").text(u.level))
					.append($("<th>").text(u.description))
					.appendTo($("#resultList"));
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
		
		function subgo(str){
			var r = toUtf8(str.text);
			$("#code").empty();
			$("#myModalLabel").text("座位二维码编号为："+str.text);
			$("#code").qrcode({
				render: "canvas",
				width: 200,
				height:200,
				text: r
			});
		}
		function toUtf8(str) {   
		    var out, i, len, c;   
		    out = "";   
		    len = str.length; 
		    for(i = 0; i < len; i++) {   
		    	c = str.charCodeAt(i);   
		    	if ((c >= 0x0001) && (c <= 0x007F)) {   
		        	out += str.charAt(i);   
		    	} else if (c > 0x07FF) {   
		        	out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));   
		        	out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));   
		        	out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
		    	} else {   
		        	out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));   
		        	out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
		    	}   
		    }   
		    return out;   
		}  
		
	</script>
  </head>
  
  <body onload="selectLibrary();init();">
		<div width="100%" align="center"><h3>座位信息列表</h3></div>
		<hr>
		<div align="right">
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
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div id="code" align="center"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
</div>
  </body>
</html>
