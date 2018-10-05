<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 05.10.18
  Time: 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Song</title>
</head>
<body>
    <form action="rest/service/add" method="post">
        <p>
            Name : <input type="text" name="name"/>
        </p>
        <p>
            Duration : <input type="text" name="duration"/>
        </p>
        <input type="submit" value="add song"/>
    </form>
</body>
</html>
