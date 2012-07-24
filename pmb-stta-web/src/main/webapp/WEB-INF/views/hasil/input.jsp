<script type="text/javascript">
    jQuery(document).ready(function () {
// binds form submission and fields to the validation engine
        jQuery("#formInputKategori").validationEngine();
    });
</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="search" value="${event=='SEARCH'}"/>
<c:choose>
    <c:when test="${search}">
        <c:url value="/ujian/search" var="ujian_url"/>
    </c:when>
    <c:otherwise>
        <c:url value="/ujian" var="ujian_url"/>
    </c:otherwise>
</c:choose>

<div id="modal" class="modal hide fade in">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3 style="text-align: center">SEARCH HASIL</h3>
    </div>
    <form:form id="formInputKategori" class="modal-form" action="${ujian_url}" method="GET"
               modelAttribute="ujian">
        <div class="modal-body">


            <%--<form:hidden path="id" class="form-horizontal"/>--%>

                <%--Nama--%>
            <fieldset>
                <div class="control-group">

                    <div class="controls">
                        <div class="input-append" style="text-align: center">
                            <form:input path="" id="noPendaftaran" name="noPendaftaran" class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Nomor Pendaftaran"/><span style="margin-top: -8px" class="add-on">*</span>
                        </div>

                    </div>
                </div>

            </fieldset>



        </div>
        <div class="modal-footer">

                <%--tombol hanya muncul waktu input dan edit--%>
            <c:if test="${!enabledInput}">
                <button type="submit" class="btn btn-primary"><i class="icon-white icon-download-alt"></i> Cari
                </button>
                <input type="reset" class="btn" data-dismiss="modal" value="Batal">
            </c:if>

        </div>
    </form:form>
</div>
<script type="text/javascript" src="<c:url value='/resources/js/form.js'/>"></script>
