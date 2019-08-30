<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/30
  Time: 10:31 下午
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
    <link href="../statics/bootstrap/checkout.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body class="bg-light">
<script type="application/javascript">
    $(document).ready(function(){
        $("td").each(function(){
            if($(this).text()<60){
                $(this).css("color","red")
            }
        })
    });
</script>
<div class="table-responsive" id="tablediv">
    <table class="table table-striped" id="tableid">
        <thead>
        <tr>
            <th>课程名</th>
            <th>成绩</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${score}" var="score">
            <tr>
                <td>${score.courseno}</td>
                <td>${score.score}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
