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
        <form name="uf" accept-charset="utf-8" id="uf" method="get" action="adminArrangeCourseFirst" class="needs-validation" novalidate>
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3"></h4>
                    <div class="mb-3">
                        <span>课 程 号：</span>
                        <label>
                            <input type="text" maxlength="20" style="margin-top: 10px" name="courseno" id="courseno">
                        </label>
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true" style="cursor: pointer" id="next"></span>
                    </div>
                    <br/>
                <div class="mb-3" id="optionid" style="display: none">
                    <label>
                        <select id="weekday" name="weekday">
                            <option value="===请选择===">===请选择===</option>
                            <option value="Mon" id="weekday1">星期一</option>
                            <option value="Tue" id="weekday2">星期二</option>
                            <option value="Wed" id="weekday3">星期三</option>
                            <option value="Thu" id="weekday4">星期四</option>
                            <option value="Fri" id="weekday5">星期五</option>
                        </select>
                    </label>
                    <label>
                        <select id="worktime" name="worktime" disabled>
                            <option value="===请选择===">===请选择===</option>
                            <option value="1" id="worktime1">1(8:00-9:40)</option>
                            <option value="2" id="worktime2">2(10:00-11:40)</option>
                            <option value="3" id="worktime3">3(13:00-14:40)</option>
                            <option value="4" id="worktime4">4(15:00-16:40)</option>
                        </select>
                    </label>
                    <label>
                        <select id="courseaddress" name="courseaddress" disabled>
                            <option value="===请选择===">===请选择===</option>
                            <c:forEach items="${classroom}" var="classroom">
                                <option value="${classroom.courseaddress}">${classroom.courseaddress}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <button type="submit" class="btn btn-primary btn-lg btn-block" id="savebut" disabled>保存</button>
                </div>
            </div>
        </form>
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
    $("#next").click(function () {
        $.ajax({
            data:{"courseno":$("#courseno").val()},
            type:"POST",
            url:"arrangeCourseAJAX1",
            success:function(msg){
                if (msg === "Arranged"){
                    alert("课程已安排");
                }
                else if (msg === "Not exist"){
                    alert("课程号不存在");
                }
                else {
                    var length = msg.length;
                    for (var i = 0; i < length; i = i + 2){
                        if (msg[i] === '1'){
                            $("#weekday1").attr('disabled', '');
                        }
                        if (msg[i] === '2'){
                            $("#weekday2").attr('disabled', '');
                        }
                        if (msg[i] === '3'){
                            $("#weekday3").attr('disabled', '');
                        }
                        if (msg[i] === '4'){
                            $("#weekday4").attr('disabled', '');
                        }
                        if (msg[i] === '5'){
                            $("#weekday5").attr('disabled', '');
                        }
                    }
                    $("#optionid").css('display', 'block');
                }
            },
            error:function(){
                alert("排课失败！");
            }
        });
    });
    $("#weekday").change(function () {
        var weekday = $("#weekday").val();
        if (weekday !== '===请选择==='){
            $('#worktime').removeAttr('disabled', '');
            $.ajax({
                data:{"weekday": weekday},
                type: "POST",
                url: "arrangeCourseAJAX2",
                success:function (msg) {
                    var length = msg.length;
                    for (var i = 0; i < length; i = i + 2){
                        if (msg[i] === '1'){
                            $("#worktime1").attr('disabled', '');
                        }
                        if (msg[i] === '2'){
                            $("#worktime2").attr('disabled', '');
                        }
                        if (msg[i] === '3'){
                            $("#worktime3").attr('disabled', '');
                        }
                        if (msg[i] === '4'){
                            $("#worktime4").attr('disabled', '');
                        }
                    }
                },
                error:function(){
                    alert("排课失败！");
                }
            });
        }
        else {
            $('#worktime').attr('disabled', '');
            $('#savebut').attr('disabled', '');
        }
        if (weekday === 'Fri'){
            $('#worktime4').attr('disabled', '');
        }
        else {
            $('#worktime4').removeAttr('disabled', '');
        }
    });
    $("#worktime").change(function () {
        var worktime = $("#worktime").val();
        if (worktime !== '===请选择==='){
            $("#courseaddress").removeAttr('disabled','');
        }
        else {
            $("#courseaddress").attr('disabled','');
            $('#savebut').attr('disabled', '');
        }
    });
</script>
</html>
