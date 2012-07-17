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

        <h3 style="text-align: center">${event} SETTING SOAL</h3>
    </div>
    <form:form id="formInputsetting" class="modal-form" action="${setting_url}" method="${httpMethod}"
               modelAttribute="setting">
        <div class="modal-body">
            <table style="text-align: center">

                <form:hidden path="id" class="form-horizontal"/>
                <thead>
                <tr>
                    <th colspan="2">Jumlah Soal</th>
                    <th colspan="2">Waktu Pengerjaan</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalSinonim">Sinonim</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalSinonimTampil" id="textJumlahSoalSinonim" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        <label class="control-label" for="textWaktuPengerjaanVerbal">Verbal (menit)</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="waktuPengerjaanVerbal" id="textWaktuPengerjaanVerbal"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalAntonim">Antonim</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalAntonimTampil" id="textJumlahSoalAntonim" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        <label class="control-label" for="textWaktuPengerjaanNumerik">Numerik (menit)</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="waktuPengerjaanNumerik" id="textWaktuPengerjaanNumerik"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalPadanan">Padanan</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalPadananTampil" id="textJumlahSoalPadanan" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        <label class="control-label" for="textWaktuPengerjaanLogikal">Logikal (menit)</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="waktuPengerjaanLogikal" id="textWaktuPengerjaanLogikal"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalSeriAngka">Seri Angka</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalSeriAngkaTampil" id="textJumlahSoalSeriAngka" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        <label class="control-label" for="textWaktuPengerjaanGambar">Gambar (menit)</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="waktuPengerjaanGambar" id="textWaktuPengerjaanGambar"
                                        class="span2 input-xlarge validate[required] text-input" disabled="${enabledInput}"
                                        placeholder="Waktu Pengerjaan"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalSeriHuruf">Seri Huruf</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalSeriHurufTampil" id="textJumlahSoalSeriHuruf" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalTeknikal">Teknikal</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalTeknikalTampil" id="textJumlahSoalTeknikal" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalLogika">Logikal</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalLogikalTampil" id="textJumlahSoalLogika" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textJumlahSoalGambar">Gambar</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input
                                    path="jumlahSoalGambarTampil" id="textJumlahSoalGambar" class="span2 input-xlarge validate[required] text-input"
                                    disabled="${enabledInput}"
                                    placeholder="Jumlah Soal"/>
                        </div>
                    </td>

                    <td>
                        &nbsp;
                    </td>
                </tr>
                </tbody>
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
