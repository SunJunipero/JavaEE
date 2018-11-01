
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
       <tr>
           <td>Name</td>
           <td>Email</td>
           <td>Actions</td>
       </tr>
        <c:forEach items="${users}" var="u">
       <tr>
               <td><c:out value="${u.user_name}"/></td>
               <td><c:out value="${u.email}"/></td>
               <td><a href="/users/${u.user_id}.html">View</a> </td>
       </tr>
        </c:forEach>
    </table>

</body>
</html>
