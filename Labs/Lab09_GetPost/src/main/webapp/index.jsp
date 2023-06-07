<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<div>
    <form method="get" action="getpost">
        <input type="submit" value="GET">
    </form>
    <form method="post" action="getpost">
        <input type="submit" value="POST">
    </form>
</div>
<div>
    <p>Time: ${cookie.time.value}</p>
    <p>Method: ${cookie.method.value}</p>
</div>
</body>
</html>