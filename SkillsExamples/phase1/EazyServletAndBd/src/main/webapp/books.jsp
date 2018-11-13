<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 14.06.18
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books from BD</title>
</head>
<body>
    <ul>
        <c:forEach items="${books}" var="book">
            <li>
                id: ${book.id}  Name ${book.title}
            </li>
        </c:forEach>

    </ul>
</body>
</html>
