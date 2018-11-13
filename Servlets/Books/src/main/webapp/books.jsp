<%@ page import="java.util.List" %>
<%@ page import="com.books.Book" %><%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 13.06.18
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
    lolllllll !!!!!!
<%--<%--%>
    <%--List<Book> bookList = ((List<Book>) request.getAttribute("booksList"));--%>
<%--%>--%>
    <ul>
        <c:forEach items="${booksList}" var="book">
            <li>id: ${book.id}, title: ${book.title}</li>
        </c:forEach>
    </ul>

</body>
</html>
