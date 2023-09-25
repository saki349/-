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
			<span>账单管理 >> 信息查看</span>
		</div>
		
<%
	Bill tmpBill = (Bill) request.getAttribute("bill");
%>
		
		<div class="view">
			<p><strong>账单号：</strong><span><%=tmpBill.getBillCode() %></span></p>
			<p><strong>产品名称：</strong><span><%=tmpBill.getProductName() %></span></p>
			<p><strong>产品说明：</strong><span><%=tmpBill.getProductDesc() %></span></p>
			<p><strong>产品单元：</strong><span><%=tmpBill.getProductUnit() %></span></p>
			<p><strong>产品数额：</strong><span><%=tmpBill.getProductCount() %></span></p>
			<p><strong>总价格：</strong><span><%=tmpBill.getTotalPrice() %></span></p>
			<p><strong>创建日期：</strong><span><%=tmpBill.getCreationDate() %></span></p>
			<p><strong>修改日期：</strong><span><%=tmpBill.getModifyDate() %></span></p>
			<a href="SelectBillListServlet">返回</a>
		</div>
	</body>
</html>