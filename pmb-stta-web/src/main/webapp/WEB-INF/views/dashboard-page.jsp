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

            <a class="brand" href="#">ADMIN</a>

            <div class="nav-collapse">

                <ul class="nav pull-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><sec:authentication
                                property="principal.username"/> <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="icon-user"></i>&nbsp;Account Setting</a></li>
                            <li><a href="#"><i class="icon-lock"></i>&nbsp;Change Password</a></li>

                            <li class="divider"></li>
                            <li><a href="<c:url value='/logout'/>"><i class="icon-off"></i>&nbsp;Log out</a></li>
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
<div class="span2">

    <div class="well sidebar-nav sideContent" id="sidebar">

        <ul class="nav nav-list" style="background-color: #ffffff;">

            <li>


                <div id="accordion2" class="accordion" style="text-align: left">
                    <div class="accordion-group" style="border: none">
                        <div class="accordion-heading" >
                            <a  class="badge badge-warning accordion-toggle "
                                href="<c:url value='/home'/>"
                               data-parent="#accordion2"
                               data-toggle="collapse" style="text-decoration: none" data-stack="dashboard"> <i class="icon-home icon-white"></i> Dashboard </a>
                        </div>
                    </div>
                    <div class="accordion-group batasAtas" style="border: none">
                        <div class="accordion-heading" id="accordianHeadingBarang" >
                            <a class="badge badge-inverse accordion-toggle " href="#collapseBarang" data-parent="#accordion2"
                               data-toggle="collapse" style="text-decoration: none" id="chevron1" data-stack="barang"> <i class="icon-barcode icon-white"></i> Menu
                                 </a>
                        </div>
                        <div id="collapseBarang" class="accordion-body in collapse" style="height: auto;">
                            <div class="accordion-inner bgSubmenu" style="box-shadow: 0 0 10px black inset; background-color: #ffffff;text-align: center">
                                <ul class="nav nav-tabs nav-stacked">
                                        <li><a id="accordianToggleKategori" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseKategori"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Kategori</a></li>
                                        <li><a id="accordianToggleSoal" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseSoal"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Soal</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                 </div>

            </li>
        </ul>

    </div>

    <hr>
    <!--/.well -->
</div>
<!--/span-->

<div class="span10">
    <div id="heroUnit" class="hero-unit" style="height: auto; min-height: 465px;">

        <%--start careousel--%>
        <div id="myCarousel" class="carousel" style="margin-top: 0px;">
            <!-- Carousel items -->
            <div class="carousel-inner">
                <div class="active item">
                    <img src="<c:url value='/resources/img/careousel/1.jpg'/>"/>
                </div>
                <div class="item">
                    <img src="<c:url value='/resources/img/careousel/2.jpg'/>"/>
                </div>
                <div class="item">
                    <img src="<c:url value='/resources/img/careousel/3.jpg'/>"/>
                </div>
            </div>
            <div class="row-fluid abs-report">
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Stok terjual</strong>

                    <table class="table table-bordered" style="margin-top: 3px">
                        <tr>
                            <td>
                                Hari ini :
                            </td>
                            <td>
                                ${profitThisDay.jumlahBarang}
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Bulan ini :
                            </td>
                            <td>
                                ${profitThisMonth.jumlahBarang}
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Tahun ini :
                            </td>
                            <td>
                                ${profitThisYear.jumlahBarang}
                            </td>
                        </tr>
                    </table>


                </div>
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Keuntungan Penjualan</strong>
                    <table class="table table-bordered" style="margin-top: 3px">
                        <tr>
                            <td>
                                Hari ini :
                            </td>
                            <td>
                                <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                  value="${profitThisDay.totalProfit}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Bulan ini :
                            </td>
                            <td>
                                <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                  value="${profitThisMonth.totalProfit}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Tahun ini :
                            </td>
                            <td>
                                <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                                  value="${profitThisYear.totalProfit}"/>
                            </td>
                        </tr>
                    </table>

                </div>
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Tipe paling laris ${profitThisYear.year}</strong>

                    <c:forEach items="${lakuTeratas}" var="lakuItem">

                        <table class="table table-bordered" style="margin-top: 3px">
                            <tr>
                                <td>
                                        ${lakuItem.namaMerek} ${lakuItem.namaTipe} :
                                </td>
                                <td>
                                        ${lakuItem.sumStok}
                                </td>
                            </tr>
                        </table>


                    </c:forEach>
                </div>
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Tipe paling kurang laris ${profitThisYear.year}</strong>

                    <c:forEach items="${lakuTerbawah}" var="lakuItem">
                        <table class="table table-bordered" style="margin-top: 3px">
                            <tr>
                                <td>
                                        ${lakuItem.namaMerek} ${lakuItem.namaTipe} :
                                </td>
                                <td>
                                        ${lakuItem.sumStok}
                                </td>
                            </tr>
                        </table>

                    </c:forEach>
                </div>
            </div>
            <div class="row-fluid abs-report-bottom">
                <div class="span5 height-report-bottom well">
                    as
                </div>
                <div class="span5 height-report-bottom well">
                    as
                </div>
            </div>
            <!-- Carousel nav -->
            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
        </div>
        <%--end careousel--%>

        <div id="bundleNavbar"> <!--bundle nav-->
        </div>

        <!--list-list-->
        <div id="bundleList"> <!--bundle table-->
        </div>

    </div>
    <!--/span-->
</div>
<!--/row-->

<div id="fillMyModalPlus">
</div>

<hr>

<div style="clear: both;"></div>

<div class="row" style="text-align: center">
    <p> Saiful Bahri&copy; 2012</p>
</div>

</div>
</div>

<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap-stack.js'/>"></script>


</body>
</html>