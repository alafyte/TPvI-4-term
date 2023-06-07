<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
  <form action="${pageContext.servletContext.contextPath}/login" method="get">
    <input type="text" name="login" placeholder="login"/>
    <input type="submit" value="Sign in"/>
  </form>
</div>
</body>
</html>
