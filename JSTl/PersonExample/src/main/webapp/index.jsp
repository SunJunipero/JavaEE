<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 12.05.18
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>


Employee list:
<ul>
    <c:forEach items="${persons}" var="p">
        <li>${p.name} ${p.surname} <a href="form?delete=${p.name}">Удалить</a></li>
    </c:forEach>
</ul>



<form action="form" method="POST">
    Имя: <input type="text" name="name"> <br/>
    Фамилия: <input type="text" name="surname"> <br/>
    <input type="submit" name="submit"/>
</form>
</body>
</html>