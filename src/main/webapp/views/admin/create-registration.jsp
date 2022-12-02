<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Tạo đợt đăng ký</title>
</head>
<body>
<form class="mb-5">
    <label>Đối tượng</label>
    <div class="form-group row">
        <div class="col-6">
            <select class="custom-select" name="" id="">
                <option value="sinhvien" selected>Sinh viên</option>
                <option value="giangvien">Giảng viên</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-6">
            <label>Chọn ngày bắt đầu</label>
            <input class="form-control" type="date" name="start" value="" required/>
        </div>
        <div class="form-group col-6">
            <label>Chọn ngày kết thúc</label>
            <input class="form-control" type="date" name="end" value="" required/>
        </div>
    </div>
    <button type="submit" class="btn btn-primary d-block position-absolute" style="right: 16px;">Tạo đợt đăng
        ký</button>
</form>
<div>
    <h5 style="font-weight: bold">Danh sách đợt đăng ký</h5>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Đối tượng</th>
            <th scope="col">Ngày bắt đầu</th>
            <th scope="col">Ngày kết thúc</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Sinh viên</td>
            <td>29/11/2022</td>
            <td>29/12/2022</td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a href="" >
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
