<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/25
  Time: 3:31 下午
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
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="adminInsertStudentSave" class="needs-validation" novalidate>
                    <div class="mb-3">
                        <span>用 户 名：</span>
                        <label>
                            <input type="text" maxlength="20" readonly style="margin-top: 10px" name="no" value="${sno}">
                        </label>
                    </div>
                    <br/>
                    <div class="mb-3">
                        <span>姓&nbsp;&nbsp;名：</span>
                        <label>
                            <input type="text" maxlength="10" style="margin-top: 10px" name="name">
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
                            <input id="passwd2" type="password" maxlength="20" style="margin-top: 10px" name="repass"onkeyup="checkpass()">
                            <span id="passerror" style="color: red; visibility: hidden">不一致！</span>
                        </label>
                    </div>
                    <br/>
                    <div class="mb-3">
                        <span>手 机 号：</span>
                        <label>
                            <input type="text" maxlength="11" style="margin-top: 10px" name="tel">
                        </label>
                    </div>
                    <br/>
                <div class="mb-3">
                    <span>性&nbsp;&nbsp;别：</span>
                    <label>
                        <input type="radio" name="sex" value="male" style="width: 20px;height: 20px;position: relative; top:4px">
                    </label>
                    男
                    <label>
                        <input type="radio" name="sex" value="female" style="width: 20px;height: 20px;position: relative; top:4px">
                    </label>
                    女
                </div>
                    <br/>
                    <div class="mb-3">
                        <span>学&nbsp;&nbsp;院：</span>
                        <label>
                            <select name="academy">
                                <option value="理学院">理学院</option>
                                <option value="生命科学学院">生命科学学院</option>
                                <option value="文学院">文学院</option>
                                <option value="法学院">法学院</option>
                                <option value="外国语学院">外国语学院</option>
                                <option value="社会学院">社会学院</option>
                                <option value="马克思主义学院">马克思主义学院</option>
                                <option value="计算机工程与科学学院">计算机工程与科学学院</option>
                                <option value="机电工程与自动化学院">机电工程与自动化学院</option>
                                <option value="通信与信息工程学院">通信与信息工程学院</option>
                                <option value="环境与化学工程学院">环境与化学工程学院</option>
                                <option value="材料科学与工程学院">材料科学与工程学院</option>
                                <option value="中欧工程技术学院">中欧工程技术学院</option>
                                <option value="土木工程系">土木工程系</option>
                                <option value="材料基因组工程研究院">材料基因组工程研究院</option>
                                <option value="经济学院">经济学院</option>
                                <option value="管理学院">管理学院</option>
                                <option value="图书情报档案系">图书情报档案系</option>
                                <option value="悉尼工商学院">悉尼工商学院</option>
                                <option value="音乐学院">音乐学院</option>
                                <option value="体育学院">体育学院</option>
                                <option value="数码艺术学院">数码艺术学院</option>
                                <option value="钱伟长学院">钱伟长学院</option>
                            </select>
                        </label>
                    </div>
                    <br/>
                    <button type="submit" class="btn btn-primary btn-lg btn-block">保存</button>
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
        if (msg === "保存成功"){
            alert(msg);
        }
        if (msg === "保存失败"){
            alert(msg);
        }
    }
</script>
</html>
