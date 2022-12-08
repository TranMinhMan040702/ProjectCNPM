<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Thông báo khi đủ số lượng || GV trùng với GV hướng dẫn || Đủ số lượng GV--%>
<c:if test="${not empty message}">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong></strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div
</c:if>

<div>
    <h5 style="font-weight: bold">Danh sách hội đồng phản biện</h5>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">MHĐ</th>
            <th scope="col">Đề tài phản biện</th>
            <th scope="col">SLGV</th>
            <th scope="col">Ngày phản biện</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <%--    <c:forEach--%>
        <%--            var="regis"--%>
        <%--            items="${registrationPeriodModelList}"--%>
        <%--    >--%>
        <tr>
            <td>1</td>
            <td>Website đăng ký môn học</td>
            <td>3</td>
            <td>24-12-2022</td>
            <td>Đã phân công</td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a class="btn btn-primary btn-sm"
                       data-toggle="modal" data-target="#chon-giang-vien"
                       href="<c:url value="/admin/create-registration/delete?id=${regis.id}"/>">
                        Thêm giảng viên
                    </a>
                </div>
            </td>
        </tr>
        <%--    </c:forEach>--%>
        </tbody>
    </table>
</div>

<%--Khi nao bấm thêm mới hiện danh sách giảng viên --%>
<div>
    <div class="mb-3">
        <h6 style="font-weight: bold">Tìm kiếm GV</h6>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
        </form>
    </div>
    <h6 style="font-weight: bold">Danh sách giảng viên</h6>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">MGV</th>
            <th scope="col">Tên giảng viên</th>
            <th scope="col">Bộ môn</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <%--    <c:forEach--%>
        <%--            var="regis"--%>
        <%--            items="${registrationPeriodModelList}"--%>
        <%--    >--%>
        <tr>
            <td>30110301</td>
            <td>Trần Công Minh</td>
            <td>Công nghệ phần mền</td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a class="btn btn-primary btn-sm"
                       data-toggle="modal" data-target="#xac-nhan"
                       href="">
                        Thêm
                    </a>
                    <%--GV nào thêm rồi thay nút thêm thành nút hủy--%>
                    <a class="btn btn-danger btn-sm"
                       data-toggle="modal" data-target="#chon-giang-vien"
                       href="">
                        Hủy
                    </a>
                </div>
            </td>
        </tr>
        <%--    </c:forEach>--%>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="xac-nhan" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Bạn chắc chắn thêm giảng viên này vào hội đồng ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-primary">Xác nhận</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
