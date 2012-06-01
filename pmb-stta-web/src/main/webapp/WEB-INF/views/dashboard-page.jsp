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
    <title>Flatout Store</title>
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

            <a class="brand" href="<c:url value='/home'/>"><img class="logo-banner"
                                                                src="<c:url value='/resources/img/logoflat.png'/>"
                                                                alt=""></a>

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
    <%--<div class="row">--%>
        <%--<div class="span1">--%>
            <%--<div class="bundle-img">--%>
                <%--<img src="<c:url value='/resources/img/80x60.gif'/>" alt="" width="80" height="60">--%>
            <%--</div>--%>

        <%--</div>--%>
        <%--<div class="span1">--%>
            <%--<p style="color: #ffffff;"><sec:authentication property="principal.username"/></p>--%>
            <%--<h6 class="adm">Administrator</h6>--%>

        <%--</div>--%>

    <%--</div>--%>
    <%--<hr>--%>

    <div class="well sidebar-nav sideContent" id="sidebar">

        <ul class="nav nav-list" style="background-color: #ffffff;">
            <!--<li class="nav-header">Menu</li>-->

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
                               data-toggle="collapse" style="text-decoration: none" id="chevron1" data-stack="barang"> <i class="icon-barcode icon-white"></i> Barang
                                 </a>
                        </div>
                        <div id="collapseBarang" class="accordion-body in collapse" style="height: auto;">
                            <div class="accordion-inner bgSubmenu" style="box-shadow: 0 0 10px black inset; background-color: #ffffff;text-align: center">
                                <ul class="nav nav-tabs nav-stacked">
                                    <sec:authorize access="hasAnyRole('MEREK_R','ADMIN_IT')">
                                        <li><a id="accordianToggleMerek" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseMerek"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Merek</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('TIPE_R','ADMIN_IT')">
                                        <li><a id="accordianToggleTipe" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseTipe"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Tipe</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('WARNA_R','ADMIN_IT')">
                                        <li><a id="accordianToggleWarna" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseWarna"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Warna</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('UKURAN_R','ADMIN_IT')">
                                        <li><a id="accordianToggleUkuran" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseUkuran"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Ukuran</a></li>
                                    </sec:authorize>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="accordion-group" style="border: none">

                        <sec:authorize access="hasAnyRole('DISTRIBUTOR_R','ADMIN_IT')">
                            <div class="accordion-heading" id="accordianHeadingDistributor">
                                <a id="accordianToggleDistributor" class="badge badge-inverse accordion-toggle "
                                   href="#"
                                   data-parent="#accordion2"
                                   data-toggle="collapse" style="text-decoration: none" data-stack="distributor"> <i class="icon-user icon-white"></i> Distributor </a>
                            </div>
                        </sec:authorize>
                    </div>
                    <div class="accordion-group" style="border: none">
                        <sec:authorize access="hasAnyRole('PELANGGAN_R','ADMIN_IT')">
                            <div class="accordion-heading" id="accordianHeadingPelanggan">
                                <a id="accordianTogglePelanggan" class="badge badge-inverse accordion-toggle "
                                   href="#"
                                   data-parent="#accordion2"
                                   data-toggle="collapse" style="text-decoration: none" data-stack="pelanggan"> <i class="icon-user icon-white"></i> Pelanggan </a>
                            </div>
                        </sec:authorize>
                    </div>

                    <div class="accordion-group" style="border: none">
                        <sec:authorize access="hasAnyRole('DEPOSIT_R','ADMIN_IT')">
                            <div class="accordion-heading" id="accordianHeadingDeposit">
                                <a id="accordianToggleDeposit" class="badge badge-inverse accordion-toggle "
                                   href="#collapseDeposit"
                                   data-parent="#accordion2"
                                   data-toggle="collapse" style="text-decoration: none" data-stack="deposit"> <i class="icon-plus-sign icon-white"></i> Deposit  </a>
                            </div>
                        </sec:authorize>


                        <div id="collapseDeposit" class="accordion-body collapse" style="height: 0px;">
                            <div class="accordion-inner bgSubmenu" style="box-shadow: 0 0 10px black inset; background-color: #ffffff;text-align: center">
                                <ul class="nav nav-tabs nav-stacked">
                                    <sec:authorize access="hasAnyRole('CASH_R','ADMIN_IT')">
                                        <li><a id="accordianToggleCash" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseCash"
                                               data-parent="#accordion2" data-toggle="collapse">Cash</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('BANK_R','ADMIN_IT')">
                                        <li><a id="accordianToggleBank" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseBank"
                                               data-parent="#accordion2" data-toggle="collapse">Bank</a></li>
                                    </sec:authorize>
                                </ul>

                            </div>
                        </div>
                    </div>
                    <div class="accordion-group" style="border: none">

                        <sec:authorize access="hasAnyRole('TRANSAKSI_R','ADMIN_IT')">
                            <div class="accordion-heading" id="accordianHeadingTransaksi">
                                <a id="accordianToggleTransaksi" class="badge badge-inverse accordion-toggle "
                                   href="#collapseTransaksi"
                                   data-parent="#accordion2"
                                   data-toggle="collapse" style="text-decoration: none" data-stack="transaksi"> <i class="icon-shopping-cart icon-white"></i> Transaksi  </a>
                            </div>
                        </sec:authorize>

                        <div id="collapseTransaksi" class="accordion-body collapse" style="height: 0px;">
                            <div class="accordion-inner bgSubmenu" style="box-shadow: 0 0 10px black inset; background-color: #ffffff;text-align: center">
                                <ul class="nav nav-tabs nav-stacked">
                                    <sec:authorize access="hasAnyRole('PEMBELIAN_R','ADMIN_IT')">
                                        <li><a id="accordianTogglePembelian" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapsePembelian"
                                               data-parent="#accordion2" data-toggle="collapse">Pembelian</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('PENJUALAN_R','ADMIN_IT')">
                                        <li><a id="accordianTogglePenjualan" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapsePenjualan"
                                               data-parent="#accordion2" data-toggle="collapse">Penjualan</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('ONGKOS_KIRIM_R','ADMIN_IT')">
                                        <li><a id="accordianToggleOngkosKirim" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseOngkosKirim"
                                               data-parent="#accordion2" data-toggle="collapse">Ongkos Kirim</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('KATEGORI_R','ADMIN_IT')">
                                        <li><a id="accordianToggleKategori" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseKategori"
                                               data-parent="#accordion2" data-toggle="collapse">Kategori</a></li>
                                    </sec:authorize>
                                </ul>

                            </div>
                        </div>
                    </div>
                    <div class="accordion-group" style="border: none">

                        <sec:authorize access="hasAnyRole('REPORT_R','ADMIN_IT')">
                            <div class="accordion-heading" id="accordianHeadingLaporan">
                                <a class="badge badge-inverse accordion-toggle " href="#" data-parent="#accordion2"
                                   data-toggle="collapse" style="text-decoration: none" data-stack="laporan"> <i class="icon-file icon-white"></i> Laporan </a>
                            </div>
                        </sec:authorize>

                    </div>
                    <div class="accordion-group" style="border: none">
                        <div class="accordion-heading" id="accordianHeadingSetting">
                            <a class="badge badge-inverse accordion-toggle " href="#collapseSetting" data-parent="#accordion2"
                               data-toggle="collapse" style="text-decoration: none" data-stack="setting"> <i class="icon-cog icon-white"></i> Setting  </a>
                        </div>
                        <div id="collapseSetting" class="accordion-body collapse" style="height: 0px;">
                            <div class="accordion-inner bgSubmenu" style="box-shadow: 0 0 10px black inset; background-color: #ffffff;text-align: center">
                                <ul class="nav nav-tabs nav-stacked">
                                    <sec:authorize access="hasAnyRole('DISKON_R','ADMIN_IT')">
                                        <li><a id="accordianToggleDiskon" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseDiskon"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Diskon</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('USER_R','ADMIN_IT')">
                                        <li><a id="accordianToggleUser" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseUser"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">User</a></li>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('ROLE_GROUP_R','ADMIN_IT')">
                                        <li><a id="accordianToggleRoleGroup" class="badge-inverse accordion-toggle warnaFontSubmenu"
                                               href="#collapseRoleGroup"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Role Group</a></li>
                                    </sec:authorize>
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
    <p> 2ndStack&copy; 2012</p>
</div>

</div>
</div>

<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap-stack.js'/>"></script>


</body>
</html>