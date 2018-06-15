<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 15.06.18
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <h1 align="center"> Book Management </h1>
    <h2 align="center">
        <a href="/new"> Add new book</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list"> List all books</a>
    </h2>
    <div align="center">
        <c:if test="${book != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="insert" method="post">
        </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${book != null}">
                            Edit book
                        </c:if>
                        <c:if test="${book == null}">
                            Add new book
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}'/>" />
                </c:if>


            </table>
            </form>
    </div>
</body>
</html>
