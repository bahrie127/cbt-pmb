<script type="text/javascript">
    jQuery(document).ready(function () {
// binds form submission and fields to the validation engine
        jQuery("#formInputSoal").validationEngine();
    });
</script>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="enabledInput" value="${event == 'DETAIL'}"/>
<c:url value="/setting" var="setting_url"/>

<div id="modal" class="modal hide fade in">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3 style="text-align: center">${event} SETTING</h3>
    </div>
    <form:form id="formInputsetting" class="modal-form" action="${setting_url}" method="${httpMethod}"
               modelAttribute="setting">
        <div class="modal-body">
            <table style="text-align: center">

                <form:hidden path="id" class="form-horizontal"/>

                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoal">Jumlah Soal Tampil</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalTampil" id="textJumlahSoal" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textWaktuPengerjaan">Waktu Pengerjaan (Jam)</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="waktuPengerjaan" id="textWaktuPengerjaan"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
            </table>
                <%--Nama--%>
                <%--<fieldset>--%>
                <%--<div class="control-group">--%>

                <%--<div class="controls">--%>
                <%--<div class="input-append inline" style="text-align: center">--%>
                <%----%>
                <%--</div>--%>
                <%--<div class="input-append" style="text-align: center">--%>
                <%----%>
                <%--</div>--%>

                <%--</div>--%>
                <%--</div>--%>

                <%--</fieldset>--%>


        </div>
        <div class="modal-footer">
            <c:if test="${!enabledInput}">
                <button type="submit" class="btn btn-primary"><i class="icon-white icon-download-alt"></i> Simpan
                </button>
                <input type="reset" class="btn" data-dismiss="modal" value="Batal">
            </c:if>
        </div>
    </form:form>
</div>
<script type="text/javascript" src="<c:url value='/resources/js/form.js'/>"></script>
