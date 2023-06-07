<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Work</title>
</head>
<body>
<div>
    <h3>Добро пожаловать, ${user.login}</h3>
    <p>${info}</p>
    <div>
    <c:choose>
        <c:when test="${not empty balance}">
            <p>Ваш баланс: ${balance}</p>
        </c:when>
        <c:when test="${empty balance}">
            <form method="get">
                <input type="hidden" name="command" value="show_balance">
                <input type="submit" value="GETINFO">
            </form>
        </c:when>
    </c:choose>
        <div>
            <form method="get">
                <input type="number" name="quantity" min="1">
                <input type="submit" name="command" value="PAY">
                <input type="submit" name="command" value="ADD">
            </form>
        </div>
    </div>
    <div>
        <a href="${pageContext.servletContext.contextPath}/signout">Выйти</a>
    </div>
</div>
</body>
</html>
