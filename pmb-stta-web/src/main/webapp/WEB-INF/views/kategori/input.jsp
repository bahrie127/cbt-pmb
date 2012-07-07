<script type="text/javascript">
    jQuery(document).ready(function () {
// binds form submission and fields to the validation engine
        jQuery("#formInputKategori").validationEngine();
    });
</script>

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

        <h3 style="text-align: center">${event} KATEGORI</h3>
    </div>
    <form:form id="formInputKategori" class="modal-form" action="${kategori_url}" method="${httpMethod}"
               modelAttribute="kategori">
        <div class="modal-body">


            <form:hidden path="id" class="form-horizontal"/>

                <%--Nama--%>
            <fieldset>
                <div class="control-group">

                    <div class="controls">
                        <div class="input-append" style="text-align: center">
                            <form:input path="nama" id="textNama" class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Nama"/><span style="margin-top: -8px" class="add-on">*</span>
                        </div>

                    </div>
                </div>

            </fieldset>



        </div>
        <div class="modal-footer">

                <%--tombol hanya muncul waktu input dan edit--%>
            <c:if test="${!enabledInput}">
                <button type="submit" class="btn btn-primary"><i class="icon-white icon-download-alt"></i> Simpan
                </button>
                <input type="reset" class="btn" data-dismiss="modal" value="Batal">
            </c:if>

        </div>
    </form:form>
</div>
<script type="text/javascript" src="<c:url value='/resources/js/form.js'/>"></script>
