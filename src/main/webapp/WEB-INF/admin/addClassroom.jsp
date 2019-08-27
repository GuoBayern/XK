<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/27
  Time: 11:32 下午
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
<body onload="close()" class="bg-light">
<div class="container">
    <div class="row">
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3"></h4>
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="adminAddClassroomSave" class="needs-validation" novalidate>
                <div class="mb-3">
                    <span>教 室 位 置：</span>
                    <label>
                        <input type="text" maxlength="20" style="margin-top: 10px" name="address">
                    </label>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary btn-lg btn-block">提交</button>
            </form>
        </div>
    </div>
</div>
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2013-2019 上大晓凡科技有限公司</p>
    <ul class="list-inline">
    </ul>
</footer>
</body>
<script type="application/javascript">
    function close() {
        var msg = '<%=request.getAttribute("message")%>';
        if (msg === "增加成功"){
            alert(msg);
        }
        if (msg === "增加失败"){
            alert(msg);
        }
    }
</script>
</html>
