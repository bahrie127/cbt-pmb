<%--
  Created by IntelliJ IDEA.
  User: bahrie
  Date: 3/15/12
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>CBT-STTA</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>"/>

    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
            background-image: linear-gradient(bottom, rgb(166,133,49) 6%, rgb(214,214,214) 42%, rgb(38,189,189) 84%);
            background-image: -o-linear-gradient(bottom, rgb(166,133,49) 6%, rgb(214,214,214) 42%, rgb(38,189,189) 84%);
            background-image: -moz-linear-gradient(bottom, rgb(166,133,49) 6%, rgb(214,214,214) 42%, rgb(38,189,189) 84%);
            background-image: -webkit-linear-gradient(bottom, rgb(166,133,49) 6%, rgb(214,214,214) 42%, rgb(38,189,189) 84%);
            background-image: -ms-linear-gradient(bottom, rgb(166,133,49) 6%, rgb(214,214,214) 42%, rgb(38,189,189) 84%);

            background-image: -webkit-gradient(
                linear,
                left bottom,
                left top,
                color-stop(0.06, rgb(166,133,49)),
                color-stop(0.42, rgb(214,214,214)),
                color-stop(0.84, rgb(38,189,189))
            );
        }

        .sidebar-nav {
            padding: 9px 0;
        }

    </style>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap-responsive.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap-stack.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/jquery.ui.all.css'/>"/>
    <script src="<c:url value='/resources/js/jquery.js'/>"></script>
    <script src="<c:url value='/resources/js/highcharts.js'/>"></script>
    <script src="<c:url value='/resources/js/exporting.js'/>"></script>
</head>
<%--ondoel--%>
<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">

            <a class="brand" href="#">CBT STT ADISUTJIPTO YOGYAKARTA</a>

            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <c:url value="/soal" var="soal_url"/>
    <c:set var="nomor" value="0" scope="page" />

<div class="span12">
    <form:form id="formInputUjian" class="modal-form" action="${soal_url}" method="POST"
               modelAttribute="ujian">
           <c:forEach items="${listSoal}" var="soalItem">
               <c:set var="nomor" value="${nomor + 1}" scope="page"/>

              ${nomor}<div>${soalItem.pertanyaan}</div><br/>

               A<form:radiobutton path="" name="jawaban${nomor}" value="${soalItem.jawabans[0].id}" label="${soalItem.jawabans[0].pilihan}"/><br/>
               B<form:radiobutton path="" name="jawaban${nomor}" value="${soalItem.jawabans[1].id}" label="${soalItem.jawabans[1].pilihan}"/><br/>
               C<form:radiobutton path="" name="jawaban${nomor}" value="${soalItem.jawabans[2].id}" label="${soalItem.jawabans[2].pilihan}"/><br/>
               D<form:radiobutton path="" name="jawaban${nomor}" value="${soalItem.jawabans[3].id}" label="${soalItem.jawabans[3].pilihan}"/><br/>
           </c:forEach>
    </form:form>
</div>



<div style="clear: both;"></div>

<div class="row" style="text-align: center">
    <p> Saiful Bahri &copy; 2012</p>
</div>

</div>
</div>

<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap-stack.js'/>"></script>


</body>
</html>