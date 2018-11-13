<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<head>
    <script type="text/javascript">
        function edition() {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "projects1/edit/${p.project_id}", true);
            xhr.onreadystatechange = function (e) {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        console.log(xhr.responseText);
                        console.log(xhr.responseText);
                        document.getElementById('input_name').innerText = xhr.responseText;
                    } else {
                        console.error(xhr.statusText);
                    }
                }
            };
            xhr.onerror = function (e) {
                console.error(xhr.statusText);
            };
            xhr.send(null);
        }
    </script>
</head>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${projects}" var="p">
        <tr>
            <td><c:out value="${p.title}"/></td>
            <td><a href="projects1/edit/${p.project_id}" onclick="edition()">Edit</a>&nbsp;<a href="projects1/delete/${p.project_id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>
<br>

<form:form  modelAttribute="project" method="POST" >
    <form:hidden path="project_id"/>

    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="title" id="input_name"/></td>
            <td><form:errors path="title"/></td>

        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="submit"></td>
            <td></td>
        </tr>

    </table>


</form:form>