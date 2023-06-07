<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<div>
    <p>${info}</p>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="radio" name="role" value="USER">User<br>
        <input type="radio" name="role" value="ADMIN">Admin<br>
        <input type="password" name="password" placeholder="password">
        <input type="submit" value="Sign in">
    </form>
</div>
</body>
</html>