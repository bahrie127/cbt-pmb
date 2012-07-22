<%--
  Created by IntelliJ IDEA.
  User: latief
  Date: 3/19/12
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/statistik/detail" var="statistikDetail"/>
<style type="text/css">
    .table-center tr th {
        text-align: center
    }

</style>

<table class="table table-striped table-bordered table-condensed table-center" style="margin-top: -10px;">
    <thead>
    <tr>
        <th>Jurusan Pilihan Kedua</th>
        <th>Jumlah</th>
        <th>Verbal</th>
        <th>Numerik</th>
        <th>Logikal</th>
        <th>Gambar</th>
        <th>Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${statistik2}" var="hasil">

        <tr>
            <td style="text-align: center">${hasil.jurusan}</td>
            <td style="text-align: center">${hasil.jumlah}</td>
            <td style="text-align: center">${hasil.verbal} %</td>
            <td style="text-align: center">${hasil.numerik} %</td>
            <td style="text-align: center">${hasil.logikal} %</td>
            <td style="text-align: center">${hasil.gambar} %</td>
            <td>
                <div align="center">
                    <a class="btn edit btn-info" href="#" onclick="detailClick('${statistikDetail}','2','${hasil.jurusan}')"><i
                            class="icon-list-alt icon-white" title="Detail"></i> Detail</a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>


    </tr>

    </tfoot>
</table>
<script type="text/javascript" src="<c:url value='/resources/js/statistik/detail.js'/>"></script>
