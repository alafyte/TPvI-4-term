<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="myshortname" uri="http://mycompany.com" %>

<!DOCTYPE html>
<html>
<head>
    <title>FuncTag</title>
</head>
<body>
<div>
    <form>
        <input type="text" name="text">
        <input type="submit" value="check">
    </form>
    <c:if test="${param.text != null}">
        <p><c:out value="${myshortname:check(param.text) ? 'Корректно' : 'Некорректно'}"/></p>
    </c:if>
</div>
</body>
</html>