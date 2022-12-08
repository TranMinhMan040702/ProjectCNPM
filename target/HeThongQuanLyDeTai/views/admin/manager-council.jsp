<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var = "check" scope = "session" value = "${action}"/>
<form class="mb-5" <c:if test = "${check == 'create'}"> action="council/create" method="post"</c:if>
        <c:if test="${check == 'update'}">action="../council/update" method="post"</c:if>>>
  <label>Đề tài phản biện</label>
  <div class="form-group row">
    <div class="col-6">
      <%-- load đề tài ra nhé     --%>
      <c:if test = "${check == 'update'}">
        <input>
      </c:if>
      <c:if test = "${check == 'create'}">
      <select class="custom-select" name="projectid" id="">
        <c:forEach var="project" items="${project}">
        <option value="${project.id}">${project.projectLecturers.topic} - ${project.user.username}</option>
        </c:forEach>
      </select>
      </c:if>
    </div>
  </div>
  <div class="row">
    <div class="form-group col-6">
      <label>Số lượng giảng viên</label>
      <input
              class="form-control"
              type="number"
              name="numberLecturers"
              value="<c:if test = "${check == 'update'}">${council.numberLecturers}</c:if>"
              required
      />
    </div>
    <div class="form-group col-6">
      <label>Ngày phản biện</label>
      <input
              class="form-control"
              type="date"
              name="date"
              value="<c:if test = "${check == 'update'}">${date}</c:if>"
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
      <th scope="col">Username</th>
      <th scope="col">SLGV</th>
      <th scope="col">Ngày phản biện</th>
      <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="councilList" items="${councilList}">
      <tr>
        <td>${councilList.id}</td>
        <td>${councilList.projectStudent.projectLecturers.topic}</td>
        <td>${councilList.projectStudent.user.username}</td>
        <td>${councilList.numberLecturers}</td>
        <td>${councilList.dateCounterArgument}</td>
        <td>
          <div class="d-flex justify-content-around align-items-center">
            <a href="<c:url value="/admin/council/update?id=${councilList.id}"/>">
              <i class="fa-solid fa-pen-to-square"></i>
            </a>
            <a href="<c:url value="/admin/council/delete?id=${councilList.id}&idProject=${councilList.projectStudent.id}"/>">
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
