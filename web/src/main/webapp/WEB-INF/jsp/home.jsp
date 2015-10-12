<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="ZhaoyanApp">
<head>
    <title>朝颜</title>

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
    <link href="resources/css/common.css" rel="stylesheet">

    <script src="resources/framework/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="resources/framework/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/framework/angular/angular.min.js"></script>
    <script src="resources/framework/angular/angular-ui-router.min.js"></script>

    <script src="resources/js/app.js"></script>
    <script src="resources/js/controllers.js"></script>
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">朝颜</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li ui-sref-active="active"><a ui-sref="home" >主页</a></li>
                <li ui-sref-active="active"><a ui-sref="product">商品</a></li>
                <li ui-sref-active="active"><a ui-sref="userinfo">用户信息</a></li>
                <li ui-sref-active="active"><a ui-sref="product_add">新增商品</a></li>
                <li ui-sref-active="active"><a ui-sref="test">测试</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div style="padding-top: 70px; padding-bottom: 50px;">

    <!-- views will be injected here -->
    <div ui-view></div>

</div>
</body>
</html>