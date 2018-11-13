<%--
  Created by IntelliJ IDEA.
  User: kostya
  Date: 12.11.18
  Time: 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grid</title>
    <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/extjs/3.4.1-1/resources/css/ext-all.css">-->
    <link rel="stylesheet" href="../resources/css/grid-examples.css">
    <link rel="stylesheet" href="../resources/css/examples.css">
    <link rel="stylesheet" href="../resources/css/ext-all.css">

    <style type=text/css>
        .x-grid3-row-over .x-grid3-cell-inner {
            font-weight: bold;
        }

        .x-action-col-cell img.buy-col {
            height: 16px;
            width: 16px;
            background-image: url(../resources/icons/fam/accept.png);
        }

        .x-action-col-cell img.alert-col {
            height: 16px;
            width: 16px;
            background-image: url(../resources/icons/fam/error.png);
        }

    </style>

    <!--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/extjs/3.4.1-1/ext-all.js"></script>-->
    <!--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/extjs/3.4.1-1/adapter/ext/ext-base.js"></script>-->
    <script type="text/javascript" src="../resources/js/ext-base.js"></script>

    <!-- ExtJS library: all widgets -->
    <script type="text/javascript" src="../resources/js/ext-all.js"></script>

    <!-- page specific -->
    <script type="text/javascript" src="array-grid.js"></script>
    <title>Title</title>
</head>
<body>
<div id="grid-example"></div>
</body>
</html>
