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
			<span>用户管理 >> 添加用户</span>
		</div>
		
		<div class="add">
			<form action="SaveUserServlet" method="get">
				<div class="">
					<label for="userCode">用户编码：</label>
					<input type="text" name="userCode" id="userCode" placeholder="请输入用户编码"/>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="userName">用户名称：</label>
					<input type="text" name="userName" id="userName" placeholder="请输入用户名称"/>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="userPassword">用户密码：</label>
					<input type="password" name="userPassword" id="userPassword" placeholder="请输入用户密码"/>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="gender">用户性别：</label>
					<select name="gender" id="gender">
						<option value ="男">男</option>
						<option value ="女">女</option>
					</select>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="birthday">用户生日：</label>
					<input type="date" name="birthday" id="birthday" placeholder="请输入用户生日"/>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="phone">用户电话：</label>
					<input type="text" name="phone" id="phone" placeholder="请输入用户电话"/>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="address">用户地址：</label>
					<input type="text" name="address" id="address" placeholder="请输入用户地址"/>
					<span>*</span>
				</div>
				
				<div class="addBtn">
					<input type="submit" value="保存" />
					<input type="reset" value="取消" />
				</div>
			</form>
		</div>
	</body>
</html>