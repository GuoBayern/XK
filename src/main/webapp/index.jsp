<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/25
  Time: 12:01 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <script src="../statics/admin/jquery-1.5.1.js" type="text/javascript"></script>
    <script src="../statics/admin/jquery-1.5.1.js" type="text/javascript"></script>
    <meta charset="UTF-8"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><title>
        登录
    </title>
    <link href="../statics/admin/StyleLogin.css" rel="stylesheet" type="text/css">
    <link href="../statics/admin/login.css" rel="stylesheet" type="text/css">
</head>
<body onload="daoying()">
    <div class="login">
        <div class="logo">
            <img alt="" src="../statics/admin/jiaowulogo.png"> <img alt="" src="../statics/admin/jiaowu.png" class="pageTitle">
        </div>

        <div class="loginbox">
            <div class="loginbgimg">
                <img alt="" src="../statics/admin/jiaowubgimg.jpg">
            </div>
            <form action="login" method="get">
                <div class="userlogin">
                    <div id="userloign" class="dengl">用户登录<div style="overflow:hidden;width:328px;height:1px;position:absolute;top:54px;left:30px;filter:alpha(opacity=20);opacity:0.2"><p class="daoying" style="margin:-17px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:55px;left:30px;filter:alpha(opacity=19);opacity:0.19"><p class="daoying" style="margin:-16px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:56px;left:30px;filter:alpha(opacity=18);opacity:0.18"><p class="daoying" style="margin:-15px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:57px;left:30px;filter:alpha(opacity=17);opacity:0.17"><p class="daoying" style="margin:-14px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:58px;left:30px;filter:alpha(opacity=16);opacity:0.16"><p class="daoying" style="margin:-13px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:59px;left:30px;filter:alpha(opacity=15);opacity:0.15"><p class="daoying" style="margin:-12px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:60px;left:30px;filter:alpha(opacity=14);opacity:0.14"><p class="daoying" style="margin:-11px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:61px;left:30px;filter:alpha(opacity=13);opacity:0.13"><p class="daoying" style="margin:-10px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:62px;left:30px;filter:alpha(opacity=12);opacity:0.12"><p class="daoying" style="margin:-9px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:63px;left:30px;filter:alpha(opacity=11);opacity:0.11"><p class="daoying" style="margin:-8px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:64px;left:30px;filter:alpha(opacity=10);opacity:0.1"><p class="daoying" style="margin:-7px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:65px;left:30px;filter:alpha(opacity=9);opacity:0.09"><p class="daoying" style="margin:-6px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:66px;left:30px;filter:alpha(opacity=8);opacity:0.08"><p class="daoying" style="margin:-5px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:67px;left:30px;filter:alpha(opacity=7);opacity:0.07"><p class="daoying" style="margin:-4px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:68px;left:30px;filter:alpha(opacity=6);opacity:0.06"><p class="daoying" style="margin:-3px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:69px;left:30px;filter:alpha(opacity=5);opacity:0.05"><p class="daoying" style="margin:-2px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:70px;left:30px;filter:alpha(opacity=4);opacity:0.04"><p class="daoying" style="margin:-1px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:71px;left:30px;filter:alpha(opacity=3);opacity:0.03"><p class="daoying" style="margin:-0px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:72px;left:30px;filter:alpha(opacity=2);opacity:0.02"><p class="daoying" style="margin:--1px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:73px;left:30px;filter:alpha(opacity=1);opacity:0.01"><p class="daoying" style="margin:--2px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:74px;left:30px;filter:alpha(opacity=0);opacity:0"><p class="daoying" style="margin:--3px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:75px;left:30px;filter:alpha(opacity=-1);opacity:-0.01"><p class="daoying" style="margin:--4px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:76px;left:30px;filter:alpha(opacity=-2);opacity:-0.02"><p class="daoying" style="margin:--5px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:77px;left:30px;filter:alpha(opacity=-3);opacity:-0.03"><p class="daoying" style="margin:--6px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:78px;left:30px;filter:alpha(opacity=-4);opacity:-0.04"><p class="daoying" style="margin:--7px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:79px;left:30px;filter:alpha(opacity=-5);opacity:-0.05"><p class="daoying" style="margin:--8px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:80px;left:30px;filter:alpha(opacity=-6);opacity:-0.06"><p class="daoying" style="margin:--9px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:81px;left:30px;filter:alpha(opacity=-7);opacity:-0.07"><p class="daoying" style="margin:--10px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:82px;left:30px;filter:alpha(opacity=-8);opacity:-0.08"><p class="daoying" style="margin:--11px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:83px;left:30px;filter:alpha(opacity=-9);opacity:-0.09"><p class="daoying" style="margin:--12px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:84px;left:30px;filter:alpha(opacity=-10);opacity:-0.1"><p class="daoying" style="margin:--13px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:85px;left:30px;filter:alpha(opacity=-11);opacity:-0.11"><p class="daoying" style="margin:--14px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:86px;left:30px;filter:alpha(opacity=-12);opacity:-0.12"><p class="daoying" style="margin:--15px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:87px;left:30px;filter:alpha(opacity=-13);opacity:-0.13"><p class="daoying" style="margin:--16px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:88px;left:30px;filter:alpha(opacity=-14);opacity:-0.14"><p class="daoying" style="margin:--17px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:89px;left:30px;filter:alpha(opacity=-15);opacity:-0.15"><p class="daoying" style="margin:--18px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:90px;left:30px;filter:alpha(opacity=-16);opacity:-0.16"><p class="daoying" style="margin:--19px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:91px;left:30px;filter:alpha(opacity=-17);opacity:-0.17"><p class="daoying" style="margin:--20px 0px 0px 0px">用户登录</p></div><div style="overflow:hidden;width:328px;height:1px;position:absolute;top:92px;left:30px;filter:alpha(opacity=-18);opacity:-0.18"><p class="daoying" style="margin:--21px 0px 0px 0px">用户登录</p></div></div>
                    <table style="width: 100%;">
                        <tbody><tr>
                            <td style="width: 6em;">学号/工号：</td>
                            <td>
                                <label for="txtUserName"></label><input class="input long" id="txtUserName" name="txtUserName" style="width:155px" type="text" value="">
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 6em;">密码：</td>
                            <td>
                                <label for="txtPassword"></label><input class="input long" id="txtPassword" name="txtPassword" style="width:155px" type="password" value="">
                            </td>
                        </tr>
                        </tbody></table>
                    <input type="submit" id="btnCheckLogin" class="btnlogin" value="登 录" onclick="return ValidateInput()">
                </div>
            </form>
                <br><br>
                <span></span>
                <br>
                <a href="http://services.shu.edu.cn/" class="forPsw">忘记密码了？</a>

                <div id="divError" style="width: 100%; color: Red; font-size: 14px; text-align: center;">

                </div>
                <div id="divLoginAlert" style="width: 100%; color: Red; font-size: 14px; text-align: center;">

                </div>
            </div>
        </div>

        <span></span>
        <div class="bottom">
            <div class="copyright">
                <p>Copyright © 2013-2019 Shanghai University</p>
                <p>技术支持 上海大学晓凡科技有限公司</p>
            </div>
        </div>



