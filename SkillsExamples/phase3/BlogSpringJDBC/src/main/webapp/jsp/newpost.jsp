<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 02.07.18
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="/blog" method="POST">


    <c:choose>
        <c:when test="${post ne null && post.id ne null}">
            <c:set var="isEdit" value="true"/>
            <h1>Edit blog post ${post.title}</h1>
        </c:when>
        <c:otherwise>
            <h1>Create new blog post</h1>
        </c:otherwise>
    </c:choose>

    <c:if test="${error == null} ">
        <%--<span style="color: red">${error}</span>--%>
        <h3>${error}</h3
        <%--<h3>Please, fill required fields</h3>--%>
    </c:if>


    <table>

        <c:set var="postExist" value="${post ne null}"/>

        <c:if test="${isEdit}">
            <input type="hidden" title="id" value="${post.id}"/>
        </c:if>

        <tr>
            <td>Title</td>
            <td><input type="text" title="title"
                       <c:if test="${isEdit}">value="${post.title}"</c:if> ></td>
        </tr>
        <tr>
            <td>Summary</td>
            <td><textarea title="summary" rows="10" cols="60"><c:if test="${isEdit}">${post.summary}</c:if></textarea>
            </td>
        </tr>
        <tr>
            <td>Body</td>
            <td><textarea title="body" rows="30" cols="60"><c:if test="${isEdit}">${post.body}</c:if></textarea></td>
        </tr>
        <tr>
            <td>Category</td>
            <td>
                <%--<select title="category">--%>

                    <%--<c:forEach items="${categories}" var="cat">--%>
                        <%--<option--%>
                                <%--<c:if test="${isEdit && cat.id == post.category.id}"/>--%>
                                <%--selected value="${cat.id}">${cat.title}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
                <select title="category">
                    <c:forEach items="${categories}" var="cat">
                        <option <c:if test="${isEdit && cat.id == post.category.id}">
                                selected ="selected" </c:if> value="${cat.id}">${cat.title} ${cat.id} </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
