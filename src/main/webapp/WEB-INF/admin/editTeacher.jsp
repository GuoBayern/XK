<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/25
  Time: 8:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上海大学</title>
    <!-- Bootstrap core CSS -->
    <link href="../statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../statics/bootstrap/dashboard.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>电话</th>
            <th>院系编号</th>
            <th>学历</th>
            <th>编辑</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teacher}" var="teacher">
            <tr>
                <td>${teacher.cno}</td>
                <td>${teacher.cname}</td>
                <td>${teacher.sex}</td>
                <td>${teacher.tel}</td>
                <td>${teacher.departmentno}</td>
                <td>${teacher.degree}</td>
                <td>
                    <label>
                        <input class="glyphicon glyphicon-edit" aria-hidden="true" style="cursor: pointer">
                    </label>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
