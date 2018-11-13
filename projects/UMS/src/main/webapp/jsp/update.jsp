<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h2>Update page</h2>
    <form:form modelAttribute="user" method="POST" action="/updateuser" >
        <form:hidden path="user_id"/>

        <table>
            <tr>
                <td>First title:</td>
                <td><form:input path="user_first_name"/></td>
                <td><form:errors path="user_first_name"/></td>
            </tr>
            <tr>
                <td>Last title:</td>
                <td><form:input path="user_last_name"/></td>
                <td><form:errors path="user_last_name"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="user_name"/></td>
                <td><form:errors path="user_name"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password"/></td>
                <td><form:errors path="password"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email"/></td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td><form:input type="date" path="birthday" value="${user.birthday}" pattern="yyyy-mm-dd"/></td>
                <td><form:errors type="date" path="birthday" value="${user.birthday}" pattern="yyyy-mm-dd"/></td>
            </tr>
            <tr>
                <td>Activate:</td>
                <td><form:checkbox path="is_active"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address"/></td>
                <td><form:errors path="address"/></td>
            </tr>

            <tr>
                <td></td>
                <td align="right"><input type="submit" value="submit"></td>
                <td></td>
            </tr>
        </table>
    </form:form>
    <a href=/admin>back to admin page</a>
</body>
</html>
