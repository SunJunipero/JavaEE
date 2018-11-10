<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Name</td>
            <td>Password</td>
            <td>Email</td>
            <td>Birthday</td>
            <td>Is active</td>
            <td>created_stamp</td>
            <td>last_updated_stamp</td>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td><c:out value="${u.user_first_name}"/></td>
                <td><c:out value="${u.user_last_name}"/></td>
                <td><c:out value="${u.user_name}"/></td>
                <td><c:out value="${u.password}"/></td>
                <td><c:out value="${u.email}"/></td>
                <td><c:out value="${u.birthday}"/></td>
                <td><c:out value="${u.is_active}"/></td>
                <td><c:out value="${u.created_stamp}"/></td>
                <td><c:out value="${u.last_updated_stamp}"/></td>
                <%--<td><a href="/users/${u.user_id}.html">View</a> </td>--%>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
