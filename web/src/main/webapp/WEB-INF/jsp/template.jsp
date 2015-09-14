<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
    <title>标题</title>

    <%
        String path = request.getContextPath();
        // 当前应用的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">

    <!-- 网站icon -->
    <link href="images/favicon.ico" rel="icon"/>
    <link href="images/favicon.ico" rel="shortcut icon"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body>

</body>
</html>