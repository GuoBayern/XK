<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/25
  Time: 7:44 下午
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
<div class="container" id="editdiv" style="display: none">
    <div class="row">
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3"></h4>
            <form name="uf" accept-charset="utf-8" id="uf" method="get" action="adminEditStudentSave" class="needs-validation" novalidate>
                <div class="mb-3">
                    <span>用 户 名：</span>
                    <label>
                        <input id="noid" type="text" maxlength="20" readonly style="margin-top: 10px" name="no" value="">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>姓&nbsp;&nbsp;名：</span>
                    <label>
                        <input id="nameid" type="text" maxlength="10" readonly style="margin-top: 10px" name="name" value="">
                    </label>
                </div>
                <br/>
                <div class="mb-3">
                    <span>手 机 号：</span>
                    <label>
                        <input id="telid" type="text" maxlength="11" style="margin-top: 10px" name="tel" value="">
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
                        <select name="academy" id="academyid">
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
                <button type="submit" class="btn btn-primary btn-lg btn-block">更新</button>
            </form>
        </div>
    </div>
</div>
<div class="table-responsive" id="tablediv">
    <table class="table table-striped" id="tableid">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>电话</th>
            <th>院系编号</th>
            <th>编辑</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${student}" var="student">
            <tr onmouseover="subm(this)">
                <td>${student.sno}</td>
                <td>${student.sname}</td>
                <td>${student.sex}</td>
                <td>${student.tel}</td>
                <td>${student.departmentno}</td>
                <td>
                    <label>
                        <span class="glyphicon glyphicon-edit" aria-hidden="true" style="cursor: pointer" onclick="change()">
                        </span>
                    </label>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script type="application/javascript">
    var i;
    function subm(o) {
        i = o.rowIndex;
    }
    function change(){
        var no = document.getElementById("tableid").rows[i].cells[0].innerHTML;
        var name = document.getElementById("tableid").rows[i].cells[1].innerHTML;
        var sex = document.getElementById("tableid").rows[i].cells[2].innerHTML;
        var tel = document.getElementById("tableid").rows[i].cells[3].innerHTML;
        var departmentno = document.getElementById("tableid").rows[i].cells[4].innerHTML;
        var radio = document.getElementsByName("sex");
        if (sex === '男'){
            radio[0].checked = true;
        }
        else {
            radio[1].checked = true;
        }
        document.getElementById("noid").value = no;
        document.getElementById("nameid").value = name;
        document.getElementById("telid").value = tel;
        document.getElementById("academyid")[parseInt(departmentno) - 1].selected = true;
        document.getElementById("editdiv").style.display = "block";
        document.getElementById("tablediv").style.display = "none";
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
