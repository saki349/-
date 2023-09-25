<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.edu.ccu.domain.User" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css"/>
</head>
<!-- 由括起来的部分是Java代码 -->
<%
	User user = (User) session.getAttribute("user");
	
	if(user == null){
		response.sendRedirect("login.jsp");
	}
%>
	<body style="background: #fff;">
		<img class="wClock" src="img/clock.jpg">
		<div class="wFont">
			<h2><%= user.getUserName()%>></h2>
			<p>欢迎来到超市账单管理系统！</p>
		</div>
	</body>
</html>