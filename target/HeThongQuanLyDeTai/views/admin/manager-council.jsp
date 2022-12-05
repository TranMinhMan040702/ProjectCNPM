<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="mb-5" action="createregistrationperiod" method="post">
  <label>Đề tài phản biện</label>
  <div class="form-group row">
    <div class="col-6">
      <%-- load đề tài ra nhé     --%>
      <select class="custom-select" name="role" id="">
        <option value="" selected>Website quản lý đề tài khoa</option>
        <option value="">Website thương mại điện tử</option>
      </select>
    </div>
  </div>
  <div class="row">
    <div class="form-group col-6">
      <label>Số lượng giảng viên</label>
      <input
              class="form-control"
              type="text"
              name="count"
              value=""
              required
      />
    </div>
    <div class="form-group col-6">
      <label>Ngày phản biện</label>
      <input
              class="form-control"
              type="date"
              name=""
              value=""
              required
      />
    </div>
  </div>
  <button
          type="submit"
          class="btn btn-primary d-block position-absolute"
          style="right: 16px"
  >
    Tạo hội đồng
  </button>
</form>
<div>
  <h5 style="font-weight: bold">Danh sách hội đồng phản biện</h5>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">MHĐ</th>
      <th scope="col">Đề tài phản biện</th>
      <th scope="col">SLGV</th>
      <th scope="col">Ngày phản biện</th>
      <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
<%--    <c:forEach--%>
<%--            var="regis"--%>
<%--            items="${registrationPeriodModelList}"--%>
<%--    >--%>
      <tr>
        <td>1</td>
        <td>Website đăng ký môn học</td>
        <td>3</td>
        <td>24-12-2022</td>
        <td>
          <div class="d-flex justify-content-around align-items-center">
            <a href="<c:url value="/admin/create-registration/delete?id=${regis.id}"/>">
              <i class="fa-solid fa-pen-to-square"></i>
            </a>
            <a href="<c:url value="/admin/create-registration/delete?id=${regis.id}"/>">
              <i class="fa-solid fa-trash"></i>
            </a>
          </div>
        </td>
      </tr>
<%--    </c:forEach>--%>
    </tbody>
  </table>
</div>
</body>
</html>
