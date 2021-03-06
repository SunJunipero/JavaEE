<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 02.07.18
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage Categories</title>
</head>
<body>
<jsp:include page="index.jsp"/>

<table border="1">

    <c:forEach items="${categories}" var="cat">
        <tr>
            <td style="background: #e6e6fa; width: 50%;">${cat.title}</td>
            <td style="background: #6495ed;"><a href="/admin?action=edit&category=${cat.id}">Edit</a></td>
            <td style="background: #f08080;"><a href="/admin?action=delete&category=${cat.id}">Delete</a></td>
        </tr>
    </c:forEach>


    <c:choose>
        <c:when test="${category ne null}">
            <c:set var="isEdit" value="true"/>
            <h1>Edit category ${category.title}</h1>
        </c:when>
        <c:otherwise>
            <h1>Create new category</h1>
        </c:otherwise>
    </c:choose>


    <form action="/admin" method="POST">

        <c:if test="${isEdit}">
            <input type="hidden" title="id" value="${category.id}"/>
        </c:if>

        <table>

            <tr>
                <td>Name</td>
                <td><input type="text" title="title" <c:if test="${isEdit}">value="${category.title}"</c:if> /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"></td>
            </tr>

        </table>


    </form>

</table>

</body>
</html>
