<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Administrator page</h2>
<table>
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td><c:out value="${u.user_name}"/></td>
            <td><c:out value="${u.email}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