<script type="text/javascript">
    /**
     * @return {boolean}
     */
    function ChangeValiCode(url) {
        var item = document.getElementById('Img1');
        item.setAttribute('src', url + GetTimestamp());
        return false;

    }
    /**
     * @return {string}
     */
    function GetTimestamp() {
        return (new Date()).valueOf().toString();
    }

    /**
     * @return {boolean}
     */
    function ValidateInput() {
        $("#divError").empty();
        var item = $("#txtUserName").val();
        if (item == null || $.trim(item) === "") {
            $("#divLoginAlert").html('请输入学号/工号！');
            $("#txtUserName").focus();
            return false;
        }
        item = $("#txtPassword").val();
        if (item == null || $.trim(item) === "") {
            $("#divLoginAlert").html('请输入密码！');
            $("#txtPassword").focus();
            return false;
        }
        return true;
    }

    function daoying() {
        tat = document.getElementById("userloign").innerHTML;
        aaa = "";
        ja = "";
        for(i = 19, a = 20; i < 58; i++, a--) {
            ja += "<div style='overflow:hidden;width:328px;height:1px;position:absolute;top:" + (i+35) + "px;left:30px;filter:alpha(opacity=" + a + ");opacity:" + (a / 100) + "'><p class='daoying' style='margin:-" + (18 - (i - 18)) + "px 0px 0px 0px'>" + tat + "</p></div>"
        }
        userloign.innerHTML += ja;

        var msg = '<%=request.getAttribute("message")%>';
        if (msg !== "null"){
            alert(msg);
        }
    }
</script>
</body></html>
