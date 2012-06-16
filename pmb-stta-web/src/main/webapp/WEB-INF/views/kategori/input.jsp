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
        <c:url value="/kategori/search" var="kategori_url"/>
    </c:when>
    <c:otherwise>
        <c:url value="/kategori" var="kategori_url"/>
    </c:otherwise>
</c:choose>

<div id="modal" class="modal hide fade in">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>${event} KATEGORI</h3>
    </div>
    <form:form id="formInputKategori" class="modal-form" action="${kategori_url}" method="${httpMethod}"
               modelAttribute="kategori">
        <div class="modal-body">

            <!--agar sejajar antara label dan inputan.-->
            <table>

                <form:hidden path="id"/>

                    <%--Nama--%>
                <tr>
                    <td>
                        <label class="control-label" for="textNama">Nama</label>
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
