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

<c:url value="/distributor/edit" var="distributorUrlEdit"/>
<c:url value="/distributor" var="distributorUrlDetail"/>
<c:url value="/distributor" var="distributorUrlDelete"/>

<style type="text/css">
    .table-center tr th
    {
        text-align: center
    }

</style>

<table class="table table-striped table-bordered table-condensed table-center" style="margin-top: -10px;">
    <thead>
    <tr>
        <th>ID</th>
        <th>NAMA</th>
        <th>ALAMAT</th>
        <th>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${distributors}" var="distributor">

        <tr>
            <td class="span1" style="text-align: center"><a href="#" onclick="detailClick('${distributorUrlDetail}',${distributor.id})">${distributor.id}</a>
            </td>
            <td>${distributor.nama}</td>
            <td>${distributor.alamat}</td>
            <td>
                <div>
                    <sec:authorize access="hasAnyRole('DISTRIBUTOR_D','ADMIN_IT')">
                        <a class="btn minus btn-danger" href="#"
                           onclick="buttonDeleteClick('${distributorUrlDelete}',${distributor.id})"><i
                                class="icon-trash icon-white" title="minus"></i> Delete</a>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('DISTRIBUTOR_U','ADMIN_IT')">
                        <a class="btn edit btn-info" href="#"
                           onclick="buttonEditClick('${distributorUrlEdit}',${distributor.id})"><i
                                class="icon-edit icon-white" title="edit"></i> Edit</a>
                    </sec:authorize>
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

<%--pagination--%>
<%--<input type="text" class="input-small">--%>
<div class="pagination btn-toolbar">

    <c:url value="${urlFunction}" var="url"/>
    <ul class="btn-group">

        <c:if test="${page-kiri>1}">
            <li class="active" onclick="toPage('${url}',1)">
            <button style="cursor: pointer" class="btn">«</button>
        </li>
            <li class="active" onclick="toPage('${url}',${page-1})">
                <button style="cursor: pointer" class="btn"><</button>
            </li>
        </c:if>
        <c:forEach var="i" begin="${page-kiri}" step="1" end="${page-1}">
            <li class="active" onclick="toPage('${url}',${i})" >
                <button style="cursor: pointer" class="btn">${i}</button>
            </li>
        </c:forEach>

        <li class="active" onclick="toPage('${url}',${page})">
            <button style="cursor: pointer" class="btn">${page}</button>
        </li>
        <c:forEach var="i" begin="${page+1}" step="1" end="${page+kanan}">
            <li class="active" onclick="toPage('${url}',${i})">
                <button style="cursor: pointer" class="btn">${i}</button>
            </li>
        </c:forEach>

        <c:if test="${page+kanan<countPage}">
            <li class="active" onclick="toPage('${url}',${page+1})">
                <button style="cursor: pointer" class="btn">></button>
            <li class="active" onclick="toPage('${url}',${countPage})">
            <button style="cursor: pointer" class="btn">»</button>
        </li>
            </li>
        </c:if>

    </ul>
</div>

</div>

<script type="text/javascript" src="<c:url value='/resources/js/edit.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/delete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/detail.js'/>"></script>

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