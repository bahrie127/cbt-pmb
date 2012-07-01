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
<div id="modal" class="modal hide fade in" style="width: 440px">

    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>EDIT USERNAME & PASSWORD</h3>
    </div>

    <c:url value="/user/pass" var="user_url"/>


    <form:form class="modal-form" action="${user_url}" method="PUT" modelAttribute="user">
        <div class="modal-body">

            <!--agar sejajar antara label dan inputan.-->
            <table>

                <form:hidden path="username"/>

                <tbody>
                <tr>
                    <td>
                        <label class="control-label" for="textNewUsername">Username</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:input path="newUsername" id="textNewUsername" class="input-medium"/>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label class="control-label" for="textNewPassword">Password Baru</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:password path="newPassword" id="textNewPassword" class="input-medium"/>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label class="control-label" for="textConfirmNewPassword">Ketik Ulang Password Baru</label>
                    </td>
                    <td>
                        <div class="controls">
                            &nbsp;&nbsp;
                            <form:password path="confirmNewPassword" id="textConfirmNewPassword" class="input-medium"/>
                        </div>
                    </td>
                </tr>

                </tbody>
            </table>

        </div>
        <div class="modal-footer">
            <c:if test="${!enabledInput}">
                <input type="submit" class="btn btn-primary" value="Simpan"/>
                <input type="reset" class="btn" data-dismiss="modal" value="Batal">
            </c:if>
        </div>
    </form:form>
</div>

<script type="text/javascript" src="<c:url value='/resources/js/form.js'/>"></script>