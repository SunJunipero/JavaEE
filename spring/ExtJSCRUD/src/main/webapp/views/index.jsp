<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>book index </h3>
    <table>
        <tr>
            <td>Title</td>
            <td>Author</td>
            <td>Price</td>
            <td>Qty</td>
        </tr>
        <c:forEach items="${books}" var="b">
            <tr>
                <td><c:out value="${u.title}"/></td>
                <td><c:out value="${u.author}"/></td>
                <td><c:out value="${u.price}"/></td>
                <td><c:out value="${u.qty}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
