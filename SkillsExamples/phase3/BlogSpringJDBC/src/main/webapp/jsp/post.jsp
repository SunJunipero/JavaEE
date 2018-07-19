<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 02.07.18
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${post.title}</title>
</head>
<body>
    <jsp:include page="header.jsp"/>

    <span style="font-size: 32px; color: #00008b">${post.title}</span>
    <p>${post.summary}</p>
    <hr/>
    <p>${post.body}</p>
</body>
</html>
