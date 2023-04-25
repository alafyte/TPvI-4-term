<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Admin page</title>
  <link href="styles/mainPage.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
  <div id="tableDiv">
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Название</th>
        <th>День</th>
        <th>Время</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach items="${classes}" var="cl">
      <tr>
        <td>${cl.getClassId()}</td>
        <td>${cl.getClassName()}</td>
        <td>${cl.getClassDay()}</td>
        <td>${cl.getClassHours()}</td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>


  <div id="add-remove-div">
    <form id="add-form" method="post" action="${pageContext.servletContext.contextPath}/controller?command=add_new_class">
      <h3 style="font-weight: bold">Добавить занятие</h3>
      <input type="text" placeholder="Название" name="name"/>
      <input type="text" placeholder="День недели" name="day"/>
      <input type="text" placeholder="Время" name="hours"/>
      <button type="submit">Добавить</button>
    </form>
    <br/><br/>
  </div>

</div>


<jsp:include page="footer.jsp"/>

</body>
</html>