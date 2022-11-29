<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>profile</title>
</head>
<body>
<h2 class="form-title">Cập nhập thông tin</h2>
<form>
    <div class="row">
        <div class="form-group col-6">
            <label>Tài khoản</label>
            <input id="a" type="text" class="form-control" placeholder="Tên tài khoản" required name="">
        </div>
        <div class="form-group col-6">
            <label>Mật khẩu</label>
            <input id="b" type="text" class="form-control" placeholder="Mật khẩu" required name="">
        </div>
        <div class="form-group col-6">
            <label>Họ tên</label>
            <input id="name" type="text" class="form-control" placeholder="Tên của bạn" required name="">
        </div>
        <div class="form-group col-6">
            <label>Giới tính:</label> <br>
            <label><input type="radio" value="nam" name="gender" checked> Nam</label>
            <label><input type="radio" name="gender" value="nu"> Nữ</label>
        </div>
        <div class="form-group col-12">
            <label>Email</label>
            <input type="email" class="form-control" placeholder="Email của bạn" required name="">
        </div>
        <div class="form-group col-12">
            <label>Ngày sinh</label>
            <input id="dob" type="date" class="form-control" placeholder="Ngày sinh của bạn" required name="">
        </div>
        <div class="form-group col-6">
            <label>Địa chỉ</label>
            <input type="tel" class="form-control" placeholder="Địa chỉ hiện tại" required name="">
        </div>
        <div class="form-group col-6">
            <label>SĐT</label>
            <input type="tel" class="form-control" placeholder="Số điện thoại" required name="">
        </div>
    </div>
    <div class="form-group d-flex justify-content-end">
        <button style="padding-left: 20px; padding-right: 20px; margin-right: 10px;"
                id="btnAddEmployee" class="btn btn-primary" type="submit">Cập nhật
        </button>
        <button style="padding-left: 20px; padding-right: 20px;"
                class="btn btn-danger" type="reset">Hủy
        </button>
    </div>
</form>
</body>
</html>
