<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="mb-5" action="council/create" method="post">
  <label>Đề tài phản biện</label>
  <div class="form-group row">
    <div class="col-6">
      <%-- load đề tài ra nhé     --%>
      <select class="custom-select" name="projectid" id="">
        <c:forEach var="project" items="${projectlecturers}">
        <option value="${project.id}">${project.topic}</option>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="row">
    <div class="form-group col-6">
      <label>Số lượng giảng viên</label>
      <input
              class="form-control"
              type="number"
              name="numberLecturers"
              value=""
              required
      />
    </div>
    <div class="form-group col-6">
      <label>Ngày phản biện</label>
      <input
              class="form-control"
              type="date"
              name="date"
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
    <c:forEach var="councilList" items="${councilList}">
      <tr>
        <td>${councilList.id}</td>
        <td>${councilList.projectLecturers.topic}</td>
        <td>${councilList.numberLecturers}</td>
        <td>${councilList.dateCounterArgument}</td>
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
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
