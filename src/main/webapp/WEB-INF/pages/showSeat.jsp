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
			var data={
					"id":"123123123"
			};
			var obj={
					type:"post",
					url:"${basePath}",
					data:JSON.stringify(data),
					dataTpye:"json",
					contentType:"application/json"
					};
			$.ajax(obj).done(function(res){
				$("#resultList").empty();
				//for(var i=0;i<res.length;i++){
					var u = res;
					$("<tr>").append($("<th>").text(u.id))
					.append($("<th>").text(u.name))
					.append($("<th>").text(u.state))
					.append($("<th>").text(u.lId))
					.append($("<th>").text(u.level))
					.appendTo($("#resultList"));
				//}
			});
		}
		
		function selectLibrary() {
			$.ajax({
				type:"post",
				url:"${basePath}",
				cache : false,
				async : false,
				success : function(data) {
					var list=data.result;
					 $('#select').empty();
			         $('#select').append("<option >--请选择图书馆信息--</option>");  
			            for(var i in list){
			                $('#select').append("<option value='"+list[i].cId+"'>"+list[i].name+"</option>");  
			            }
			            var selType = document.getElementById("select").options;
			            for (var i = 0; i < selType.length; i++) {
			                List[i] = selType[i].value + ":" + selType[i].text;
			            }
				}
			});
		}
		
		function Search() {
        	var txtSearch = document.getElementById("txtSearch");
            var selectContent = document.getElementById("select").options;
        	var Html = "";
            if (!(txtSearch.value.length < 1)) {
            	selectContent.length = 0;
                for (var i = 0; i < List.length; i++) {
                    if (List[i].indexOf(txtSearch.value) > -1) {
                    	selectContent.add(new Option(List[i].split(":")[1], List[i].split(":")[0]));
                    }
                }
            }else{
            	selectLibrary();
            }
        };
        
        $(function(){
			$("#add").on("click",function(){
				$("div[name=result]").hide();
				$("div[name=register]").show();
				var data={
						"Sel_XNXQ":$("select[name=Sel_XNXQ]").val(),
						"Sel_JS":$("select[name=Sel_JS]").val(),
						"txt_yzm":$("input[name=txt_yzm]").val()
						};
				var obj={
						type:"POST",
						url:"${basePath}",
						data:JSON.stringify(data),
						dataTpye:"json",
						contentType:"application/json"
						};
				$.ajax(obj).done(function(res){
					createTableImg(res);
				});
			});
			function createTableImg(res){
				if(res.code == -1){
					
				}else{
					
				}
			}
		});
		
	</script>
  </head>
  
  <body onload="selectLibrary();init();">
		<div width="100%" align="center"><h3>座位信息列表</h3></div>
		<hr>
		<div align="right">
			图书馆名称
			<input type="text" id="txtSearch" onchange="Search()"/>
			<select name="Sel_Library" id="select""></select>
			<button class="btn btn-primary" type="submit" id="Search">查询座位</button>
			<button class="btn btn-primary" type="submit" id="add">添加座位</button>
			<button class="btn btn-primary" type="submit" id="">修改座位</button>
			<button class="btn btn-primary" type="submit" id="">删除座位</button>
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
						<td>座位名称:</td><td><input type="text" id="" /></td>
					</tr>
					<tr>
						<td>当前座位状态:</td><td><input type="text" id="" /></td>
					</tr>
					<tr>
						<td>图书馆名称:</td><td><input type="text" id="" /></td>
					</tr>
					<tr>
						<td>所在楼层:</td><td><input type="text" id="" /></td>
					</tr>
				</table>
				<div><button class="btn btn-primary" type="submit" id="">添加</button>
					<button class="btn btn-primary" type="submit" id="">返回</button>
				</div>
				</div>
		</div>
		<hr>
  </body>
</html>