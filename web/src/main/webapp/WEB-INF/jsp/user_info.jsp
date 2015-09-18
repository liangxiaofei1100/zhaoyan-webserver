<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="UserInfoModule">
<head>
    <title>用户信息</title>

    <%@include file="common/head.jsp" %>
    <script src="resources/js/UserInfo.js"></script>
</head>

<body>
<%@include file="common/navigation_bar.jsp" %>

<div class="panel panel-primary " style="padding-top: 70px;">
    <div class="panel-heading">
        <div class="panel-title">用户信息</div>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" role="form" ng-controller="UserInfoCtrl">
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            邮箱：
                        </label>
                        <div class="col-md-10">
                            <input class="form-control" type="email" placeholder="请输入您的邮箱" ng-model="userInfo.email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            密码：
                        </label>
                        <div class="col-md-10">
                            <input class="form-control" type="password" placeholder="只能是数字、字母、下划线"
                                   ng-model="userInfo.password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" ng-model="userInfo.autoLogin"> 自动登录
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <button class="btn btn-default" ng-click="getUserInfo()">
                                获取信息
                            </button>
                            <button class="btn btn-default" ng-click="resetUserInfo()">
                                重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>