<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
  <h5 class="form-title" style="font-weight: bold">Đăng ký đề tài</h5>
  <form action="registration/create" method="post">
    <div class="form-group">
      <div class="row">
        <div class="form-group col-12">
          <label>Tên đề tài</label>
          <input id="a" type="text" class="form-control" placeholder="Tên đề tài" required name="topic"  value="">
        </div>
        <div class="form-group col-6">
            <input hidden name="username" value="${lecturers.username}">
          <label>Chuyên ngành</label>
<%--          <select id="" class="form-control">--%>
<%--            <option value="cntt">Công nghệ thông tin</option>--%>
<%--            <option value="kt">Kinh tế</option>--%>
<%--            <option value="xd">Xây dựng</option>--%>
<%--          </select>--%>
          <input id="" type="text" class="form-control" placeholder="Chuyên ngành" required name="" value="${lecturers.department}" disabled>
            <input name="department" value="${lecturers.department}" hidden>
        </div>
        <div class="form-group col-6">
          <label>Giáo viên hướng dẫn</label>
          <input id="name" type="text" class="form-control" placeholder="GVHD" required name="fullname" value="${lecturers.fullname}" disabled>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="row">
        <div class="form-group col-12">
          <label>Yêu Cầu</label>
          <input type="tel" class="form-control" placeholder="Yêu Cầu" required name="request">
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="row">
        <div class="form-group col-12">
          <label>Mục tiêu</label>
          <input type="tel" class="form-control" placeholder="Mục tiêu" required name="target">
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
