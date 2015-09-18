<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
    <title>商品列表</title>

    <%@include file="common/head.jsp" %>
    <style type="text/css">
        .body-div {
            padding-top: 70px;
            padding-left: 50px;
            padding-right: 50px;
            padding-bottom: 50px;
        }

        .table th, .table td {
            text-align: center;
        }
    </style>
</head>

<body>
<%@include file="common/navigation_bar.jsp" %>
<script type="text/javascript">
    jQuery(function ($) {
        var urlStr = "product/list";
        //alert("Before Call:"+urlStr);
        $.ajax({
            method: "GET",
            url: urlStr,
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("Success:"+JSON.stringify(data));
                // 添加数据到Table中。
                var productList = data.productList;
                $.each(productList, function (index, product) {
                    // "id":1,"name":"苹果","description":"一种水果","number":100
                    var trHtml = "<tr>" +
                            "<td>" + product.id + "</td>" +
                            "<td>" + product.name + "</td>" +
                            "<td>" + product.description + "</td>" +
                            "<td>" + product.number + "</td>" +
                            "</tr>";
                    $("#productTableBody").append(trHtml);
                });
            }
        }); // end ajax
    });
</script>

<div class="body-div">
    <div>
        <table id="productTable" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>名称</th>
                <th>描述</th>
                <th>数量</th>
            </tr>
            </thead>
            <tbody id="productTableBody">
            <!-- Table数据通过JSON数据加载 -->
            </tbody>
        </table>
    </div>
</div>

</body>
</html>