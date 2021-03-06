<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>

<c:if test="${not empty error}">
    <div style="color: red;">
        Login failed, try again.
    </div>
</c:if>

<form action="<c:url value='j_spring_security_check'/>" method='POST'>

    <table>
        <tr>
            <td>Login:</td>
            <td><input type='text' title='j_username' value=''>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' title='j_password' />
            </td>
        </tr>
        <tr>
            <td colspan='2'>
                <input title="submit" type="submit" value="login" />
            </td>
        </tr>
        <tr>
            <td colspan='2'>
                <input title="reset" type="reset" value="Reset"/>
            </td>
        </tr>
    </table>

</form>

</body>
</html>