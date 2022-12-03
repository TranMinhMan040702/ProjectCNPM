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
      <form name="form1" action="http://localhost:8080/ProjectCNPM_war/sinhvien/registration/change" method="get">
        <h5 style="font-weight: bold">Chọn chuyên ngành</h5>
        <select name="department" class="form-control" onchange="document.form1.submit();">
          <option value="" selected disabled hidden>Chọn khoa</option>
          <option value="Công nghệ thông tin">Công nghệ thông tin</option>
          <option value="Kinh tế">Kinh tế</option>
          <option value="Xây dựng">Xây dựng</option>
        </select>
      </form>
    </div>
  </div>

<div>
  <c:set var = "check" scope = "session" value = "${projectStudentModel}"/>
  <c:if test = "${check == null}">
  <h5 style="font-weight: bold">Danh sách đề tài khoa ${department}</h5>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Tên đề tài</th>
      <th scope="col">Chuyên ngành</th>
      <th scope="col">GVHD</th>
      <th scope="col" hidden>ID</th>
      <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <c:forEach items="${projectLecturersModels}" var="p">
    <tbody>
    <tr>  <form action="create?id=${p.id}" method="post">
        <td>${p.topic}</td>
        <td >${p.department}</td>
        <td>${p.user.fullname}</td>
        <td>
          <div class="d-flex justify-content-around align-items-center">
            <button type="submit" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalRegistration">
              Đăng ký
            </button>
          </div>
        </td>
    </form>
    </tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
  <c:if test = "${check != null}">
    <form action="delete" method="get">
    <div class="row">
      <div class="form-group col-6">
        <input type="text" name="id"  value="${projectStudentModel.id}" hidden>
      <label >Tên đề tài</label>
      <input type="text" class="form-control" required name="topic"  value="${projectStudentModel.projectLecturers.topic}">
      </div>
      <div  class="form-group col-6">
        <label>Giáo viên hướng dẫn</label>
        <input type="text" class="form-control" required name="lecturers"  value="${projectStudentModel.projectLecturers.user.fullname}">
      </div>
      <div class="form-group col-12">
        <label >Khoa</label>
        <input type="text" class="form-control" required name="department"  value="${projectStudentModel.projectLecturers.department}">
      </div>
      <div class="form-group col-12">
        <label >Mục tiêu</label>
        <input type="text" class="form-control" required name="target"  value="${projectStudentModel.projectLecturers.target}">
      </div>
      <div class="form-group col-12">
        <label >Yêu cầu</label>
        <input type="text" class="form-control" required name="request"  value="${projectStudentModel.projectLecturers.request}">
      </div>
      <div class="form-group col-6">
        <label >Trạng thái</label>
        <input type="text" class="form-control" required name="status"  value="${projectStudentModel.status}">
      </div>
      <div class="form-group col-6">
        <label >Điểm</label>
        <input type="text" class="form-control" required name="status"  value="${projectStudentModel.point}">
      </div>
    </div>
      <div class="form-group d-flex justify-content-end">
        <button style="padding-left: 20px; padding-right: 20px;"
                class="btn btn-danger" type="submit">Xóa
        </button>
      </div>
    </form>
  </c:if>
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
        <button type="button" class="btn btn-primary" >Đăng ký</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
