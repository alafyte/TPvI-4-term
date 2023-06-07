<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>Author</th><th>Book name</th><th>Publication year</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.author}</td>
                <td>${book.book_name}</td>
                <td>${book.publication_year}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${IsNextAvailable == null || IsNextAvailable == true}">
    <form method="get">
        <input type="hidden" name="page" value="${nextPage}">
        <input type="submit" value="next">
    </form>
    </c:if>
</div>
</body>
</html>