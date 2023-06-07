<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Comments</title>
</head>
<body>
<div>
    <c:forEach var="comment" items="${comments}">
        <table>
            <tr><th colspan="2">${comment.text}</th></tr>
            <tr>
                <td>Like: ${comment.like}</td>
                <td>Dislike: ${comment.dislike}</td>
            </tr>
            <tr>
                <td>
                    <form method="post">
                        <input type="hidden" name="id" value="${comment.id}">
                        <input type="hidden" name="like" value="<c:out value="${comment.like + 1}"/>">
                        <input type="hidden" name="dislike" value="${comment.dislike}">
                        <input type="submit" value="Like"/>
                    </form>
                </td>
                <td>
                    <form method="post">
                        <input type="hidden" name="id" value="${comment.id}">
                        <input type="hidden" name="dislike" value="<c:out value="${comment.dislike + 1}"/>">
                        <input type="hidden" name="like" value="${comment.like}">
                        <input type="submit" value="Dislike"/>
                    </form>
                </td>
            </tr>
        </table>
    </c:forEach>
</div>
</body>
</html>
