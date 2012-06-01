<%--
  Created by IntelliJ IDEA.
  User: latief
  Date: 3/20/12
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="enabledInput" value="${event == 'DETAIL'}"/>
<c:set var="search" value="${event=='SEARCH'}"/>
<c:choose>
    <c:when test="${search}">
        <c:url value="/distributor/search" var="distributor_url"/>
    </c:when>
    <c:otherwise>
        <c:url value="/distributor" var="distributor_url"/>
    </c:otherwise>
</c:choose>

<div id="modal" class="modal hide fade in">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>${event} DISTRIBUTOR</h3>
    </div>
    <form:form id="formInputDistributor" class="modal-form" action="${distributor_url}" method="${httpMethod}"
               modelAttribute="distributor">
        <div class="modal-body">

            <!--agar sejajar antara label dan inputan.-->
            <table>

                <form:hidden path="id"/>

                    <%--Nama--%>
                <tr>
                    <td>
                        <label class="control-label" for="textNama">Nama *</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="nama" id="textNama" class="input-xlarge" disabled="${enabledInput}"/>
                            &nbsp;
                            <span class="label label-info">*</span>
                        </div>
                    </td>
                </tr>

                    <%--Alamat--%>
                <tr>
                    <td valign="top">
                        <label class="control-label" for="textAlamat" class="input-xlarge">Alamat *</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:textarea path="alamat" id="textAlamat" rows="3" class="input-xlarge"
                                           disabled="${enabledInput}"/>
                            &nbsp;
                            <span class="label label-info">*</span>
                            <form:errors delimiter="&lt;p/&gt;" class="badge badge-error" path="alamat"/>
                        </div>
                    </td>
                </tr>

                    <%--Telp 1--%>
                <tr>
                    <td>
                        <label class="control-label" for="textPhone1">Telp 1</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="phone1" id="textPhone1" class="input-xlarge" disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>

                    <%--Telp 2--%>
                <tr>
                    <td>
                        <label class="control-label" for="textPhone2">Telp 2</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="phone2" id="textPhone2" class="input-xlarge" disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>

                    <%--Email--%>
                <tr>
                    <td>
                        <label class="control-label" for="textEmail">Email *</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="email" id="textEmail" class="input-xlarge" disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>

                    <%--Website--%>
                <tr>
                    <td>
                        <label class="control-label" for="textWeb">Website *</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="web" id="textWeb" class="input-xlarge" disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>
            </table>

        </div>
        <div class="modal-footer">

                <%--tombol hanya muncul waktu input dan edit--%>
            <c:if test="${!enabledInput}">
                <button type="submit" class="btn btn-primary"><i class="icon-white icon-download-alt"></i> Simpan</button>
                <input type="reset" class="btn" data-dismiss="modal" value="Batal">
            </c:if>

        </div>
    </form:form>
</div>
<script type="text/javascript" src="<c:url value='/resources/js/form.js'/>"></script>
