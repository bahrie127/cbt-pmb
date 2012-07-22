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
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ADMIN CBT</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>"/>

    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
            background-image: url('<c:url value='/resources/img/banner-bg.jpg'/>');
        }

        .sidebar-nav {
            padding: 9px 0;
        }

    </style>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/uploadify/uploadify.css'/>" media="all" />--%>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/validationEngine.jquery.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap-responsive.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap-stack.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/jquery.ui.all.css'/>"/>

    <script src="<c:url value='/resources/js/jquery.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/uploadify/swfobject.js'/>"></script>
    <script type="text/javascript"
            src="<c:url value='/resources/js/uploadify/jquery.uploadify.v2.1.4.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.validationEngine-en.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.validationEngine.js'/>"></script>

    <script src="<c:url value='/resources/js/highcharts.js'/>"></script>
    <script src="<c:url value='/resources/js/exporting.js'/>"></script>

   
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">

            <a class="brand" href="#">ADMIN</a>

            <div class="nav-collapse">

                <ul class="nav pull-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><sec:authentication
                                property="principal.username"/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value="/logout" />"><i class="icon-off"></i>&nbsp;Log out</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
        <h2 align="center">HASIL COMPUTER BASED TEST</h2>
            <div align="center">
            <table class="table table-bordered" style="
            font-size: 16px;
    width: 529px;
">
                <tr>
                    <td>Nomor Pendaftaran</td>
                    <td>${nomor}</td>
                </tr>
                <tr>
                    <td>Nama</td>
                    <td>${nama}</td>
                </tr>
                <tr>
                    <td>Pilihan Pertama</td>
                    <td>${pilihanPertama}</td>
                </tr>
                <tr>
                    <td>Pilihan Kedua</td>
                    <td>${pilihanKedua}</td>
                </tr>
                <tr>
                    <td>benar verbal</td>
                    <td>${verbal} %</td>
                </tr>
                <tr>
                    <td>Benar Numerik</td>
                    <td>${numerik} %</td>
                </tr>
                <tr>
                    <td>Benar Logika</td>
                    <td>${logika} %</td>
                </tr>
                <tr>
                    <td>Benar Gambar</td>
                    <td>${gambar} %</td>
                </tr>
                <tr>
                    <td>Nilai Akhir</td>
                    <td>${nilaiAkhir}</td>
                </tr>
            </table>
            <h3 align="center">Grade Lulus</h3>
            
            <table class="table table-bordered" style="
    font-size: 16px;
    width: 529px;
">
                <thead>
                <tr>
                    <th>Bidang</th>
                    <th>Grade ${pilihanPertama}</th>
                    <th>Grade ${pilihanKedua}</th>
                </tr>

                </thead>
                <tr>
                    <td>VERBAL</td>
                    <td>${gradeVerbal1}</td>
                    <td>${gradeVerbal2}</td>
                </tr>
                <tr>
                    <td>NUMERIK</td>
                    <td>${gradeNumerik1}</td>
                    <td>${gradeNumerik2}</td>
                </tr>
                <tr>
                    <td>LOGIKA</td>
                    <td>${gradeLogika1}</td>
                    <td>${gradeLogika2}</td>
                </tr>
                <tr>
                    <td>GAMBAR</td>
                    <td>${gradeGambar1}</td>
                    <td>${gradeGambar2}</td>
                </tr>
            </table>
            </div>

        </div>
        <!--/row-->

        <div id="fillMyModalPlus">
        </div>

        <hr>

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