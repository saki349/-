<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="cn.edu.ccu.domain.User" %>   

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
<title>超市账单管理系统</title>
<link rel="stylesheet" type="text/css" href="css/public.css"/>
</head>

<body>
		<div class="publicHeader">
			<!-- h1标签 -->
			<h1>超市账单管理系统</h1>
			<div class="publicHeaderR">
				<p><span>下午好！&ensp;</span><span style="color: #fff21b;"><%= user.getUserName()%>></span>，欢迎您！&ensp;</p>
				<!-- a标签 -->
				<!-- href是点击跳转 -->
				<a href="LogoutServlet">退出</a>
			</div>
		</div>
		<div class="publicMain">
			<div class="left">
				<h2 class="leftH2"><span class="span1"></span>功能列表<span class="span2"></span></h2>
				<div>
					<ul class="list">
						<li><a href="SelectBillListServlet" target="right">账单管理</a></li>
						<li><a href="">供应商管理</a></li>
						<li><a href="SelectUserListServlet" target="right" >用户管理</a></li>
						<li><a href="">角色管理</a></li>
						<li><a href="">地址管理</a></li>
					</ul>
				</div>
			</div>
			<div class="right">
				<iframe class="frameBox" name = "right" src="mainRight.jsp"></iframe>
			</div>
		</div>
		<div class="footer">
			copyright @<a href="http://ccu.edu.cn">http://ccu.edu.cn</a>
		</div>
	</body>
</html>