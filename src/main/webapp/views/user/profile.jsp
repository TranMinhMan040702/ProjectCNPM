<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>profile</title>
</head>
<body>
<div style="padding: 20px 50px 50px 50px">
    <h2 class="form-title">Cập nhập thông tin</h2>
    <form>
        <div class="form-group">
            <div class="form-row">
                <div class="col">
                    <label>Họ tên</label>
                    <input
                            type="text"
                            class="form-control"
                            placeholder="Tên của bạn"
                            required
                            name=""
                    />
                </div>
                <div class="col">
                    <label>Giới tính:</label> <br />
                    <label
                    ><input
                            type="radio"
                            value="nam"
                            name="gioi-tinh"
                            checked
                    />
                        Nam</label
                    >
                    <label
                    ><input
                            type="radio"
                            name="gioi-tinh"
                            value="nu"
                    />
                        Nữ</label
                    >
                </div>
            </div>
        </div>
        <div class="form-group">
            <label>Email</label>
            <input
                    type="email"
                    class="form-control"
                    placeholder="Email của bạn"
                    required
                    name=""
            />
        </div>
        <div class="form-group">
            <label>Ngày sinh</label>
            <input
                    type="date"
                    class="form-control"
                    placeholder="Ngày sinh của bạn"
                    required
                    name=""
            />
        </div>
        <div class="form-group">
            <div class="form-row">
                <div class="col">
                    <label>Địa chỉ</label>
                    <select class="form-control">
                        <option value="" selected>
                            Nơi sống của bạn
                        </option>
                        <option value="">TPHCM</option>
                        <option value="">Hà Nội</option>
                        <option value="">Khác</option>
                    </select>
                </div>
                <div class="col">
                    <label>SĐT</label>
                    <input
                            type="tel"
                            class="form-control"
                            placeholder="Số điện thoại"
                            required
                            name=""
                    />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-row">
                <div class="col">
                    <label>Năm hoạt động</label>
                    <input
                            type="text"
                            class="form-control"
                            placeholder="Năm vào trường"
                            required
                            name=""
                    />
                </div>
                <div class="col">
                    <label>Khoa</label>
                    <select
                            id="departments"
                            class="form-control"
                    >
                        <option value="cntt">
                            Công nghệ thông tin
                        </option>
                        <option value="kt">Kinh tế</option>
                        <option value="xd">Xây dựng</option>
                    </select>
                    <a
                            href="#"
                            role="button"
                            class="mt-5"
                            onclick="btnAddDepartment()"
                    >Thêm khoa khác</a
                    >
                </div>
            </div>
        </div>
        <div class="form-group">
            <input type="checkbox" required name="" />
            <label>Xác nhận thay đổi</label>
        </div>
        <div class="form-group">
            <button class="btn btn-success" type="submit">
                Cập nhập
            </button>
            <button
                    style="padding-left: 20px; padding-right: 20px"
                    class="btn btn-danger"
                    type="reset"
            >
                Hủy
            </button>
        </div>
    </form>
</div>
</body>
</html>
