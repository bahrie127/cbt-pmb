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

<c:url value="/grade/edit" var="gradeUrlEdit"/>
<c:url value="/grade" var="gradeUrlDetail"/>
<c:url value="/grade" var="gradeUrlDelete"/>

<style type="text/css">
    .table-center tr th {
        text-align: center
    }

</style>

<table class="table table-striped table-bordered table-condensed table-center" style="margin-top: -10px;">
    <thead>
    <tr>
        <th class="span1">ID</th>
        <th>Jurusan</th>
        <th>Batas Verbal</th>
        <th>Batas Numerik</th>
        <th>Batas Logikal</th>
        <th>Batas Gambar</th>
        <th class="span3">ACTION</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${gradeLuluss}" var="gradeLulus">
        <tr>
            <td class="span1" style="text-align: center"><a href="#"
                                                            onclick="detailClick('${gradeUrlDetail}',${gradeLulus.id})">${gradeLulus.id}</a>
            </td>
            <td style="text-align: center">${gradeLulus.jurusan}</td>
            <td style="text-align: center">${gradeLulus.batasVerbal}</td>
            <td style="text-align: center">${gradeLulus.batasNumerik}</td>
            <td style="text-align: center">${gradeLulus.batasLogika}</td>
            <td style="text-align: center">${gradeLulus.batasGambar}</td>
            <td>
                <div align="center">
                    <a class="btn edit btn-info" href="#"
                       onclick="buttonEditClick('${gradeUrlEdit}',${gradeLulus.id})"><i
                            class="icon-edit icon-white" title="edit"></i> Edit</a>
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

<script type="text/javascript" src="<c:url value='/resources/js/edit.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/delete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/detail.js'/>"></script>
