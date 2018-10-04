
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JAX-RS_1</title>
</head>
<body>
    <form action="rest/service/add" method="post">
        <p>
            Name : <input type="text" name="name"/>
        </p>
        <p>
            Age : <input type="text" name="age"/>
        </p>
        <input type="submit" value="add person"/>
    </form>
</body>
</html>
