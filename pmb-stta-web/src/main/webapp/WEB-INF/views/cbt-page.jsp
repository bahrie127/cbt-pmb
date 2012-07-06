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

            <div class="nav-collapse collapse">
                <ul class="nav pull-right">
                    <li>
                        <a href="" >
                            <script language="JavaScript" src="<c:url value='/resources/js/countdown.js'/>"></script>
                        </a>

                    </li>
                    <li class="">
                        <a href="${url_hasil}" id="autoklik">
                            <button class="badge badge-error" >SELESAI</button>
                        </a>

                    </li>
                </ul>
                <%--<ul class="nav pull-right">--%>

                    <%--<li class="divider-vertical"></li>--%>
                    <%--<li class="dropdown open">--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown"> </a>--%>
                        <%--<ul class="dropdown-menu">--%>
                            <%--<li><a href="#">Jumlah Soal : 50 soal</a></li>--%>
                            <%--<li><a href="#">Waktu : 120 menit</a></li>--%>
                            <%--<li><a href="#">Mulai : 15:00:00</a></li>--%>
                            <%--<li><a href="#">Selesai : 15:00:00</a></li>--%>
                            <%--<li class="divider"></li>--%>
                            <%--<li><a href="#">Sisa : 15:00:00</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>

            </div>
        </div>
    </div>
</div>

