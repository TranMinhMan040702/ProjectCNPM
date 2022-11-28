<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="padding: 20px 50px 50px 50px">
    <h2 class="form-title">Tạo tài khoản</h2>
    <form>
        <div class="form-group">
            <div class="form-row">
                <div class="col">
                    <label>Tài khoản</label> <input id="a" type="text"
                                                    class="form-control" placeholder="Tên tài khoản" required
                                                    name="">
                </div>
                <div class="col">
                    <label>Mật khẩu</label> <input id="b" type="text" class="form-control"
                                                   placeholder="Mật khẩu" required name="">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-row">
                <div class="col">
                    <label>Họ tên</label> <input id="name" type="text"
                                                 class="form-control" placeholder="Tên của bạn" required
                                                 name="">
                </div>
                <div class="col">
                    <label>Giới tính:</label> <br> <label><input
                        type="radio" value="nam" name="gender" checked> Nam</label> <label><input
                        type="radio" name="gender" value="nu"> Nữ</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label>Email</label> <input type="email" class="form-control"
                                        placeholder="Email của bạn" required name="">
        </div>
        <div class="form-group">
            <label>Ngày sinh</label> <input id="dob" type="date"
                                            class="form-control" placeholder="Ngày sinh của bạn" required
                                            name="">
        </div>
        <div class="form-group">
            <div class="form-row">
                <div class="col">
                    <label>Địa chỉ</label> <select class="form-control">
                    <option value="" selected>Nơi sống của bạn</option>
                    <option value="">TPHCM</option>
                    <option value="">Hà Nội</option>
                    <option value="">Khác</option>
                </select>
                </div>
                <div class="col">
                    <label>SĐT</label> <input type="tel" class="form-control"
                                              placeholder="Số điện thoại" required name="">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-row">
                <div class="col">
                    <label>Năm hoạt động</label> <input type="text"
                                                        class="form-control" placeholder="Năm vào trường"
                                                        required
                                                        name="">
                </div>
                <div class="col">
                    <label>Khoa</label> <select id="departments"
                                                class="form-control">
                    <option value="cntt">Công nghệ thông tin</option>
                    <option value="kt">Kinh tế</option>
                    <option value="xd">Xây dựng</option>
                </select> <a href="#" role="button" class="mt-5"
                             onclick="btnAddDepartment()">Thêm khoa khác</a>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label> Chức vụ</label> <br> <label><input
                type="radio" value="sinhvien" name="chuc-vu" checked>
            Sinh viên</label> <label><input type="radio" name="chuc-vu"
                                            value="giangvien"> Giảng viên</label> <label><input
                type="radio" name="chuc-vu" value="truongbomon"> Trưởng
            bộ môn</label> <label><input type="radio" name="chuc-vu"
                                         value="admin"> Admin</label>
        </div>
        <div class="form-group">
            <button style="padding-left: 20px; padding-right: 20px;"
                    id="btnAddEmployee" class="btn btn-primary" type="submit">Tạo
            </button>
            <script>
                document.getElementById("btnAddEmployee")
                    .addEventListener('click', function (event) {
                        btnAddEmployee(event)
                    })
            </script>
            <button style="padding-left: 20px; padding-right: 20px;"
                    class="btn btn-danger" type="reset">Hủy
            </button>
        </div>
    </form>
    <div style="padding-bottom: 20px">
        <table style="width: 100%" id="tblEmployees"
               class="table ">
            <thead class="thead-dark">
            <tr>
                <th>Tài khoản</th>
                <th>Mật khẩu</th>
                <th>Họ tên</th>
                <th>Khoa</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</body>
</html>
