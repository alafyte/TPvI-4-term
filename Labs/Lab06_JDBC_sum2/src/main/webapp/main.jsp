<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Work</title>
</head>
<body>
<div>
    <h3>Добро пожаловать, ${username}</h3>


    <div>
        <c:choose>
            <c:when test="${not empty balance}">
                <p>Ваш баланс: ${balance}</p>
            </c:when>
            <c:when test="${empty balance}">
                <form action="main" method="get">
                    <input type="hidden" name="command" value="show_balance">
                    <input type="submit" value="CHECK">
                </form>
            </c:when>
        </c:choose>
        <div>
            <form method="get" action="main">
                <input type="submit" name="command" value="PAY">
            </form>
        </div>
    </div>

</div>
</body>
</html>
