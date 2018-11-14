<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/RowEditor.css"/>

    <link rel="stylesheet" type="text/css" href="/resources/css/ext-all.css"/>
    <script type="text/javascript" src="/resources/js/ext-base-debug.js"></script>
    <script type="text/javascript" src="/resources/js/ext-all-debug.js"></script>

    <script src="/resources/js/RowEditor.js"></script>

    <script type="text/javascript" src="/resources/js/grid.js"></script>
    <title>Welcome page</title>
</head>
<body>
<h2>Welcome : ${username}</h2>

<table>
    <tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Name</td>
        <td>Email</td>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td><c:out value="${u.user_first_name}"/></td>
            <td><c:out value="${u.user_last_name}"/></td>
            <td><c:out value="${u.user_name}"/></td>
            <td><c:out value="${u.email}"/></td>
        </tr>
    </c:forEach>
</table>

<sec:authorize ifAllGranted="ROLE_ADMIN">
    <h3>Administration</h3>
    <div id="users-grid"></div>
</sec:authorize>

<a href="/logout">logout</a>

</body>
</html>
