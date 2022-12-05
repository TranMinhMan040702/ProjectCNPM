<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Nếu chưa có nhóm thì hiện nút tạo--%>
<div class="d-flex justify-content-center">
    <a href="" class="btn btn-primary btn-sm">Tạo nhóm</a>
</div>
<%--Nếu có rồi hiển thị danh sách thành viên trong nhóm--%>
<div>
    <div class="d-flex justify-content-between">
        <h5 style="font-weight: bold">Danh sách thành viên</h5>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã số sinh viên</th>
            <th scope="col">Tên sinh viên</th>
            <th scope="col">Chuyên ngành</th>
            <th scope="col">Thông tin</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <%--    <c:forEach--%>
        <%--            var="regis"--%>
        <%--            items="${registrationPeriodModelList}"--%>
        <%--    >--%>
        <tr>
            <td>20110201</td>
            <td>Trần Minh Minh</td>
            <td>Công nghệ phần mềm</td>
            <td>
                <a class=""
                   data-toggle="modal" data-target="#xem-chi-tiet"
                   href="">
                    Xem chi tiết
                </a>
            </td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a class="btn btn-primary btn-sm"
                       data-toggle="modal" data-target="#xac-nhan"
                       href="">
                        Thêm
                    </a>
                </div>
            </td>
        </tr>
        <%--    </c:forEach>--%>
        </tbody>
    </table>
</div>

<%--Danh sách các sinh viên trong hệ thống--%>
<div>
    <div class="d-flex justify-content-between">
        <h5 style="font-weight: bold">Danh sách sinh viên</h5>
        <div class="d-flex justify-content-center align-items-center">
            <h6 style="font-weight: bold">Tìm kiếm GV</h6>
            <form class="form-inline" style="margin-bottom: 5px; margin-left: 10px">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
            </form>
        </div>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã số sinh viên</th>
            <th scope="col">Tên sinh viên</th>
            <th scope="col">Chuyên ngành</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <%--    <c:forEach--%>
        <%--            var="regis"--%>
        <%--            items="${registrationPeriodModelList}"--%>
        <%--    >--%>
        <tr>
            <td>20110201</td>
            <td>Trần Minh Minh</td>
            <td>Công nghệ phần mềm</td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a class="btn btn-primary btn-sm"
                       data-toggle="modal" data-target="#xac-nhan"
                       href="<c:url value="/admin/create-registration/delete?id=${regis.id}"/>">
                        Thêm
                    </a>
                </div>
            </td>
        </tr>
        <%--    </c:forEach>--%>
        </tbody>
    </table>
</div>

<!-- Modal Xác nhận-->
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
                Bạn chắc chắn thêm sinh viên này vào nhóm ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-primary">Xác nhận</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal xem chi tiết-->
<div class="modal fade" id="xem-chi-tiet" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="">Thông tin chi tiết</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="row">
                        <div class="form-group col-6">
                            <label>MSSV</label>
                            <input id="a" type="text" class="form-control" placeholder="Tên tài khoản" required name="username" value="${user.username}">
                        </div>
                        <div class="form-group col-6">
                            <label>Họ tên</label>
                            <input id="name" type="text" class="form-control" placeholder="Tên của bạn" required name="fullname" value="${user.fullname}">
                        </div>
                        <div class="form-group col-6">
                            <label>Giới tính:</label> <br>
                            <c:set var = "male" scope = "session" value = "${user.male}"/>
                            <label><input type="radio" value="Nam" name="male" <c:if  test="${male =='Nam'}">checked</c:if>> Nam</label>
                            <label><input type="radio" name="male" value="Nu" <c:if  test="${male !='Nam'}">checked</c:if>> Nữ</label>
                        </div>
                        <div class="form-group col-12">
                            <label>Email</label>
                            <input type="email" class="form-control" placeholder="Email của bạn" required name="email" value="${user.email}">
                        </div>
                        <div class="form-group col-12">
                            <label>Ngày sinh</label>
                            <input id="dob" type="date" class="form-control" placeholder="Ngày sinh của bạn" required name="birthday" value="${birthday}">
                        </div>
                        <div class="form-group col-6">
                            <label>Địa chỉ</label>
                            <input type="tel" class="form-control" placeholder="Địa chỉ hiện tại" required name="address" value="${user.address}">
                        </div>
                        <div class="form-group col-6">
                            <label>SĐT</label>
                            <input type="tel" class="form-control" placeholder="Số điện thoại" required name="phone" value="${user.phone}">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
