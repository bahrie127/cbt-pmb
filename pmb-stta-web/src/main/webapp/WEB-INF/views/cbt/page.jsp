<%--
  Created by IntelliJ IDEA.
  User: bahrie
  Date: 6/27/12
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url value="/soal" var="soal_url"/>
<c:url value="/ujian/jawab" var="jawab_url"/>

<c:set var="nomor" value="${nomor}" scope="page"/>

<form:form id="formInputUjian" class="modal-form form-horizontal" action="${soal_url}" method="POST"
           modelAttribute="ujian">


    <ul class="nav">
        <c:forEach items="${ujian}" var="pengerjaanSoalItem">
            <c:set var="pengerjaanSoalId" value="${pengerjaanSoalItem.id}"/>
            <c:set var="terjawabId" value="${pengerjaanSoalItem.jawaban.id}"/>
            <c:set var="nomor" value="${nomor + 1}"/>

            <li>
                    ${nomor}. ${pengerjaanSoalItem.soal.pertanyaan}<br/>
                <ul class="nav">
                    <li>
                        <ul class="nav nav-pills" style="margin-left: 15px">
                            <li>
                                <c:set var="cek" value=""/>
                                <c:if test="${pengerjaanSoalItem.soal.jawabans[0].id==terjawabId}"><c:set var="cek"
                                                                                                          value="checked"/>
                                </c:if>
                                <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                  value="${pengerjaanSoalItem.soal.jawabans[0].id}" label=""
                                                  onclick="jawab('${jawab_url}','0','0','${pengerjaanSoalId}','${pengerjaanSoalItem.soal.id}','${pengerjaanSoalItem.soal.jawabans[0].id}')"/>

                            </li>
                            <li>
                                &nbsp;

                                A &nbsp;
                            </li>
                            <li>
                                    ${pengerjaanSoalItem.soal.jawabans[0].pilihan}
                            </li>
                        </ul>
                    </li>
                    <li>

                        <ul class="nav nav-pills" style="margin-left: 15px">
                            <li>
                                <c:set var="cek" value=""/>
                                <c:if test="${pengerjaanSoalItem.soal.jawabans[1].id==terjawabId}"><c:set var="cek"
                                                                                                          value="checked"/>
                                </c:if>
                                <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                  value="${pengerjaanSoalItem.soal.jawabans[1].id}" label=""
                                                  onclick="jawab('${jawab_url}','0','0','${pengerjaanSoalId}','${pengerjaanSoalItem.soal.id}','${pengerjaanSoalItem.soal.jawabans[1].id}')"/>

                            </li>
                            <li>
                                &nbsp;

                                B &nbsp;
                            </li>

                            <li>
                                    ${pengerjaanSoalItem.soal.jawabans[1].pilihan}
                            </li>
                        </ul>


                    </li>
                    <li>
                        <ul class="nav nav-pills" style="margin-left: 15px">
                            <li>
                                <c:set var="cek" value=""/>
                                <c:if test="${pengerjaanSoalItem.soal.jawabans[2].id==terjawabId}"><c:set var="cek" value="checked"/>
                                </c:if>
                                <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                  value="${pengerjaanSoalItem.soal.jawabans[2].id}"

                                                  onclick="jawab('${jawab_url}','0','0','${pengerjaanSoalId}','${pengerjaanSoalItem.soal.id}','${pengerjaanSoalItem.soal.jawabans[2].id}')"/>

                            </li>
                            <li>
                                &nbsp;

                                C     &nbsp;
                            </li>
                            <li>
                                    ${pengerjaanSoalItem.soal.jawabans[2].pilihan}
                            </li>
                        </ul>

                    </li>
                    <li>
                        <ul class="nav nav-pills" style="margin-left: 15px">
                            <li>
                                <c:set var="cek" value=""/>
                                <c:if test="${pengerjaanSoalItem.soal.jawabans[3].id==terjawabId}"><c:set var="cek" value="checked"/>
                                </c:if>
                                <form:radiobutton checked="${cek}" path="" name="jawaban${nomor}"
                                                  value="${pengerjaanSoalItem.soal.jawabans[3].id}"

                                                  onclick="jawab('${jawab_url}','0','0','${pengerjaanSoalId}','${pengerjaanSoalItem.soal.id}','${pengerjaanSoalItem.soal.jawabans[3].id}')"/>

                            </li>
                            <li>
                                &nbsp;

                                D   &nbsp;
                            </li>
                            <li>
                                    ${pengerjaanSoalItem.soal.jawabans[3].pilihan}
                            </li>
                        </ul>

                    </li>
                </ul>
                <hr>
            </li>


        </c:forEach>
    </ul>





</form:form>