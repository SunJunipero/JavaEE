<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <td><a href="users/edit/${u.user_id}">Edit</a>&nbsp;<a href="users/delete/${u.user_id}">Delete</a>&nbsp;
                <a href="/users/${u.user_id}.html">View</a>
            </td>
        </tr>
    </c:forEach>
</table>
    <a href="/add">add new user</a>


</body>
</html>
