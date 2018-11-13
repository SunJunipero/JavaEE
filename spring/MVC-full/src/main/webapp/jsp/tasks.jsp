<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Project</td>
        <td>Users</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${tasks}" var="t">
        <tr>
            <td><c:out value="${t.title}"/></td>
            <td><c:out value="${t.project.title}"/></td>
            <td>
                <c:forEach var="u" items="${t.users}">
                    <c:out value="${u.title}"/>&nbsp;
                </c:forEach>
            </td>
            <td><a href="tasks/edit/${t.task_id}">Edit</a>&nbsp;<a href="tasks/delete/${t.task_id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>
<br>

<form:form modelAttribute="task" method="POST" action="/addtask">
    <form:hidden path="task_id"/>

    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title"/></td>

        </tr>

        <tr>
            <td>Project</td>
            <td><form:select path="project" items="${projects}" itemLabel="title" itemValue="project_id"/></td>
            <td><form:errors path="project"/></td>
        </tr>

        <tr>
            <td>Users</td>
            <td><form:select path="users" items="${users}" multiple="multiple" size="5" itemLabel="title"
                             itemValue="user_id"/></td>
            <td><form:errors path="users"/></td>
        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="submit"></td>
            <td></td>
        </tr>


    </table>


</form:form>