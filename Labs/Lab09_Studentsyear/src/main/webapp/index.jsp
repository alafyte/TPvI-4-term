<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>

    <form action="${pageContext.request.contextPath}/login" method="get">
        <input type="text" name="course" placeholder="course"><br>
        <input type="text" name="number" placeholder="group"><br>
        <input type="submit" value="Sign in">
    </form>
</div>
</body>
</html>