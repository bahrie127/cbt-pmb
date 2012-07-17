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
            background: #808080
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

            <div class="nav-collapse">
                <ul class="nav pull-right">

                    <li class="divider-vertical"></li>
                </ul>

            </div>
        </div>
    </div>
</div>

<div class="container well">

    <h2 class="row" style="text-align: center">Hasil CBT dari Nomor Pendaftaran : ${noPendaftaran} dengan Nama :${nama}</h2>

    <h2 class="row" style="text-align: center">Persentase kebenaran soal Verbal : ${verbal} %</h2>

    <h2 class="row" style="text-align: center">Persentase kebenaran soal Numerik : ${numerik} %</h2>

    <h2 class="row" style="text-align: center">Persentase kebenaran soal Logika : ${logika} %</h2>

    <h2 class="row" style="text-align: center">Persentase kebenaran soal Gambar : ${gambar} %</h2>

   <h2 class="row" style="text-align: center">Nilai rata-rata anda adalah : ${hasil} %</h2>

    <div style="clear: both;"></div>

    <br/><br/><br/><br/>

    <div class="row" style="text-align: center">
        <p> Saiful Bahri &copy; 2012</p>
    </div>

</div>
</div>

<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap-stack.js'/>"></script>


</body>
</html>