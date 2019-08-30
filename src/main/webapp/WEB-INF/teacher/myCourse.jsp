<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxguo
  Date: 2019/8/30
  Time: 12:16 下午
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
<body class="bg-light">
<div class="table-responsive" id="tablediv">
    <table class="table table-striped" id="tableid">
        <thead>
        <tr>
            <th></th>
            <th>周一</th>
            <th>周二</th>
            <th>周三</th>
            <th>周四</th>
            <th>周五</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>1(8:00-9:40)</td>
                <c:if test="${oneone != null}">
                    <td>${oneone}</td>
                </c:if>
                <c:if test="${oneone == null}">
                    <td></td>
                </c:if>
                <c:if test="${twoone != null}">
                    <td>${twoone}</td>
                </c:if>
                <c:if test="${twoone == null}">
                    <td></td>
                </c:if>
                <c:if test="${threeone != null}">
                    <td>${threeone}</td>
                </c:if>
                <c:if test="${threeone == null}">
                    <td></td>
                </c:if>
                <c:if test="${fourone != null}">
                    <td>${fourone}</td>
                </c:if>
                <c:if test="${fourone == null}">
                    <td></td>
                </c:if>
                <c:if test="${fiveone != null}">
                    <td>${fiveone}</td>
                </c:if>
                <c:if test="${fiveone == null}">
                    <td></td>
                </c:if>
            </tr>
            <tr>
                <td>2(10:00-11:40)</td>
                <c:if test="${onetwo != null}">
                    <td>${onetwo}</td>
                </c:if>
                <c:if test="${onetwo == null}">
                    <td></td>
                </c:if>
                <c:if test="${twotwo != null}">
                    <td>${twotwo}</td>
                </c:if>
                <c:if test="${twotwo == null}">
                    <td></td>
                </c:if>
                <c:if test="${threetwo != null}">
                    <td>${threetwo}</td>
                </c:if>
                <c:if test="${threetwo == null}">
                    <td></td>
                </c:if>
                <c:if test="${fourtwo != null}">
                    <td>${fourtwo}</td>
                </c:if>
                <c:if test="${fourtwo == null}">
                    <td></td>
                </c:if>
                <c:if test="${fivetwo != null}">
                    <td>${fivetwo}</td>
                </c:if>
                <c:if test="${fivetwo == null}">
                    <td></td>
                </c:if>
            </tr>
            <tr>
                <td>3(13:00-14:40)</td>
                <c:if test="${onethree != null}">
                    <td>${onethree}</td>
                </c:if>
                <c:if test="${onethree == null}">
                    <td></td>
                </c:if>
                <c:if test="${twothree != null}">
                    <td>${twothree}</td>
                </c:if>
                <c:if test="${twothree == null}">
                    <td></td>
                </c:if>
                <c:if test="${threethree != null}">
                    <td>${threethree}</td>
                </c:if>
                <c:if test="${threethree == null}">
                    <td></td>
                </c:if>
                <c:if test="${fourthree != null}">
                    <td>${fourthree}</td>
                </c:if>
                <c:if test="${fourthree == null}">
                    <td></td>
                </c:if>
                <c:if test="${fivethree != null}">
                    <td>${fivethree}</td>
                </c:if>
                <c:if test="${fivethree == null}">
                    <td></td>
                </c:if>
            </tr>
            <tr>
                <td>4(15:00-16:40)</td>
                <c:if test="${onefour != null}">
                    <td>${onefour}</td>
                </c:if>
                <c:if test="${onefour == null}">
                    <td></td>
                </c:if>
                <c:if test="${twofour != null}">
                    <td>${twofour}</td>
                </c:if>
                <c:if test="${twofour == null}">
                    <td></td>
                </c:if>
                <c:if test="${threefour != null}">
                    <td>${threefour}</td>
                </c:if>
                <c:if test="${threefour == null}">
                    <td></td>
                </c:if>
                <c:if test="${fourfour != null}">
                    <td>${fourfour}</td>
                </c:if>
                <c:if test="${fourfour == null}">
                    <td></td>
                </c:if>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
