<script type="text/javascript">
    jQuery(document).ready(function () {
// binds form submission and fields to the validation engine
        jQuery("#formInputAdmin").validationEngine();
    });
</script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="modal" class="modal hide fade in" style="width: 440px">

    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>${event} OPERATOR</h3>
    </div>

    <c:set var="enabledInput" value="${event == 'DETAIL'}"/>
    <c:url value="/user" var="user_url"/>


    <form:form id="formInputAdmin" class="modal-form" action="${user_url}" method="${httpMethod}" modelAttribute="user">
        <div class="modal-body">

            <!--agar sejajar antara label dan inputan.-->
            <table>

                    <%--<form:hidden path="id"/>--%>

                <tbody>
                <tr>
                    <td>
                        <label class="control-label" for="textUsername">Username</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="username" id="textUsername" class="input-medium validate[required] text-input"
                                        disabled="${enabledInpu}" readonly="${event == 'EDIT' || event == 'DETAIL'}"/>
                        </div>
                    </td>
                </tr>

                <c:if test="${event == 'INPUT'}">
                    <tr>
                        <td>
                            <label class="control-label" for="textPassword">Password</label>
                        </td>
                        <td>
                            <div class="controls">
                                &nbsp;&nbsp;
                                <form:password path="password" id="textPassword" class="input-medium validate[required] text-input"
                                               disabled="${enabledInput}"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="control-label" for="textConfirmPassword">Confirm Password</label>
                        </td>
                        <td>
                            <div class="controls">
                                &nbsp;&nbsp;
                                <form:password path="confirmPassword" id="textConfirmPassword" class="input-medium validate[required] text-input"
                                               disabled="${enabledInput}"/>
                            </div>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <label class="control-label" for="textName">Nama</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="name" id="textName" class="input-xlarge validate[required] text-input" disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textAddress">Alamat</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:textarea path="address" id="textAddress" class="input-xlarge validate[required] text-input"
                                           disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" for="textPhone1">Telp 1</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="phone1" id="textPhone1" class="input-medium" disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label class="control-label" for="textPhone2">Telp 2</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="phone2" id="textPhone2" class="input-medium" disabled="${enabledInput}"/>
                        </div>
                    </td>
                </tr>


                <%--<tr>--%>
                    <%--<td>--%>
                        <%--<label class="control-label" for="checkEnabled">Enabled</label>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<div class="controls">--%>
                            <%--&nbsp;&nbsp;--%>
                            <%--<form:checkbox path="enabled" id="checkEnabled" class="input-mini"--%>
                                           <%--disabled="${enabledInput}"/>--%>
                        <%--</div>--%>
                    <%--</td>--%>
                <%--</tr>--%>

                </tbody>
            </table>

        </div>
        <div class="modal-footer">
            <c:if test="${!enabledInput}">
                <button type="submit" class="btn btn-primary"><i class="icon-white icon-download-alt"></i> Simpan</button>
                <input type="reset" class="btn" data-dismiss="modal" value="Batal">
            </c:if>
        </div>
    </form:form>
</div>

<script type="text/javascript" src="<c:url value='/resources/js/form.js'/>"></script>