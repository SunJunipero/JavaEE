<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 25.10.18
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Country and cities</title>
    
    <script type="text/javascript">
        function getXmlhtpp() {
            var xmlhttp;
            try {
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP")
            } catch (e) {
                try {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP")
                } catch (E) {
                    xmlhttp = false;
                }
            }
            if(!xmlhttp && typeof XMLHttpRequest != 'undefined'){
                xmlhttp = new XMLHttpRequest();
            }
            return xmlhttp;
        }

        function getCities(select) {
            var country = select.options[select.selectedIndex].value;
            var xmlhttp = getXmlhtpp();
            xmlhttp.open('GET', '/cities?country=' + country, false);
            xmlhttp.send(null);
            if(xmlhttp.status == 200) {
                var cities = xmlhttp.responseText.split('|');
                var options = '';
                for (var i=0; i < cities.length; i++){
                    options += '<option>' + cities[i] + '</option>';
                }
                document.getElementById('sitySelect').innerHTML = options;
            }


        }
    </script>
</head>
<body>
    Select current country
    <select onchange="getCities(this)">
        <c:forEach items="${countries}" var="c">
            <option value="${c}">${c}</option>
        </c:forEach>
    </select>
    <select id="sitySelect"></select>
</body>
</html>