<div class="container well">

    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">  NAMA: ${namaPeserta}</a>
                <div class="nav-collapse">

                    <ul class="nav pull-right">
                        <li>
                            <a href="#" style="font-size: 15px"> ${tanggal}</a>

                        </li>
                    </ul>



                </div><!-- /.nav-collapse -->
            </div>
        </div><!-- /navbar-inner -->
    </div>

    <div class="row">
        <div class="pagination pagination-centered ">
            <ul class="btn-group">
                <%--<li  class="active" onclick="toPage('${url}',1)">--%>
                    <%--<button style="cursor: pointer" class="btn">1</button>--%>
                <%--</li>--%>
                <%--<li  class="active" onclick="toPage('${url}',2)">--%>
                    <%--<button style="cursor: pointer" class="btn">2</button>--%>
                <%--</li>--%>
                <%--<li  class="active" onclick="toPage('${url}',3)">--%>
                    <%--<button style="cursor: pointer" class="btn">3</button>--%>
                <%--</li>--%>
                <%--<li  class="active" onclick="toPage('${url}',4)">--%>
                    <%--<button style="cursor: pointer" class="btn">4</button>--%>
                <%--</li>--%>
                <%--<li  class="active" onclick="toPage('${url}',5)">--%>
                    <%--<button style="cursor: pointer" class="btn">5</button>--%>

                <%--</li>--%>

                    <c:forEach var="i" begin="1" step="1" end="${countPage}">
                        <li class="active" onclick="toPage('${url}',${i})">
                            <button style="cursor: pointer" class="btn">${i}</button>
                        </li>
                    </c:forEach>

            </ul>
        </div>
    </div>


    <c:url value="/ujian/jawab" var="jawab_url"/>

    <c:set var="nomor" value="${nomor}" scope="page"/>

    <div class="row-fluid" id="bundleList">

        <form:form id="formInputUjian" class="modal-form form-horizontal" action="${soal_url}" method="POST"
                   modelAttribute="ujian">


            <ul class="nav">
                <c:forEach items="${listSoal}" var="soalItem">
                    <c:set var="pengerjaanSoalId" value="${ujian.pengerjaanSoalList[nomor].id}"/>
                    <c:set var="terjawabId" value="${ujian.pengerjaanSoalList[nomor].jawaban.id}"/>
                    <c:set var="nomor" value="${nomor + 1}"/>

                    <li>
                    ${soalItem.nomor}. ${soalItem.pertanyaan}<br/>
                        <ul class="nav">
                            <li>
                                <ul class="nav nav-pills" style="margin-left: 15px">
                                    <li>
                                        <c:set var="cek" value=""/>
                                        <c:if test="${soalItem.jawabans[0].id==terjawabId}"><c:set var="cek"
                                                                                                   value="checked"/>
                                        </c:if>
                                        <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                          value="${soalItem.jawabans[0].id}" label=""
                                                          onclick="jawab('${jawab_url}','${ujian.id}','${ujian.calonMahasiswa.id}','${pengerjaanSoalId}','${soalItem.id}','${soalItem.jawabans[0].id}')"/>

                                    </li>
                                    <li>
                                        &nbsp;

                                        A &nbsp;
                                    </li>
                                    <li>
                                            ${soalItem.jawabans[0].pilihan}
                                    </li>
                                </ul>
                            </li>
                            <li>

                                <ul class="nav nav-pills" style="margin-left: 15px">
                                    <li>
                                        <c:set var="cek" value=""/>
                                        <c:if test="${soalItem.jawabans[1].id==terjawabId}"><c:set var="cek"
                                                                                                   value="checked"/>
                                        </c:if>
                                        <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                          value="${soalItem.jawabans[1].id}" label=""
                                                          onclick="jawab('${jawab_url}','${ujian.id}','${ujian.calonMahasiswa.id}','${pengerjaanSoalId}','${soalItem.id}','${soalItem.jawabans[1].id}')"/>

                                    </li>
                                    <li>
                                        &nbsp;

                                        B &nbsp;
                                    </li>

                                    <li>
                                            ${soalItem.jawabans[1].pilihan}
                                    </li>
                                </ul>


                            </li>
                            <li>
                                <ul class="nav nav-pills" style="margin-left: 15px">
                                    <li>
                                        <c:set var="cek" value=""/>
                                        <c:if test="${soalItem.jawabans[2].id==terjawabId}"><c:set var="cek" value="checked"/>
                                        </c:if>
                                        <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                          value="${soalItem.jawabans[2].id}"

                                                          onclick="jawab('${jawab_url}','${ujian.id}','${ujian.calonMahasiswa.id}','${pengerjaanSoalId}','${soalItem.id}','${soalItem.jawabans[2].id}')"/>

                                    </li>
                                    <li>
                                        &nbsp;

                                        C     &nbsp;
                                    </li>
                                    <li>
                                            ${soalItem.jawabans[2].pilihan}
                                    </li>
                                </ul>

                            </li>
                            <li>
                                <ul class="nav nav-pills" style="margin-left: 15px">
                                    <li>
                                        <c:set var="cek" value=""/>
                                        <c:if test="${soalItem.jawabans[3].id==terjawabId}"><c:set var="cek" value="checked"/>
                                        </c:if>
                                        <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                          value="${soalItem.jawabans[3].id}"

                                                          onclick="jawab('${jawab_url}','${ujian.id}','${ujian.calonMahasiswa.id}','${pengerjaanSoalId}','${soalItem.id}','${soalItem.jawabans[3].id}')"/>

                                    </li>
                                    <li>
                                        &nbsp;

                                        D   &nbsp;
                                    </li>
                                    <li>
                                            ${soalItem.jawabans[3].pilihan}
                                    </li>
                                </ul>

                            </li>
                        </ul>
                        <hr>
                    </li>


                </c:forEach>
            </ul>




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
<script type="text/javascript">
    function jawab(url, ujianId, calonMahasiswaId, pengerjaanSoalId, soalId, jawabanId) {
        //  alert(page);
        $.ajax({
            url:url + "?ujianId=" + ujianId + "&calonMahasiswaId=" + calonMahasiswaId + "&pengerjaanSoalId=" + pengerjaanSoalId + "&soalId=" + soalId + "&jawabanId=" + jawabanId,
            type:'GET',
            success:function (result) {
            }
        });
    }
</script>

<script type="text/javascript">
    function toPage(url, page) {
        //  alert(page);
        $.ajax({
            url:url + "?page=" + page,
            type:'GET',
            success:function (result) {
                $('#bundleList').html(result);
            }
        });
    }
</script>

<script language="JavaScript">
    TargetDate = "07/05/2012 10:04 PM";
    BackColor = "red";
    ForeColor = "white";
    CountActive = true;
    CountStepper = -1;
    LeadingZero = true;
    DisplayFormat = "%%D%% Hari, %%H%% Jam, %%M%% Menit, %%S%% Detik.";
    FinishMessage = "Waktunya telah tiba!";
</script>



</body>
</html>