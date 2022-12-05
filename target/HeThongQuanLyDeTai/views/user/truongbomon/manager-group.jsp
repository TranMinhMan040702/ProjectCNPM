<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="d-flex align-items-center mb-5">
  <h6 style="font-weight: bold">Tìm kiếm giảng viên</h6>
  <form class="form-inline" style="margin-bottom: 5px; margin-left: 10px">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
  </form>
</div>
<div>
  <div class="d-flex justify-content-between">
    <h5 style="font-weight: bold">Danh sách giảng viên trong bộ môn</h5>
  </div>

  <table class="table">
    <thead>
    <tr>
      <th scope="col">Mã số giảng viên</th>
      <th scope="col">Tên giảng viên</th>
      <th scope="col">Bộ môn</th>
      <th scope="col">Thông tin</th>
    </tr>
    </thead>
    <tbody>
    <%--    <c:forEach--%>
    <%--            var="regis"--%>
    <%--            items="${registrationPeriodModelList}"--%>
    <%--    >--%>
    <tr>
      <td>20110201</td>
      <td>Trần Minh Minh</td>
      <td>Công nghệ phần mềm</td>
      <td>
        <a class=""
           data-toggle="modal" data-target="#xem-chi-tiet"
           href="">
          Xem chi tiết
        </a>
      </td>
    </tr>
    <%--    </c:forEach>--%>
    </tbody>
  </table>
</div>
<!-- Modal xem chi tiết-->
<div class="modal fade" id="xem-chi-tiet" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="">Thông tin chi tiết</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="row">
            <div class="form-group col-6">
              <label>MSGV</label>
              <input id="a" type="text" class="form-control" placeholder="Tên tài khoản" required name="username" value="${user.username}">
            </div>
            <div class="form-group col-6">
              <label>Họ tên</label>
              <input id="name" type="text" class="form-control" placeholder="Tên của bạn" required name="fullname" value="${user.fullname}">
            </div>
            <div class="form-group col-6">
              <label>Giới tính:</label> <br>
              <c:set var = "male" scope = "session" value = "${user.male}"/>
              <label><input type="radio" value="Nam" name="male" <c:if  test="${male =='Nam'}">checked</c:if>> Nam</label>
              <label><input type="radio" name="male" value="Nu" <c:if  test="${male !='Nam'}">checked</c:if>> Nữ</label>
            </div>
            <div class="form-group col-12">
              <label>Email</label>
              <input type="email" class="form-control" placeholder="Email của bạn" required name="email" value="${user.email}">
            </div>
            <div class="form-group col-12">
              <label>Ngày sinh</label>
              <input id="dob" type="date" class="form-control" placeholder="Ngày sinh của bạn" required name="birthday" value="${birthday}">
            </div>
            <div class="form-group col-6">
              <label>Địa chỉ</label>
              <input type="tel" class="form-control" placeholder="Địa chỉ hiện tại" required name="address" value="${user.address}">
            </div>
            <div class="form-group col-6">
              <label>SĐT</label>
              <input type="tel" class="form-control" placeholder="Số điện thoại" required name="phone" value="${user.phone}">
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
