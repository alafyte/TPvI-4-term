<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 05.06.2018
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<!-- JSTL - стандартная библиотека тегов JSP -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>JSTL</title>
</head>
<body>
<form action="Servlet" method="get">
  <input type="text" name="txbDay" placeholder="enter day"/>
  <br>
  <input type="text" name="txbMonth" placeholder="enter month"/>
  <br>
  <input type="text" name="txbYear" placeholder="enter year"/>
  <br>
  <input type="submit" value="Check!">
</form>
</body>
</html>
