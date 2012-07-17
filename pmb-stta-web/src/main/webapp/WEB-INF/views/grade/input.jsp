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
<c:url value="/grade" var="grade_url"/>

<div id="modal" class="modal hide fade in" style="width: 348px; margin-left: -192px">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3 style="text-align: center">${event} SETTING GRADE</h3>
    </div>
    <form:form id="formInputgrade" class="modal-form" action="${grade_url}" method="${httpMethod}"
               modelAttribute="gradeLulus">
        <div class="modal-body">
            <table style="text-align: center">

                <form:hidden path="id" class="form-horizontal"/>

                <tr>
                    <td>
                        <label class="control-label" for="jurusan">Jurusan</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:select class="validate[required] text-input" path="jurusan" id="jurusan" disabled="${enabledInput}"
                                         style="width: 178px">
                                <form:option value="">---pilih---</form:option>

                                    <form:option value="T Penerbangan" label="T Penerbangan"
                                                 selected="${(gradeLulus.jurusan=='T Penerbangan')?true:''}"/>
                                <form:option value="T Informatika" label="T Informatika"/>
                                             selected="${(gradeLulus.jurusan=='T Informatika')?true:''}"/>
                                <form:option value="T Industri" label="T Industri"
                                             selected="${(gradeLulus.jurusan=='T Industri')?true:''}"/>
                                <form:option value="T Mesin" label="T Mesin"
                                             selected="${(gradeLulus.jurusan=='T Mesin')?true:''}"/>
                                <form:option value="T Elektro" label="T Elektro"
                                             selected="${(gradeLulus.jurusan=='T Elektro')?true:''}"/>

                            </form:select>
                           <%--<combobox name="jurusan" id="jurusan">--%>
                               <%--<form:option value="T Penerbangan" label="T Penerbangan"/>--%>
                               <%--<form:option value="T Informatika" label="T Informatika"/>--%>
                               <%--<form:option value="T Industri" label="T Industri"/>--%>
                               <%--<form:option value="T Mesin" label="T Mesin"/>--%>
                               <%--<form:option value="T Elektro" label="T Elektro"/>--%>
                           <%--</combobox>--%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="batasVerbal">Batas Verbal</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="batasVerbal" id="batasVerbal"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="batasNumerik">Batas Numerik</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="batasNumerik" id="batasNumerik"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="batasLogika">Batas Logikal</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="batasLogika" id="batasLogika"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="batasGambar">Batas Gambar</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="batasGambar" id="batasGambar"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
            </table>
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
