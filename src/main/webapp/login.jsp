<%--
  Created by IntelliJ IDEA.
  User: Saki
  Date: 2022/7/13
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta  charset="utf-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
</head>
<body class="login_bg">
<div class="loginBox">
    <div class="loginHeader">
        <h1>超市账单管理系统</h1>
    </div>
    <div class="loginCont">
        <!-- http请求方法： -->
        <!-- 1. get方法 -->
        <!-- 2. post方法-->
        <!-- 3. put方法-->
        <!-- 4. delete方法-->
        <!-- 5. option方法-->
        <!-- input标签添加“name”属性-->
        <form class="loginForm" action="LoginServlet" method="post">
            <div class="inputBox">
                <label>用户名：</label>
                <input placeholder="请输入用户名" type="text" name="username" id="" />
            </div>
            <div class="inputBox">
                <label>密&ensp;&ensp;码:</label>
                <input placeholder="请输入密码" type="password" name="password" id="" />
            </div>
            <div class="subBtn">
                <input type="submit" value="登录" />
                <input type="reset" value="重置" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
