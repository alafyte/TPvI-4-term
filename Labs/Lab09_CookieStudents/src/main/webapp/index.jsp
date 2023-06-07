<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <p>${info}</p>
    <form action="login" method="get">
        <input type="number" name="course" placeholder="course"><br>
        <input type="number" name="group" placeholder="group"><br>
        <input type="text" name="specialty" placeholder="specialty"><br>
        <input type="submit" value="Sign in">
    </form>
    <div>
        <a href="clearcookies">Очистить куки</a>
    </div>
</div>
</body>
</html>