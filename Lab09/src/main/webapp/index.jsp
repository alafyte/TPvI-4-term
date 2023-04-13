<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css"/>
    <title>Lab09</title>
</head>
<body>
<a href="task2.jsp">TASK 2</a>
<br/>
<a href="LoginPage.jsp">TASK 3</a>
<form action="ServletFirst" method="get">
    <input type="submit" value="TASK 6 GET" />
</form>
<form action="ServletFirst" method="post">
    <input type="submit" value="TASK 6 POST" />
</form>
<form action="Servlet1" method="get">
    <input type="text" autocomplete="off" name="name" placeholder="Введите имя" />
    <br/>
    <input type="submit" value="TASK 7" />
</form>
</body>
</html>