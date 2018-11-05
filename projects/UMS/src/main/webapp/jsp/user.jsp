
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/users/delete">
        <table>
            <tr>
                <td>ID</td>
                <td>${user.user_id}</td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>${user.user_first_name}</td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>${user.user_last_name}</td>
            </tr>
            <tr>
                <td>User Name</td>
                <td>${user.user_name}</td>
            </tr>
            <tr>
                <td>Password</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td>${user.birthday}</td>
            </tr>
            <tr>
                <td>Is active</td>
                <td>${user.is_active}</td>
            </tr>
            <tr>
                <td>Created</td>
                <td>${user.created_stamp}</td>
            </tr>
            <tr>
                <td>Updated</td>
                <td>${user.last_updated_stamp}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${user.address}</td>
            </tr>
        </table>
    </form>
    <a href=/admin>back to admin page</a>

</body>
</html>
