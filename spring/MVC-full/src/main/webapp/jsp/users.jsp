<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td><c:out value="${u.title}"/></td>
            <td><c:out value="${u.email}"/></td>

            <td><a href="users/edit/${u.user_id}">Edit</a>&nbsp;<a href="users/delete/${u.user_id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>
<br>

<form:form modelAttribute="user" method="POST" action="/adduser" >
    <form:hidden path="user_id"/>

    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title"/></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email"/></td>
        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="submit"></td>
            <td></td>
        </tr>

    </table>


</form:form>