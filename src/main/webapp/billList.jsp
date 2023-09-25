<%@ page import="cn.edu.ccu.domain.Bill" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="cn.edu.ccu.domain.Bill" %>
<%@ page import="java.util.List" %>
<%--用户校验 TODO--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>BillList</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
</head>
<body style="background: #fff;">
<div class="location">
    <strong>你现在所在的位置是：</strong>
    <span>
				账单管理
	</span>
</div>

<!-- 搜索 -->
<div class="search">
    <!-- 表单 -->
    <form action="SelectBillByProductnameServlet" method="get">
        <span>用户名</span>
        <input type="text" name="productname" placeholder="请输入产品名称"/>
        <input type="submit" value="查询"/>
        <a href="AddBillServlet">新增账单</a>
    </form>
</div>

<!-- 表格：cellspacing内距 cellpadding内填充 -->
<table class="table" cellspacing="0" cellpadding="0">
    <tr class="firstTr">
        <th>账单号</th>
        <th>产品名称</th>
        <th>产品说明</th>
        <th>产品单元</th>
        <th>产品数额</th>
        <th>总价格</th>
        <th>创建日期</th>
        <th>修改日期</th>
    </tr>

    <% List<Bill> list = (List<Bill>) request.getAttribute("billList");

        //遍历List
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                Bill bill = list.get(i); %>
    <tr>
        <td>
            <%=bill.getBillCode() %>
        </td>
        <td>
            <%=bill.getProductName() %>
        </td>
        <td>
            <%=bill.getProductDesc() %>
        </td>
        <td>
            <%=bill.getProductUnit() %>
        </td>
        <td>
            <%=bill.getProductCount() %>
        </td>
        <td>
            <%=bill.getTotalPrice() %>
        </td>
        <td>
            <%=bill.getCreationDate() %>
        </td>
        <td>
            <%=bill.getModifyDate() %>
        </td>

        <!-- 操作 -->
        <td>
            <!-- ?get请求 -->
            <a href="SelectBillByIdServlet?id=<%=bill.getId() %>" title="查询"><img
                    src="img/read.png"></a>
            <a href="UpdateBillServlet?id=<%=bill.getId() %>" title="修改"><img
                    src="img/xiugai.png"></a>
            <a href="DeleteBillByIdServlet?id=<%=bill.getId() %>" title="删除"><img
                    src="img/schu.png"></a>
        </td>
    </tr>
    <% }
    } else { %>
    <tr>
        <td>暂无数据</td>
    </tr>
    <% } %>
</table>


</body>
</html>

