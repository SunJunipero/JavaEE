<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 10.05.18
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parameters example page</title>
</head>
<body>
<h1>By GET request</h1>
<form action="paramservlet">
    Parameter 1: <input type="text" value="1" name="parameter1"/><br/>
    Parameter 2: <input type="text" value="2" name="parameter2"/><br/>
    Parameter 3: <input type="text" value="3" name="parameter3"/><br/>

    TextArea  <textarea rows="10" cols="10" name="text"></textarea><br/>

    Select <select name="select">
    <option>one</option>
    <option>two</option>
    <option>three</option>
</select><br/>

    Checkbox: <input type="checkbox" name="check">

    <input type="submit" value="send">
</form>
<br/>
<h1>By POST request</h1>
<form action="paramservlet" method="post">
    Parameter 1: <input type="text" value="1" name="parameter1"/><br/>
    Parameter 2: <input type="text" value="2" name="parameter2"/><br/>
    Parameter 3: <input type="text" value="3" name="parameter3"/><br/>

    <input type="submit" value="send">
</form>
</body>
</html>