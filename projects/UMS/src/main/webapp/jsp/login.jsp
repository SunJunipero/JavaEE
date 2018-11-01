<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<c:url value="/j_spring_security_check"/>" method="post">
        <table>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="j_username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="j_password"></td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit" value="login" />
                </td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="reset" type="reset" value="Reset"/>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
