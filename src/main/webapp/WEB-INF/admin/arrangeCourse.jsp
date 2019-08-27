<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/27
  Time: 11:49 下午
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
<body class="bg-light" onload="close()">
<div class="container">
    <div class="row">
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3"></h4>
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="adminArrangeCourseFirst" class="needs-validation" novalidate>
                <div class="mb-3">
                    <span>课 程 号：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" name="courseno" id="courseno">
                    </label>
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true" style="cursor: pointer" id="next"></span>
                </div>
                <br/>
            </form>
            <div class="mb-3">
                <label>
                    <select id="weekday" name="weekday">
                        <option value="===请选择===">===请选择===</option>
                        <option value="Monday">星期一</option>
                        <option value="Tuesday">星期二</option>
                        <option value="Wednesday">星期三</option>
                        <option value="Thursday">星期四</option>
                        <option value="Friday">星期五</option>
                    </select>
                </label>
                <label>
                    <select id="worktime" name="worktime" disabled>
                        <option value="===请选择===">===请选择===</option>
                        <option value="First">1(8:00-9:40)</option>
                        <option value="Second">2(10:00-11:40)</option>
                        <option value="Third">3(13:00-14:40)</option>
                        <option value="Fourth">4(15:00-16:40)</option>
                    </select>
                </label>
                <label>
                    <select id="courseaddress" name="worktime" disabled>
                        <option value="===请选择===">===请选择===</option>
                        <c:forEach items="${classroom}" var="classroom">
                            <option value="${classroom.courseaddress}">${classroom.courseaddress}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
        </div>
    </div>
</div>
</body>
<script type="application/javascript">
    function close() {
        var msg = '<%=request.getAttribute("message")%>';
        if (msg === "课程号不存在"){
            alert(msg);
        }
        if (msg === "课程已安排"){
            alert(msg);
        }
        if (msg === "第二步"){
            alert(msg);
        }
    }
    function arfirst() {
        var form = document.getElementById("uf");
        form.submit();
    }
    $("#next").click(function () {
        $.ajax({
            data:{"courseno":$("#courseno").val()},
            type:"POST",
            url:"arrangeCourseAJAX1",
            success:function(msg){
                if (msg === "Arranged"){
                    alert("课程已安排");
                }
                if (msg === "Not exist"){
                    alert("课程号不存在");
                }
                if (msg === "Second"){

                }
            },
            error:function(){
                alert("失败！");
            }
        });
    });
    $("#weekday").change(function () {
        var weekday = $("#weekday").val();
    });
</script>
</html>
