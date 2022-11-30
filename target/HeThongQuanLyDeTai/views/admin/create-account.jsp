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
    <form action="create" method="post">
        <div class="row">
            <div class="form-group col-6">
                <label>Tài khoản</label>
                <input id="a" type="text" class="form-control" placeholder="Tên tài khoản" required name="username">
            </div>
            <div class="form-group col-6">
                <label>Mật khẩu</label>
                <input id="b" type="text" class="form-control" placeholder="Mật khẩu" required name="password">
            </div>
            <div class="form-group col-6">
                <label>Họ tên</label>
                <input id="name" type="text" class="form-control" placeholder="Tên của bạn" required name="fullname">
            </div>
            <div class="form-group col-6">
                <label>Giới tính:</label> <br>
                <label><input type="radio" value="Nam" name="male" checked> Nam</label>
                <label><input type="radio" name="male" value="Nữ"> Nữ</label>
            </div>
            <div class="form-group col-12">
                <label>Email</label>
                <input type="email" class="form-control" placeholder="Email của bạn" required name="email">
            </div>
            <div class="form-group col-12">
                <label>Ngày sinh</label>
                <input id="dob" type="date" class="form-control" placeholder="Ngày sinh của bạn" required name="birthday">
            </div>
            <div class="form-group col-6">
                <label>Địa chỉ</label>
                <input type="tel" class="form-control" placeholder="Địa chỉ hiện tại" required name="address">
            </div>
            <div class="form-group col-6">
                <label>SĐT</label>
                <input type="tel" class="form-control" placeholder="Số điện thoại" required name="phone">
            </div>
            <div class="col">
                <label>Năm hoạt động</label> <input type="text"
                                                    class="form-control" placeholder="Năm vào trường" required
                                                    name="schoolyear">
            </div>
            <div class="col">
                <label>Khoa</label>
                <select id="departments" class="form-control" name="department">
                <option value="Công nghệ thông tin">Công nghệ thông tin</option>
                <option value="Kinh tế">Kinh tế</option>
                <option value="Xây dựng">Xây dựng</option>
                </select>
            </div>
            <div class="form-group col-12">
                <label> Chức vụ</label> <br>
                <label><input type="radio" value="sinhvien" name="role" checked>Sinh viên</label>
                <label><input type="radio" name="role" value="giangvien"> Giảng viên</label>
                <label><input type="radio" name="role" value="truongbomon"> Trưởng bộ môn</label>
                <label><input type="radio" name="role" value="admin"> Admin</label>
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
        <c:forEach var="user" items="${userModelList}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.fullname}</td>
            <td>${user.department}</td>
            <td>${user.birthday}</td>
            <td>${user.male}</td>
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
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
