<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 02.07.18
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <table width="100%">
        <tr>
            <td colspan="2" align="right"><a href="/newpost">Create post</a></td>
        </tr>
        <tr>
            <td width="70%" valign="top">
                <h2>Posts</h2>

                <c:forEach items="${posts}" var="post">
                    <h1>${post.title}</h1>
                    <p>${post.summary}</p>
                    <a href="/blog?post=${post.id}">Read more...</a>
                    <hr/>
                </c:forEach>

            </td>


            <td  valign="top">
                <h2>Categories:</h2>
                <ul>
                    <c:forEach items="${categories}" var="cat">
                        <li><a href="/blog?category=${cat.id}">${cat.name}</a></li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </table>
</body>
</html>
