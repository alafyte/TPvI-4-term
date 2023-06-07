<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Table" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: MegaUser
  Date: 08.06.2022
  Time: 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        form {
            display: inline-block;
            margin-right: 70px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            min-width: 300px;
            background: #92eeff;
            text-align: center;
        }
    </style>
</head>
<body>
<table border="1">
    <tr>
        <th>Year</th><th>Sum</th>
    </tr>
    <c:set var="CommonSum" value="${0}" />
    <c:forEach var="table" items="${tables}">
        <tr>
            <td>${table.sum}</td>
            <td>${table.year}</td>
            <c:set var="CommonSum" value="${CommonSum+table.sum}"/>
        </tr>
    </c:forEach>
</table>
<c:if test="${CommonSum > 0}">
    <c:out value = "${CommonSum}"/>
</c:if>
<c:if test="${CommonSum <= 0}">
    <% String redirectURL = "newPage.jsp";
    response.sendRedirect(redirectURL);
    %>

</c:if>

</body>
</html>
