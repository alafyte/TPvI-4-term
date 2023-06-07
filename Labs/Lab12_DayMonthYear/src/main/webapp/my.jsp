<%--
  Created by IntelliJ IDEA.
  User: NolanRoss
  Date: 20.05.2018
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" uri="/WEB-INF/myTags.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <form>
        <my:TagDay myDay="${day}"/>
        <my:TagMonth myMonth="${month}"/>
        <my:TagYear myYear="${year}"/>
    </form>
</head>
<body>
</body>
</html>
