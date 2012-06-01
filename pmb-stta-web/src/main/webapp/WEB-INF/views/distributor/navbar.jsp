<%--
  Created by IntelliJ IDEA.
  User: latief
  Date: 3/19/12
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<div id="header-content">DISTRIBUTOR</div>--%>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">

            <!-- Be sure to leave the brand out there if you want it shown -->
            <a class="brand" href="#"><i class="icon-th-large icon-white icon-banner"></i>DISTRIBUTOR</a>

            <!-- Everything you want hidden at 940px or less, place within here -->
            <div class="nav-collapse">

                <ul class="nav pull-right">
                    <sec:authorize access="hasAnyRole('DISTRIBUTOR_C','ADMIN_IT')">
                        <li class="">
                            <a id="buttonAddDistributor" class="plus" href="#" rel="tooltip" title="ADD"><i class="icon-plus-sign icon-white"
                                                                                  ></i></a>
                        </li>
                    </sec:authorize>
                    <li>
                        <a id="buttonRefreshDistributor" href="#" rel="tooltip" title="REFRESH"><i class="icon-refresh icon-white"
                                                                     ></i></a>
                    </li>
                    <li>
                        <a id="buttonSearchDistributor" href="#" class="plus" rel="tooltip" title="SEARCH"><i class="icon-search icon-white"
                                                                                 ></i></a>
                    </li>

                    <li>

                        <ul class="nav nav-pills">

                            <li class="dropdown" id="menu1">
                                <a id="buttonPrintDistributor" class="dropdown-toggle" data-toggle="dropdown" href="#menu1" rel="tooltip" title="PRINT">
                                    <i class="icon-download-alt icon-white"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="<c:url value='/distributor/daftarDistributor.xls'/>" target="_blank">excel</a>
                                    </li>

                                    <li><a href="<c:url value='/distributor/daftarDistributor.pdf'/>" target="_blank">pdf</a>
                                    </li>

                                </ul>
                            </li>

                        </ul>
                    </li>
                </ul>

                <form class="navbar-search pull-left" id="form_hide" style="display: none;">
                    <input type="text" class="search-query" placeholder="Search">
                </form>

            </div>

        </div>
    </div>
</div>
<%--<br/>--%>
<%--<hr/>--%>
<script type="text/javascript" src="<c:url value='/resources/js/distributor/navbar.js'/>"></script>
