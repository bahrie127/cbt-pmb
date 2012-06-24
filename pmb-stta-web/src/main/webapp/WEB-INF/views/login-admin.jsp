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
    <title>Computer-Based Testing PMB STTA</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>--%>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
    <style type="text/css">
        body
        {
            background-image: url("<c:url value='/resources/img/banner-bg.jpg'/>");
        }
    </style>
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">

            <a class="brand" href="./index.html">Computer-Based Testing</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="">
                        <a href="./index.html"></a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>

<div class="container" style="margin-top: 100px">

    <div class="row">

        <spring:url value='/admin/dashboard' var="submit_url"/>

        <div class="span4 offset4">

            <form  action="${submit_url}" method="GET"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓"><input name="authenticity_token" type="hidden" value="PW5uYWoLrgvxCJPrlbig8cHV5dw3bcwFLV4sE3GidIM="></div>
                <fieldset>


                    <div class="well">
                        <h3>PANEL ADMIN</h3>
                        <hr style="border-color: #ccc;">



                        <div class="control-group ">
                            <div class="controls">
                                <input id="j_username" name="j_username" type="text" class="span2"  type="text" placeholder="username"/>
                            </div>
                        </div>

                        <div class="control-group ">
                            <div class="controls">
                                <input id="j_password" name="j_password" type="password" class="span2"  type="password" placeholder="password"/>
                            </div>
                        </div>



                        <div class="form-actions" style="border: 0; background-color: #f5f5f5; margin: 30px 0 0 0; padding: 0;">
                            <button type="submit" class="btn btn-danger"><i class="icon-ok-sign icon-white"></i> Login</button>

                        </div>

                    </div>
                </fieldset>
            </form>    </div>

    </div>


    <c:if test="${not empty param.error}">
        <div class="alert alert-error">
            <strong>Login Tidak Berhasil!</strong><br/>
            Periksa kembali username dan password anda.
        </div>
    </c:if>

</div>
</body>
</html>