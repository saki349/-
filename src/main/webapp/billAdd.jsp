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
			<span>账单管理 >> 新增账单</span>
		</div>
		
		<div class="add">
			<form action="SaveBillServlet" method="get">
				<div class="">
					<label for="billCode">账单号：</label>
					<input type="text" name="billCode" id="billCode" placeholder="请输入账单号"/>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="productName">产品名称：</label>
					<input type="text" name="productName" id="productName" placeholder="请输入产品名称"/>
					<span>*</span>
				</div>
				
				<div class="">
					<label for="productDesc">产品说明：</label>
					<input type="text" name="productDesc" id="productDesc" placeholder="请输入产品说明"/>
					<span>*</span>
				</div>

				<div class="">
					<label for="productUnit">产品单元：</label>
					<input type="text" name="productUnit" id="productUnit" placeholder="请输入产品单元"/>
					<span>*</span>
				</div>

				<div class="">
					<label for="productCount">产品数额：</label>
					<input type="text" name="productCount" id="productCount" placeholder="请输入产品数额"/>
					<span>*</span>
				</div>

				<div class="">
					<label for="totalPrice">总价格：</label>
					<input type="text" name="totalPrice" id="totalPrice" placeholder="请输入总价格"/>
					<span>*</span>
				</div>

				<div class="">
					<label for="isPayment">是否付款：</label>
					<select name="isPayment" id="isPayment">
						<option value ="1">售出</option>
						<option value ="2">未售出</option>
					</select>
					<span>*</span>
				</div>

				<div class="">
					<label for="creationDate">创建日期：</label>
					<input type="date" name="creationDate" id="creationDate" placeholder="请输入创建日期"/>
					<span>*</span>
				</div>

				<div class="">
					<label for="modifyDate">修改日期：</label>
					<input type="date" name="modifyDate" id="modifyDate" placeholder="请输入修改日期"/>
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