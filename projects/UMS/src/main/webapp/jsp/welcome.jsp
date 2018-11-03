<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome : ${username}</h2>

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
                <td><a href="/users/${u.user_id}.html">View</a> </td>
            </tr>
        </c:forEach>
    </table>

    <sec:authorize ifAllGranted="ROLE_ADMIN">
        <a href="<c:url value="/admin" />" > Administration</a>
    </sec:authorize>

</body>
</html>
