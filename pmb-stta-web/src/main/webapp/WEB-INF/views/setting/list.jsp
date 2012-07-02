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

<c:url value="/setting/edit" var="settingUrlEdit"/>
<c:url value="/setting" var="settingUrlDetail"/>
<c:url value="/setting" var="settingUrlDelete"/>

<style type="text/css">
    .table-center tr th {
        text-align: center
    }

</style>

<table class="table table-striped table-bordered table-condensed table-center" style="margin-top: -10px;">
    <thead>
    <tr>
        <th class="span1">ID</th>
        <th>Jumlah Soal</th>
        <th class="span3">ACTION</th>
    </tr>
    </thead>
    <tbody>

        <tr>
            <td class="span1" style="text-align: center"><a href="#"
                                                            onclick="detailClick('${settingUrlDetail}',${settings.id})">${settings.id}</a>
            </td>
            <td style="text-align: center">${settings.jumlahSoalTampil}</td>
            <td>
                <div align="center">
                    <a class="btn edit btn-info" href="#"
                       onclick="buttonEditClick('${settingUrlEdit}',${settings.id})"><i
                            class="icon-edit icon-white" title="edit"></i> Edit</a>
                </div>
            </td>
        </tr>
    </tbody>
    <tfoot>
    <tr>


    </tr>

    </tfoot>
</table>

<script type="text/javascript" src="<c:url value='/resources/js/edit.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/delete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/detail.js'/>"></script>
