<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h5 class="form-title" style="font-weight: bold">Tạo tài khoản</h5>
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
            <div class="form-group col-12">
                <label> Chức vụ</label> <br>
                <label><input type="radio" value="sinhvien" name="chuc-vu" checked>Sinh viên</label>
                <label><input type="radio" name="chuc-vu" value="giangvien"> Giảng viên</label>
                <label><input type="radio" name="chuc-vu" value="truongbomon"> Trưởng bộ môn</label>
                <label><input type="radio" name="chuc-vu" value="admin"> Admin</label>
            </div>
        </div>
        <div class="form-group d-flex justify-content-end">
            <button style="padding-left: 20px; padding-right: 20px; margin-right: 10px;"
                    id="btnAddEmployee" class="btn btn-primary" type="submit">Tạo
            </button>
            <button style="padding-left: 20px; padding-right: 20px;"
                    class="btn btn-danger" type="reset">Hủy
            </button>
        </div>
    </form>
</div>
<div>
    <h5 style="font-weight: bold">Danh sách tài khoản</h5>
    <table class="table">
        <thead>
        <tr>
            <th>Tài khoản</th>
            <th>Mật khẩu</th>
            <th>Họ tên</th>
            <th>Khoa</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>20110301</td>
            <td>mantran2k2</td>
            <td>Trần Minh Mẫn</td>
            <td>Công nghệ thông tin</td>
            <td>04/07/2002</td>
            <td>Nam</td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a href="">
                        <i class="fa-solid fa-pen-to-square"></i>
                    </a>
                    <a href="">
                        <i class="fa-solid fa-trash"></i>
                    </a>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
