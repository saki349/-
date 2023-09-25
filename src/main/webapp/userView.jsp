<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="cn.edu.ccu.domain.*" %>  

<!-- 由括起来的部分是Java代码 -->
<%
	User user = (User) session.getAttribute("user");
	
	if(user == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css"/>
</head>
	<body style="background: #fff;">
		<div class="location">
			<strong>你现在所在的位置是：</strong>
			<span>用户管理 >> 信息查看</span>
		</div>
		
<%
	User tmpUser = (User) request.getAttribute("user");
%>
		
		<div class="view">
			<p><strong>用户编号：</strong><span><%=tmpUser.getUserCode() %></span></p>
			<p><strong>用户名称：</strong><span><%=tmpUser.getUserName() %></span></p>
			<p><strong>用户性别：</strong><span><%=tmpUser.getGender() %></span></p>
			<p><strong>出生日期：</strong><span><%=tmpUser.getBirthday() %></span></p>
			<p><strong>用户电话：</strong><span><%=tmpUser.getPhone() %></span></p>
			<p><strong>用户地址：</strong><span><%=tmpUser.getAddress() %></span></p>
			<a href="SelectUserListServlet">返回</a>
		</div>
	</body>
</html>