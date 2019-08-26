<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/26
  Time: 10:32 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
            <img src="../statics/images/logo.png" style="width: 8%; height: 8%" alt="上海大学Logo">
            <span style="color: gold; padding-left: 3%; font-size: large">上海大学选课系统</span>
            <span style="color: gold; padding-left: 10%">姓名：${teacherInfo.get(0).cname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院系：${departmentname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份：教师</span>
            <a href="index" style="padding-left: 25%">退出</a>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li id="frame1"><a onclick="changeiFrame1()" style="cursor: pointer">开课</a></li>
                <li id="frame2"><a onclick="changeiFrame2()" style="cursor: pointer">关课</a></li>
                <li id="frame3"><a onclick="changeiFrame3()" style="cursor: pointer">查看课表</a></li>
                <li id="frame4"><a onclick="changeiFrame4()" style="cursor: pointer">录入成绩</a></li>
                <li id="frame5"><a onclick="changeiFrame5()" style="cursor: pointer">修改信息</a></li>
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
        document.getElementById("iFrameId").src = "teacherOpenCourse";
    }
    function changeiFrame2() {
        document.getElementById("frame2").classList.add("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("iFrameId").src = "";
    }
    function changeiFrame3() {
        document.getElementById("frame3").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("iFrameId").src = "";
    }
    function changeiFrame4() {
        document.getElementById("frame4").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("frame5").classList.remove("active");
        document.getElementById("iFrameId").src = "";
    }
    function changeiFrame5() {
        document.getElementById("frame5").classList.add("active");
        document.getElementById("frame2").classList.remove("active");
        document.getElementById("frame3").classList.remove("active");
        document.getElementById("frame4").classList.remove("active");
        document.getElementById("frame1").classList.remove("active");
        document.getElementById("iFrameId").src = "teacherEditInfo";
    }
</script>
</html>
