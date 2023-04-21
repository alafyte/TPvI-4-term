<%@ page import="by.belstu.Lab10.classes.DAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="by.belstu.Lab10.classes.UniversityClass" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <%
        try {
          DAO db = new DAO();
          db.getConnection();
          ArrayList<UniversityClass> classes = new ArrayList<>(db.getClasses());
          for (UniversityClass uc : classes) {
      %>
      <tr>
        <td><%=uc.getClassId()%></td>
        <td><%=uc.getClassName()%></td>
        <td><%=uc.getClassDay()%></td>
        <td><%=uc.getClassHours()%></td>
      </tr>
      <%
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      %>
      </tbody>
    </table>
  </div>


  <div id="add-remove-div">
    <form id="add-form" method="post" action="MainServlet">
      <h3 style="font-weight: bold">Добавить занятие</h3>
      <input type="text" placeholder="Название" name="name" autocomplete="off"/>
      <input type="text" placeholder="День недели" name="day" autocomplete="off"/>
      <input type="text" placeholder="Время" name="hours" autocomplete="off"/>
      <button type="submit">Добавить</button>
    </form>
    <br/><br/>
    <form id="remove-form" method="get" action="MainServlet">
      <h3 style="font-weight: bold">Удалить занятие</h3>
      <input type="text" placeholder="ID" name="id" autocomplete="off"/>
      <button type="submit">Удалить</button>
    </form>
  </div>

</div>


<jsp:include page="footer.jsp"/>

</body>
</html>