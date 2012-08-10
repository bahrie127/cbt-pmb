<%--
  Created by IntelliJ IDEA.
  User: bahrie
  Date: 3/15/12
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Computer Based Test PMB STTA</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/validationEngine.jquery.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>--%>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.validationEngine-en.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.validationEngine.js'/>"></script>
    <style type="text/css">
        body {
            background-image: url("<c:url value='/resources/img/banner-bg.jpg'/>");
        }
    </style>

    <script type="text/javascript">
        jQuery(document).ready(function () {
// binds form submission and fields to the validation engine
            jQuery("#formLoginPeserta").validationEngine();
        });
    </script>
</head>
<body>

${isi}<br/>
${nama}

</body>
</html>
