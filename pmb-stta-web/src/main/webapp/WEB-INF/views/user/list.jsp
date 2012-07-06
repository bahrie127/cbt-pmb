<%--
  Created by IntelliJ IDEA.
  User: latief
  Date: 3/19/12
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/user/edit" var="userUrlEdit"/>
<c:url value="/user" var="userUrlDelete"/>
<c:url value="/user" var="userUrlDetail"/>

<style type="text/css">
    .table-center tr th
    {
        text-align: center
    }

</style>

<table class="table table-striped table-bordered table-condensed table-center" style="margin-top: -10px">
    <thead>
    <tr>
        <th>USER NAME</th>
        <th>NAMA</th>
        <th>ALAMAT</th>
        <th>ROLE</th>
        <th>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td style="text-align: center"><a href="#" onclick="detailClick('${userUrlDetail}','${user.username}')">${user.username}</a></td>
            <td style="text-align: center">${user.name}</td>
            <td style="text-align: center">${user.address}</td>
            <td style="text-align: center">${user.role.authority}</td>
            <td style="text-align: center">
                <div style="text-align: center">
                        <a class="btn minus" href="#"
                           onclick="buttonDeleteClick('${userUrlDelete}','${user.username}')"><i
                                class="icon-minus-sign" title="minus"></i></a>
                        <a class="btn edit" href="#" onclick="buttonEditClick('${userUrlEdit}','${user.username}')"><i
                                class="icon-edit" title="edit"></i></a>

                        <a id="buttonEditUsernamePass" class="btn" href="#"
                           onclick="editUsernamePassword('${user.username}')"><i
                                class="icon-lock" title="edit username password"></i></a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<script type="text/javascript" src="<c:url value='/resources/js/edit.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/delete.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/detail.js'/>"></script>
<script type="text/javascript">
    function editUsernamePassword(username) {
        $.ajax({
            url:"/cbt-pmb/user/pass/edit?id=" + username,
            type:'GET',
            success:function (result) {
                $('#fillMyModalPlus').html(result);
                $('#modal').modal('toggle');
            }
        });
    }
    ;

</script>
