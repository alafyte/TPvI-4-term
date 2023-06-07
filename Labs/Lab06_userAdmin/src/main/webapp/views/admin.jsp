
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<div>
    <p>Hello, ${user.role}</p>
    <p>Time: ${time}</p>

</div>
<div>
    <a href="${pageContext.request.contextPath}">back</a>
</div>
</body>
</html>
