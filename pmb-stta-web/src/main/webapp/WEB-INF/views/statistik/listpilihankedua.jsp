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

    </tr>
    </thead>
    <tbody>
    <%--<c:forEach items="${hasils}" var="hasil">--%>

        <tr>
            <%--<td style="text-align: center">${hasil.calonMahasiswa.id}</td>--%>
            <%--<td style="text-align: center">${hasil.calonMahasiswa.nama}</td>--%>
            <%--<td style="text-align: center">${hasil.nilaiVerbal} %</td>--%>
            <%--<td style="text-align: center">${hasil.nilaiNumerik} %</td>--%>
            <%--<td style="text-align: center">${hasil.nilaiLogika} %</td>--%>
            <%--<td style="text-align: center">${hasil.nilaiGambar} %</td>--%>

        </tr>
    <%--</c:forEach>--%>
    </tbody>
    <tfoot>
    <tr>


    </tr>

    </tfoot>
</table>

