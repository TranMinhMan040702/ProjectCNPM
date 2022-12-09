<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${projectStudent.reviews != null}">
<form >
    <div class="row">
        <div class="form-group col-6">
            <input type="text" name="id"  value="" hidden>
            <label >Tên đề tài</label>
            <input type="text" class="form-control" required name="topic"  value="${projectStudent.projectLecturers.topic}">
        </div>
        <div  class="form-group col-6">
            <label>Giáo viên hướng dẫn</label>
            <input type="text" class="form-control" required name="lecturers"  value="${projectStudent.projectLecturers.user.fullname}">
        </div>
        <div  class="form-group col-6">
            <label>Sinh viên thực hiện</label>
<%--            Danh sách nhóm sinh viên thực hiện đề tài--%>
            <input type="text" class="form-control" required name="lecturers"  value="${projectStudent.user.fullname}">
        </div>
        <div class="form-group col-6">
            <label >Khoa</label>
            <input type="text" class="form-control" required name="department"  value="${projectStudent.user.department}">
        </div>
        <div class="form-group col-12">
            <label >Mục tiêu</label>
            <input type="text" class="form-control" required name="target"  value="${projectStudent.projectLecturers.target}">
        </div>
        <div class="form-group col-12">
            <label >Yêu cầu</label>
            <input type="text" class="form-control" required name="request"  value="${projectStudent.projectLecturers.request}">
        </div>
        <div class="form-group col-12">
            <label >Đánh giá</label>
            <input type="text" class="form-control" required name="review"  value="${projectStudent.reviews}">
        </div>
        <div class="form-group col-6">
            <label >Điểm</label>
            <input type="text" class="form-control" required name="point"  value="${projectStudent.point}">
        </div>
    </div>
</form>
</c:if>

<c:if test="${projectStudent.reviews == null}">
<div class="row">
    <div class="form-group col-12">
        <h1>Chưa có đánh giá</h1>

    </div>
</div>
</c:if>
</body>
</html>
