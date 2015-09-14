<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">

<head>
    <%
        String path = request.getContextPath();
        // 当前应用的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
        request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>

            <form class="form" action="<account/login" method="post">
                <input name="username" type="text" placeholder="Username">
                <input name="password" type="password" placeholder="Password">
                <button type="submit" id="login-button">Login</button>
            </form>
        </div>

        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>

<script src="<js/jquery-2.1.1.min.js" type="text/javascript"></script>
<%--<script>--%>
    <%--$('#login-button').click(function (event) {--%>
        <%--event.preventDefault();--%>
        <%--$('form').fadeOut(500);--%>
        <%--$('.wrapper').addClass('form-success');--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>