<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/26
  Time: 11:28 下午
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
</head>
<body class="bg-light" onload="close()">
<div class="container">
    <div class="row">
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3"></h4>
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="teacherOpenCourseSave" class="needs-validation" novalidate>
                <div class="mb-3">
                    <span>课 程 号：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" readonly name="no" value="${courseno}">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>课 程 名：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" name="name">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>学&nbsp;&nbsp;分：</span>
                    <label>
                        <input type="text" maxlength="1" style="margin-top: 10px" name="credit">
                    </label>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary btn-lg btn-block">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
<script type="application/javascript">
    function close() {
        var msg = '<%=request.getAttribute("message")%>';
        if (msg === "保存成功"){
            alert(msg);
        }
        if (msg === "保存失败"){
            alert(msg);
        }
    }
</script>
</html>
