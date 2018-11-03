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
            <td><a href="users/edit/${u.user_id}">Edit</a>&nbsp;<a href="users/delete/${u.user_id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<form:form modelAttribute="user" method="POST" action="/adduser" >
    <form:hidden path="user_id"/>

    <table>
        <tr>
            <td>First name:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="user_first_name"/></td>
            <%--<td><form:errors path="name"/></td>--%>
        </tr>
        <tr>
            <td>Last name:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="user_last_name"/></td>
            <%--<td><form:errors path="name"/></td>--%>
        </tr>
        <tr>
            <td>Name:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="user_name"/></td>
            <%--<td><form:errors path="name"/></td>--%>
        </tr>
        <tr>
            <td>Password:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="password"/></td>
            <%--<td><form:errors path="name"/></td>--%>
        </tr>
        <tr>
            <td>Email:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="email"/></td>
            <%--<td><form:errors path="email"/></td>--%>
        </tr>
        <tr>
            <td>Birthday:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="birthday"/></td>
            <%--<td><form:errors path="email"/></td>--%>
        </tr>
        <tr>
            <td>Activate:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="is_active"/></td>
            <%--<td><form:errors path="email"/></td>--%>
        </tr>
        <tr>
            <td>Created stamp:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="created_stamp"/></td>
            <%--<td><form:errors path="email"/></td>--%>
        </tr>
        <tr>
            <td>Last updated stamp:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="last_updated_stamp"/></td>
            <%--<td><form:errors path="email"/></td>--%>
        </tr>
        <tr>
            <td>Address:</td>
            <%--<td><input type="text"> </td>--%>
            <td><form:input path="address"/></td>
            <%--<td><form:errors path="email"/></td>--%>
        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="submit"></td>
            <td></td>
        </tr>

    </table>


</form:form>
<%--</form>--%>
</body>
</html>
