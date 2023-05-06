<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css"/>
    <title>Регистрация</title>
</head>
<body>
<h2><%= "Регистрация" %></h2>
<form method="post" action="Register">
    <input type="text" name="login" placeholder="Придумайте логин"/><br/>
    <input type="password" name="password" placeholder="Придумайте пароль"/> <br/>
    <input type="submit" value="Зарегистрироваться"/>
</form>
</body>
</html>
