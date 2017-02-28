<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书馆位置管理系统</title>
</head>

 <frameset rows="59,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="./files/top.jsp" name="topFrame" scrolling="No"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="213,*" frameborder="no" border="0" framespacing="0">
		<frame src="./files/left.jsp" name="leftFrame" scrolling="No"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="./files/mainfra.jsp" name="mainFrame" id="mainFrame"
			title="mainFrame"/>
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes> 

</html>
