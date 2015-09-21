<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    // 当前应用的路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">

<!-- 网站icon -->
<link href="resources/images/favicon.ico" rel="icon"/>
<link href="resources/images/favicon.ico" rel="shortcut icon"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/framework/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script src="resources/framework/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="resources/framework/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/framework/angular/angular.min.js"></script>
