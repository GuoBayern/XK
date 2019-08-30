<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/30
  Time: 9:35 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="studentQuitCourseSave" class="needs-validation" novalidate>
                <div class="mb-3">
                    <span>课 程 号：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" name="no" id="no">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>课 程 名：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" name="name" id="name">
                    </label>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary btn-lg btn-block">退出</button>
            </form>
        </div>
    </div>
</div>
</body>
<script type="application/javascript">
    function close() {
        var msg = '<%=request.getAttribute("message")%>';
        if (msg === "退出成功"){
            alert(msg);
        }
        if (msg === "退出失败"){
            alert(msg);
        }
        if (msg === "课程号不存在"){
            alert(msg);
        }
        if (msg === "课程名输入错误"){
            alert(msg);
        }
        if (msg === "尚未添加该课程"){
            alert(msg);
        }
    }
</script>
</html>
