<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/30
  Time: 1:42 下午
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
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="studentEnterCourseSave" class="needs-validation" novalidate>
                <div class="mb-3">
                    <span>课 程 号：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" name="no" id="no">
                    </label>
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true" style="cursor: pointer" id="nonext"></span>
                </div>
                <br/>
                <div class="mb-3">
                    <span>课 程 名：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" name="name" id="name">
                    </label>
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true" style="cursor: pointer" id="namenext"></span>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary btn-lg btn-block">加入</button>
            </form>
        </div>
    </div>
</div>
<div class="table-responsive" id="tablediv">
    <table class="table table-striped" id="tableid">
        <thead>
        <tr>
            <th>课程号</th>
            <th>教师姓名</th>
            <th>课程名</th>
            <th>学分</th>
            <th>开课学院</th>
            <th>上课时间</th>
            <th>上课地点</th>
        </tr>
        </thead>
        <tbody id="courseinfo">
        </tbody>
    </table>
</div>
</body>
<script type="application/javascript">
    function close() {
        var msg = '<%=request.getAttribute("message")%>';
        if (msg === "加入成功"){
            alert(msg);
        }
        if (msg === "加入失败"){
            alert(msg);
        }
        if (msg === "课程号不存在"){
            alert(msg);
        }
        if (msg === "课程名输入错误"){
            alert(msg);
        }
        if (msg === "已添加该课程"){
            alert(msg);
        }
    }
    function sub(o){
        var i = o.rowIndex;
        var no = document.getElementById("tableid").rows[i].cells[0].innerHTML;
        var name = document.getElementById("tableid").rows[i].cells[2].innerHTML;
        document.getElementById("no").value = no;
        document.getElementById("name").value = name;
    }
    $("#nonext").click(function () {
       $.ajax({
           data: {"courseno": $("#no").val()},
           type:"POST",
           url: "studentEnterCourseSaveAJAX1",
           success: function (msg) {
               if (msg === '课程号不存在'){
                   alert(msg);
               }
               if (msg === '已添加该课程'){
                   alert(msg);
               }
               else {
                   $("#courseinfo").append(msg);
               }
           },
           error: function (msg) {
               alert(msg);
           }
       });
    });
    $("#namenext").click(function () {
        $.ajax({
            data: {"coursename": $("#name").val()},
            type:"POST",
            url: "studentEnterCourseSaveAJAX2",
            success: function (msg) {
                if (msg === '课程号不存在'){
                    alert(msg);
                }
                if (msg === '已添加该课程'){
                    alert(msg);
                }
                else {
                    $("#courseinfo").append(msg);
                }
            },
            error: function (msg) {
                alert(msg);
            }
        });
    });
</script>
</html>
