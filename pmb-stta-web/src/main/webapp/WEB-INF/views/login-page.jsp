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
    <title>Flatout Store</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>--%>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
    <style type="text/css">
        body
        {
            background-image: url("<c:url value='/resources/img/aaaaa.jpg'/>");
        }
    </style>
</head>
<body>
<div class="container" >

    <spring:url value='/login' var="submit_url"/>

    <div class="span4" id="panel">
        <form class="form-horizontal" action="${submit_url}" method="POST">

                <img src="<c:url value='/resources/img/logoflat.png'/>" style="width: 300px;height: 50px;margin-bottom: 17px;margin-top: -17px" />
                <br/>
                <div class="control-group">
                    <h2 style="position: absolute;margin-left: 20px;color: #ffffff;">
                        A d m i n <br/>P a n e l
                    </h2>
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span>
                            <input id="j_username" name="j_username" type="text" class="span2"  type="text" placeholder="username"/>
                        </div>
                    </div>
                </div>

                <div class="control-group">

                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-lock"></i></span>
                            <input id="j_password" name="j_password" type="password" class="span2"  type="password" placeholder="password"/>
                        </div>
                    </div>
                </div>
            <hr>

                <div class="pull-right">

                    <button type="submit" class="btn btn-danger"><i class="icon-ok-sign"></i> Login</button>
                    <button class="btn"><i class="icon-remove-sign"></i> Cancel</button>
                </div>
        </form>


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