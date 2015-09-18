<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="zhaoyanApp">
<head>
    <title>主页</title>

    <%@include file="common/head.jsp" %>
    <script src="resources/js/app.js"></script>
    <script src="resources/js/controllers.js"></script>

    <style type="text/css">
        .body-div {
            padding-top: 70px;
            padding-left: 50px;
            padding-right: 50px;
            padding-bottom: 50px;
        }
    </style>
</head>

<body>
<%@include file="common/navigation_bar.jsp" %>

<div class="body-div">
    <div>
        <%
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date currentTime = new java.util.Date();
            String time = simpleDateFormat.format(currentTime);
        %>
        <h1>欢迎来到Web主页，当前时间：<%= time %>
        </h1>
    </div>

    <div ng-controller="GreetingController">
        <p>{{greeting.message}}</p>
    </div>
</div>
</body>
</html>