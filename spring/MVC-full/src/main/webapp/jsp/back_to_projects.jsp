<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${projects}" var="p">
        <tr>
            <td><c:out value="${p.title}"/></td>
            <td><a href="projects/edit/${p.project_id}">Edit</a>&nbsp;<a href="projects/delete/${p.project_id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>
<br>

<form:form  modelAttribute="project" method="POST" >
    <form:hidden path="project_id"/>

    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title"/></td>

        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="submit"></td>
            <td></td>
        </tr>

    </table>


</form:form>