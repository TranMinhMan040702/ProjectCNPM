<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
  <h5 class="form-title" style="font-weight: bold">Tạo tài khoản</h5>
  <form>
    <div class="form-group">
      <div class="row">
        <div class="form-group col-12">
          <label>Tên đề tài</label>
          <input id="a" type="text" class="form-control" placeholder="Tên đề tài" required name="">
        </div>
        <div class="form-group col-6">
          <label>Chuyên ngành</label>
          <select id="" class="form-control">
            <option value="cntt">Công nghệ thông tin</option>
            <option value="kt">Kinh tế</option>
            <option value="xd">Xây dựng</option>
          </select>
        </div>
        <div class="form-group col-6">
          <label>Giáo viên hướng dẫn</label>
          <input id="name" type="text" class="form-control" placeholder="GVHD" required name="">
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="row">
        <div class="form-group col-6">
          <label>Số lượng sinh viên</label>
          <input type="tel" class="form-control" placeholder="Số lượng sinh viên" required name="">
        </div>
        <div class="form-group col-6">
          <label>Niên khóa</label>
          <input type="tel" class="form-control" placeholder="Niên khóa" required name="">
        </div>
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
  <h5 style="font-weight: bold">Danh sách đề tài</h5>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Tên đề tài</th>
      <th scope="col">Chuyên ngành</th>
      <th scope="col">GVHD</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>Website quản lý đề tài khoa CNTT</td>
      <td>Công nghệ phần mềm</td>
      <td>Huỳnh Xuân Phụng</td>
    </tr>
    </tbody>
  </table>
</div>
</body>
</html>
