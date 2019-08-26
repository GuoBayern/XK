<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/26
  Time: 11:06 下午
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
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="teacherEditInfoSave" class="needs-validation" novalidate>
                <div class="mb-3">
                    <span>用 户 名：</span>
                    <label>
                        <input id="noid" type="text" maxlength="20" readonly style="margin-top: 10px" name="no" value="${teacher.get(0).cno}">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>姓&nbsp;&nbsp;名：</span>
                    <label>
                        <input id="nameid" type="text" maxlength="10" readonly style="margin-top: 10px" name="name" value="${teacher.get(0).cname}">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>密&nbsp;&nbsp;码：</span>
                    <label>
                        <input id="passwd" type="password" maxlength="20" style="margin-top: 10px" name="pass">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>重&nbsp;&nbsp;复：</span>
                    <label>
                        <input id="passwd2" type="password" maxlength="20" style="margin-top: 10px" name="repass" onkeyup="checkpass()">
                        <span id="passerror" style="color: red; visibility: hidden">不一致！</span>
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>手 机 号：</span>
                    <label>
                        <input id="telid" type="text" maxlength="11" style="margin-top: 10px" name="tel" value="${teacher.get(0).tel}">
                    </label>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary btn-lg btn-block">更新</button>
            </form>
        </div>
    </div>
</div>
</body>
<script type="application/javascript">
    function checkpass() {
        var pass1 = document.getElementById("passwd").value;
        var pass2 = document.getElementById("passwd2").value;
        if (pass1 !== pass2){
            document.getElementById("passerror").style.visibility = "visible";
        }
        else {
            document.getElementById("passerror").style.visibility = "hidden";
        }
    }
    function close() {
        var msg = '<%=request.getAttribute("message")%>';
        if (msg === "更新成功"){
            alert(msg);
        }
        if (msg === "更新失败"){
            alert(msg);
        }
    }
</script>
</html>
