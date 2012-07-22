

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="modal" class="modal hide fade in" style="display: block; width: 900px;margin-left: -434px;">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3 style="text-align: center">Detail Statistik</h3>

    </div>
    <div>
        <table class="table table-striped table-bordered table-condensed table-center" style="margin-top: -10px;">
            <thead>
            <tr>
                <th>No Pendaftaran</th>
                <th>Nama</th>
                <th>Verbal</th>
                <th>Numerik</th>
                <th>Logikal</th>
                <th>Gambar</th>
                <th>Nilai Akhir</th>
            </thead>
            <tbody>
            <c:forEach items="${statistiks}" var="hasil">
                <tr>
                    <td style="text-align: center">${hasil.calonMahasiswa.id}</td>
                    <td style="text-align: center">${hasil.calonMahasiswa.nama}</td>
                    <td style="text-align: center">${hasil.nilaiVerbal} %</td>
                    <td style="text-align: center">${hasil.nilaiNumerik} %</td>
                    <td style="text-align: center">${hasil.nilaiLogika} %</td>
                    <td style="text-align: center">${hasil.nilaiGambar} %</td>
                    <td style="text-align: center">${hasil.hasil} </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>

</div>

