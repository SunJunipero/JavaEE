<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<h2>Song Information</h2>
<form:form method = "POST" action = "/addSong">
    <table>
        <tr>
            <td><form:label path = "title">Name</form:label></td>
            <td><form:input path = "title" /></td>
        </tr>
        <tr>
            <td><form:label path = "artist">Artist</form:label></td>
            <td><form:input path = "artist" /></td>
        </tr>
        <tr>
            <td><form:label path = "id">id</form:label></td>
            <td><form:input path = "id" /></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>

</html>