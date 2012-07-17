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

    <script type="text/javascript">
        $(document).ready(function () {
            $('#upload').click(function () {
                $('#uploadify').uploadifyUpload();
                return false;
            });
            $('#uploadify').uploadify({
                'uploader':'<c:url value='/resources/js/uploadify/uploadify.swf'/>',
                //'script': '<c:url value='/resources/js/uploadify/uploadify.swf'/>/springSourcery/app/secured/uploadPictures.html;jsessionid=${sessionId}',
                'multi':true,
                'auto':true,
                'fileDesc':'Excel Files (*.xls)',
                'fileExt':'*.xls;',
                'cancelImg':'<c:url value='/resources/js/uploadify/cancel.png'/>'
            });
        });
    </script>
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
                                property="principal.username"/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <%--<li><a href="#"><i class="icon-user"></i>&nbsp;Account Setting</a></li>--%>
                            <%--<li><a href="#"><i class="icon-lock"></i>&nbsp;Change Password</a></li>--%>

                            <%--<li class="divider"></li>--%>
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
<div class="span2">


    <div class="well sidebar-nav">

        <ul class="nav nav-list">

            <li>


                <div id="accordion2" class="accordion" style="text-align: left">
                    <%--<div class="accordion-group" style="border: none">--%>
                    <%--<div class="accordion-heading" >--%>
                    <%--<a  class="btn accordion-toggle "--%>
                    <%--href="<c:url value='/home'/>"--%>
                    <%--data-parent="#accordion2"--%>
                    <%--data-toggle="collapse" style="text-decoration: none;text-align: left;" data-stack="dashboard"> <i class="icon-home icon-white"></i> Dashboard </a>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <div class="accordion-group batasAtas" style="border: none">
                        <div class="accordion-heading" id="accordianHeadingBarang">
                            <a class="btn accordion-toggle btn-danger " href="#collapseBarang" data-parent="#accordion2"
                               data-toggle="collapse" style="text-decoration: none;text-align: left" id="chevron1"
                               data-stack="barang"> <i class="icon-barcode icon-white"></i> Menu
                            </a>
                        </div>
                        <div id="collapseBarang" class="accordion-body collapse in" style="height: auto;">
                            <div class="accordion-inner bgSubmenu"
                                 style=" background-color: #ffffff;text-align: center">
                                <ul class="nav nav-tabs nav-stacked">
                                    <%--<li><a id="accordianToggleKategori" class="accordion-toggle "--%>
                                           <%--href="#collapseKategori"--%>
                                           <%--data-parent="#accordion2"--%>
                                           <%--data-toggle="collapse">Kategori</a></li>--%>
                                    <li><a id="accordianToggleSoal" class=" accordion-toggle "
                                           href="#collapseSoal"
                                           data-parent="#accordion2"
                                           data-toggle="collapse">Soal</a></li>
                                    <%--<li><a id="accordianToggleUploadSoal" class=" accordion-toggle "--%>
                                    <%--href="#collapseUploadSoal"--%>
                                    <%--data-parent="#accordion2"--%>
                                    <%--data-toggle="collapse">Upload Soal</a></li>--%>

                                    <li><a id="accordianToggleHasil" class=" accordion-toggle "
                                           href="#collapseHasil"
                                           data-parent="#accordion2"
                                           data-toggle="collapse">Hasil Ujian</a></li>
                                    <li><a id="accordianToggleSetting" class=" accordion-toggle "
                                           href="#collapseSetting"
                                           data-parent="#accordion2"
                                           data-toggle="collapse">Setting Soal</a></li>
                                        <li><a id="accordianToggleGrade" class="accordion-toggle "
                                               href="#collapseGrade"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Setting Grade</a></li>
                                    <li><a id="accordianToggleUser" class=" accordion-toggle "
                                           href="#collapseUser"
                                           data-parent="#accordion2"
                                           data-toggle="collapse">Operator</a></li>
                                        <li><a id="accordianToggleStatistik" class=" accordion-toggle "
                                               href="#collapseStatistik"
                                               data-parent="#accordion2"
                                               data-toggle="collapse">Statistik</a></li>
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
        <div id="myCarousel" class="carousel" style="margin-top: 0px;">
            <div class="row-fluid abs-report">
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Soal</strong>

                    <table class="table table-bordered" style="margin-top: 15px">
                        <tr>
                            <td>
                                Jumlah Soal :
                            </td>
                            <td>
                                ${jumlahSoal}
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Jumlah Kategori :
                            </td>
                            <td>
                                ${jumlahKategori}
                            </td>

                        </tr>
                    </table>


                </div>
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Ujian</strong>
                    <table class="table table-bordered" style="margin-top: 15px">
                        <tr>
                            <td>
                                Jumlah Ujian :
                            </td>
                            <td>
                              ${jumlahUjian}
                            </td>
                        </tr>

                    </table>

                </div>
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Admin</strong>
                    <table class="table table-bordered" style="margin-top: 15px">
                        <tr>
                            <td>
                                Jumlah Admin :
                            </td>
                            <td>
                              ${jumlahAdmin}
                            </td>
                        </tr>

                    </table>
                </div>
                <div class="alert alert-success span2 height-report" style="width:191px;text-align: center">
                    <strong>Setting</strong>

                    <table class="table table-bordered" style="margin-top: 15px">
                        <tr>
                            <td>
                                Soal ditampilkan :
                            </td>
                            <td>
                                ${jumlahSoalDitampilkan}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Waktu pengerjaan :
                            </td>
                            <td>
                                ${waktuPengerjaan} jam
                            </td>
                        </tr>

                    </table>
                </div>

            </div>

        </div>
        <div id="bundleNavbar"> <!--bundle nav-->
        </div>

        <!--list-list-->
        <div id="bundleList"> <!--bundle table-->



        </div>
        <div id="list2"></div>
        

    </div>
    <!--/span-->
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