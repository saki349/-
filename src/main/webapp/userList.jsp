<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <!-- 用户校验 -->
    <%@ page import="cn.edu.ccu.domain.User" %>
      
   <%@ page import="java.util.*" %>
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
			<span>
				用户管理
			</span>
		</div>
	
		
		<!-- 搜索 -->
		<div class="search">
			<!-- 表单 -->
			<form action="SelectUserByUsernameServlet" method="get">
				<span>用户名</span>
				<input type="text" name="username" placeholder="请输入用户名" />
				<input type="submit" value="查询" />
				<a href="AddUserServlet">添加用户</a>
			</form>
		</div>
		

		
		<!-- 表格：cellspacing内距 cellpadding内填充 -->
		<table class="table" cellspacing="0" cellpadding="0">
			<tr class="firstTr">
				<th>用户编码</th>
				<th>用户名</th>
				<th>性别</th>
				<th>生日</th>
				<th>电话</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
<%
	List<User> list = (List<User>) request.getAttribute("userList");
	//遍历List
	if(list != null && list.size() != 0){
		for(int i = 0; i < list.size(); i++) {
			User tmpUser = list.get(i);
%>
			<tr>
				<td><%=tmpUser.getUserCode() %></td>
				<td><%=tmpUser.getUserName() %></td>
				<td><%=tmpUser.getGender() %></td>
				<td><%=tmpUser.getBirthday() %></td>
				<td><%=tmpUser.getPhone() %></td>
				<td><%=tmpUser.getAddress() %></td>
				<!-- 操作 -->
				<td>
				<!-- ?get请求 -->
					<a href="SelectUserByIdServlet?id=<%=tmpUser.getId() %>" title="查询"><img src="img/read.png" ></a>
					<a href="UpdateUserServlet?id=<%=tmpUser.getId() %>" title="修改"><img src="img/xiugai.png" ></a>
					<a href="DeleteUserByIdServlet?id=<%=tmpUser.getId() %>" title="删除"><img src="img/schu.png" ></a>
				</td>
			</tr>
<%
		}
	}else{
%> 
		<tr><td>暂无数据</td></tr>
<%
	}
%> 
		</table>
	</body>
</html>