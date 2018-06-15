<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 14.06.18
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h1 align="center"> Book Management </h1>
    <h2 align="center">
        <a href="/new"> Add new book</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list"> List all books</a>
    </h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.price}"/></td>
                <td>action</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
