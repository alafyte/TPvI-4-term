<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/tableStyle.css"/>
    <title>SQL tags</title>
</head>
<body>
<sql:setDataSource var = "snapshot" driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
                   url = "jdbc:sqlserver://DESKTOP-MFP40AR:1433;database=Lab09;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false"
                   user = "User1"  password = "user1"/>

<sql:query dataSource = "${snapshot}" sql = "select * from Timetable" var = "result" />
<table>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th>День</th>
        <th>Время</th>
    </tr>
    <c:forEach items="${result.rows}" var="res">
        <tr>
            <td><c:out value="${res.ClassId}"/></td>
            <td><c:out value="${res.ClassName}"/></td>
            <td><c:out value="${res.ClassDay}"/></td>
            <td><c:out value="${res.ClassHours}"/></td>
        </tr>
    </c:forEach>
</table>

<sql:query dataSource="${snapshot}" var="user" >
    SELECT * FROM Users where User_Login = ?
    <sql:param value="user11" />
</sql:query>

<table>
    <tr>
        <th>Id</th>
        <th>Логин</th>
        <th>Роль</th>
    </tr>
    <c:forEach items="${user.rows}" var="us">
        <tr>
            <td><c:out value="${us.ID}"/></td>
            <td><c:out value="${us.User_Login}"/></td>
            <td><c:out value="${us.User_Role}"/></td>
        </tr>
    </c:forEach>
</table>


<sql:transaction dataSource = "${snapshot}">
    <sql:update var = "count">
        UPDATE Users SET User_Login = 'user15' WHERE ID = 5
    </sql:update>

    <sql:update var = "count">
        UPDATE Users SET User_Login = 'New Login' WHERE ID = 5
    </sql:update>
</sql:transaction>

<sql:query dataSource = "${snapshot}" var = "user">
    SELECT * from Users;
</sql:query>

<table>
    <tr>
        <th>Id</th>
        <th>Логин</th>
        <th>Роль</th>
    </tr>
    <c:forEach items="${user.rows}" var="us">
        <tr>
            <td><c:out value="${us.ID}"/></td>
            <td><c:out value="${us.User_Login}"/></td>
            <td><c:out value="${us.User_Role}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
