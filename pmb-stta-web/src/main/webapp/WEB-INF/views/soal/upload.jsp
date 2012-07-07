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

<script type="text/javascript">

    function Validate() {

        var image = document.getElementById("image").value;

        if (excel != '') {

            var checkimg = excel.toLowerCase();

            if (!checkimg.match(/(\.xls)$/)) {

                alert("file anda bukan file excel (.xls)");

                document.getElementById("excel").focus();

                return false;

            }
        }
        return true;

    }
</script>

<div id="modal" class="modal hide fade in">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3 style="text-align: center">${event}UPLOAD SOAL</h3>
    </div>

    <c:url value="/soal/upload" var="upload_url"/>

    <form:form action="${upload_url}" modelAttribute="uploadItem" method="POST" enctype="multipart/form-data" onSubmit="return Validate();">
           <div>
               <br/>
            <p style="text-align: center">
                <form:input path="fileData" id="uploadify" type="file"/>
            </p>

            <p style="text-align: center">
                <button type="submit" class="btn btn-primary"><i class="icon-white icon-download-alt"></i> Upload</button>
            </p>
           </div>
    </form:form>
</div>
<%--<script type="text/javascript" src="<c:url value='/resources/js/uploadfile.js'/>"></script>--%>