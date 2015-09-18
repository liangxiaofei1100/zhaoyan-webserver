<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="ZhaoyanApp">
<head>
    <title>主页</title>

    <%@include file="common/head.jsp" %>
    <script src="resources/js/app.js"></script>
    <script src="resources/js/controllers.js"></script>
    <script src="resources/framework/angular/angular-ui-router.min.js"></script>

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
        <h1 ng-controller="TimeController">
            欢迎来到Web主页，当前时间：<span ng-bind="clock.now | date:'yyyy-MM-dd HH:mm:ss'"></span>
        </h1>
    </div>

    <div ng-controller="GreetingController">
        <p><span ng-bind="greeting.message"></span></p>
    </div>
</div>
</body>
</html>