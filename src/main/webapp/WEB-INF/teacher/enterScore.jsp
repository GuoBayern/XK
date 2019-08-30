<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/30
  Time: 11:20 下午
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
<div class="table-responsive" id="tablediv">
    <table class="table table-striped" id="tableid">
        <thead>
        <tr>
            <th>课程名</th>
            <th>学生姓名</th>
            <th>成绩</th>
            <th>保存</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${score}" var="score">
            <tr onmouseover="sub(this)">
                <td>${score.tel}</td>
                <td>${score.sname}</td>
                <td style="display: none">${score.spass}</td>
                <td style="display: none">${score.sno}</td>
                <td>
                    <c:if test="${score.departmentno != null}">
                        <label for="scoreinput"></label><input id="scoreinput" class="score" value="${score.departmentno}">
                    </c:if>
                    <c:if test="${score.departmentno == null}">
                        <label for="scoreinput"></label><input id="scoreinput" class="score">
                    </c:if>
                </td>
                <td>
                    <span class="glyphicon glyphicon-saved" aria-hidden="true" style="cursor: pointer" onclick="change(this)"></span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script type="application/javascript">
    var i;
    function sub(o) {
        i = o.rowIndex;
    }
    function change(o) {
        var courseno = document.getElementById("tableid").rows[i].cells[2].innerHTML;
        var sno = document.getElementById("tableid").rows[i].cells[3].innerHTML;
        var score = $(o).closest("tr").find("input[class='score']").val();
        var list = [{courseno: courseno, sno: sno, score: score}];
        $.ajax({
            data: {list: JSON.stringify(list)},
            type: "POST",
            url: "teacherEnterScoreSave",
            success: function (msg) {
                alert(msg);
                $(o).closest("tr").find("input[class='score']").attr('readonly', '');
            },
            error: function(msg){
                alert(msg);
            }
        });
    }
</script>
</html>
