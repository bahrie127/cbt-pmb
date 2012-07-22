<%--
  Created by IntelliJ IDEA.
  Kajur: latief
  Date: 3/19/12
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<div id="header-content">DEPOSIT</div>--%>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">

            <!-- Be sure to leave the brand out there if you want it shown -->
            <a class="brand" href="#"><i class="icon-th-large icon-white icon-banner"></i>PEWAWANCARA</a>

            <!-- Everything you want hidden at 940px or less, place within here -->
            <div class="nav-collapse">

                <ul class="nav pull-right">
                        <li class="">
                            <a id="buttonAddKajur" class="plus" href="#" rel="tooltip" title="ADD"><i class="icon-plus-sign icon-white"
                                                                           ></i></a>
                        </li>
                    <li>
                        <a id="buttonRefreshKajur" href="#" rel="tooltip" title="REFRESH"><i class="icon-refresh icon-white" ></i></a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value='/resources/js/kajur/navbar.js'/>"></script>
