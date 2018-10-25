
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
        
        function helloAjax() {
            var xmlhttp = getXmlhtpp();
            xmlhttp.open('GET', '/helloajax', false);
            xmlhttp.send(null);
            if(xmlhttp.status == 200)
                alert(xmlhttp.responseText)
        }

        function sum() {
            var xmlhttp = getXmlhtpp();
            var val1 = document.getElementById('val1').value;
            var val2 = document.getElementById('val2').value;
            // xmlhttp.open('GET','/sum?val1=' + val1 + '&val2=' + val2, false);
            xmlhttp.open('GET','/oldsum?val1=' + val1 + '&val2=' + val2, false);
            xmlhttp.send(null);
            if(xmlhttp.status == 200){
                document.getElementById('val3').innerText = xmlhttp.responseText;
            }
            else {
                alert('Error + ' + xmlhttp.responseText);
            }
        }


    </script>
</head>
<body>

    <a href="" onclick="helloAjax()">Say hello</a><br>
    <input type="text" id="val1"> +
    <input type="text" id="val2">
    <input type="button" value="=" onclick="sum()">
    <span id="val3"></span>


</body>
</html>
