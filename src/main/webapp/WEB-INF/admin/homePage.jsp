<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/25
  Time: 2:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>上海大学</title>
    <!-- Bootstrap core CSS -->
    <link href="../statics/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../statics/bootstrap/dashboard.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div style="background: url('../statics/images/mainheaderbg_rig.jpg') no-repeat; background-size: cover">
        <div>
            <img src="../statics/images/logo.png" style="width: 7%; height: 7%" alt="上海大学Logo">
            <span style="color: gold; padding-left: 3%; font-size: large">上海大学选课系统</span>
            <span style="color: gold; padding-left: 20%">姓名：管理员     院系：上海大学信息化办公室</span>
            <a href="#" style="padding-left: 25%">退出</a>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li id="stu">学生</li>
                <li id="frame1"><a onclick="changeiFrame1()" style="cursor: pointer">增加学生</a></li>
                <li id="frame2"><a onclick="changeiFrame2()" style="cursor: pointer">删除学生</a></li>
                <li id="frame3"><a onclick="changeiFrame3()" style="cursor: pointer">管理学生信息</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li id="tea">教师</li>
                <li id="frame4"><a onclick="changeiFrame4()" style="cursor: pointer">增加教师</a></li>
                <li id="frame5"><a onclick="changeiFrame5()" style="cursor: pointer">删除教师</a></li>
                <li id="frame6"><a onclick="changeiFrame6()" style="cursor: pointer">管理教师信息</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li id="course">课程</li>
                <li id="frame7"><a onclick="changeiFrame7()" style="cursor: pointer">管理上课时间</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <iframe id="iFrameId" src="" style="border: 0; padding: 0; margin: 0; height: 600px; width: 100%"></iframe>
        </div>
    </div>
</div>
</body>
<script type="application/javascript">
    function changeiFrame1() {
        document.getElementById("frame1").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("frame6").classList.remove("active");
        document.getElementById("frame7").classList.remove("active");
        document.getElementById("iFrameId").src = "adminInsertStudent";
    }
    function changeiFrame2() {
        document.getElementById("frame2").classList.add("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("frame6").classList.remove("active");
        document.getElementById("frame7").classList.remove("active");
    }
    function changeiFrame3() {
        document.getElementById("frame3").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("frame6").classList.remove("active");
        document.getElementById("frame7").classList.remove("active");
    }
    function changeiFrame4() {
        document.getElementById("frame4").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("frame6").classList.remove("active");
        document.getElementById("frame7").classList.remove("active");
        document.getElementById("iFrameId").src = "adminInsertTeacher";
    }
    function changeiFrame5() {
        document.getElementById("frame5").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame6").classList.remove("active");
        document.getElementById("frame7").classList.remove("active");
    }
    function changeiFrame6() {
        document.getElementById("frame6").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame7").classList.remove("active");
    }
    function changeiFrame7() {
        document.getElementById("frame7").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("frame6").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
    }
</script>
</html>