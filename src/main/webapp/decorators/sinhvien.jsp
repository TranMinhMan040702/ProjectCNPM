<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="/common/link-css-js.jsp" %>
</head>
<body>
<div class="boxcenter">
    <%@include file="/common/header.jsp"%>
    <%@include file="/common/nav.jsp"%>
    <div class="row mt-3">
        <div class="col-3">
            <%@include file="/common/sinhvien/menu.jsp"%>
        </div>
        <div class="col-9">
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                </ol>
            </nav>
            <dec:body/>
        </div>
    </div>
    <%@include file="/common/footer.jsp"%>
</div>

</body>
</body>
</html>
