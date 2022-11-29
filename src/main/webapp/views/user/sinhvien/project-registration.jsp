<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row mb-3">
  <div class="form-group col-6">
    <h5 style="font-weight: bold">Chọn chuyên ngành</h5>
    <select class="form-control">
      <option value="" selected>Công nghệ phần mềm</option>
      <option value="">Kỹ thuật dữ liệu</option>
      <option value="">Hệ thống thông tin</option>
      <option value="">An toàn thông tin</option>
    </select>
  </div>
</div>

<div>
  <h5 style="font-weight: bold">Danh sách đề tài</h5>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Tên đề tài</th>
      <th scope="col">Chuyên ngành</th>
      <th scope="col">GVHD</th>
      <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>Website quản lý đề tài khoa CNTT</td>
      <td>Công nghệ phần mềm</td>
      <td>Huỳnh Xuân Phụng</td>
      <td>
        <div class="d-flex justify-content-around align-items-center">
          <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalRegistration">
            Đăng ký
          </button>
        </div>
      </td>
    </tr>
    </tbody>
  </table>
</div>
<!-- Modal -->
<div class="modal fade" id="modalRegistration" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Đăng ký</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Bạn chắc chắn đăng ký đề tài này
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
        <button type="button" class="btn btn-primary">Đăng ký</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
