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
        <c:url value="/soal/search" var="soal_url"/>
    </c:when>
    <c:otherwise>
        <c:url value="/soal" var="soal_url"/>
    </c:otherwise>
</c:choose>

<div id="modal" class="modal hide fade in">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3 style="text-align: center">${event} SOAL</h3>
    </div>
    <form:form id="formInputSoal" class="modal-form" action="${soal_url}" method="${httpMethod}"
               modelAttribute="soal">
        <div class="modal-body">

            <!--agar sejajar antara label dan inputan.-->
            <table>

                <form:hidden path="id"/>

                <tr>
                    <td valign="top">
                        <label class="control-label" for="kategoriId">Kategori</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:select path="idKategori" id="kategoriId" disabled="${enabledInput}"
                                         style="width: 178px">
                                <c:forEach items="${kategoriList}" var="kategoriItem">
                                    <form:option value="${kategoriItem.id}" label="${kategoriItem.nama}" selected="${(soal.idKategori==kategoriItem.id)?true:''}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="pertanyaan">Soal</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="pertanyaan" id="pertanyaan" class="input-xlarge" disabled="${enabledInput}"/>
                            &nbsp;
                            <span class="label label-info">*</span>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="jawabanA">Jawaban A</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="jawabanA" id="jawabanA" class="input-xlarge" disabled="${enabledInput}"/>
                            &nbsp;

                            <span class="label label-info">*</span><form:radiobutton path="kebenaran" value="A" checked="${(soal.kebenaran=='A'?true:'')}"/> Benar
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="jawabanB">Jawaban B</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="jawabanB" id="jawabanB" class="input-xlarge" disabled="${enabledInput}"/>
                            &nbsp;

                            <span class="label label-info">*</span><form:radiobutton path="kebenaran" value="B" checked="${(soal.kebenaran=='B'?true:'')}"/> Benar
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="jawabanC">Jawaban C</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="jawabanC" id="jawabanC" class="input-xlarge" disabled="${enabledInput}"/>
                            &nbsp;

                            <span class="label label-info">*</span><form:radiobutton path="kebenaran" value="C" checked="${(soal.kebenaran=='C'?true:'')}"/> Benar
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="jawabanD">Jawaban D</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="jawabanD" id="jawabanD" class="input-xlarge" disabled="${enabledInput}"/>
                            &nbsp;

                            <span class="label label-info">*</span><form:radiobutton path="kebenaran" value="D" checked="${(soal.kebenaran=='D'?true:'')}"/> Benar
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
<script type="text/javascript">
    //soalInit(${soalJson});
</script>