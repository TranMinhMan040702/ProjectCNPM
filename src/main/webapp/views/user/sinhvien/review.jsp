<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form >
    <div class="row">
        <div class="form-group col-6">
            <input type="text" name="id"  value="" hidden>
            <label >Tên đề tài</label>
            <input type="text" class="form-control" required name="topic"  value="">
        </div>
        <div  class="form-group col-6">
            <label>Giáo viên hướng dẫn</label>
            <input type="text" class="form-control" required name="lecturers"  value="">
        </div>
        <div  class="form-group col-6">
            <label>Nhóm sinh viên thực hiện</label>
<%--            Danh sách nhóm sinh viên thực hiện đề tài--%>
            <input type="text" class="form-control" required name="lecturers"  value="">
        </div>
        <div class="form-group col-6">
            <label >Khoa</label>
            <input type="text" class="form-control" required name="department"  value="">
        </div>
        <div class="form-group col-12">
            <label >Mục tiêu</label>
            <input type="text" class="form-control" required name="target"  value="">
        </div>
        <div class="form-group col-12">
            <label >Yêu cầu</label>
            <input type="text" class="form-control" required name="request"  value="">
        </div>
        <div class="form-group col-12">
            <label >Đánh giá</label>
<%--            Danh sách đánh giá của các giảng viên--%>
            <input type="text" class="form-control" required name="status"  value="${projectStudentModel.point}">
        </div>
        <div class="form-group col-6">
            <label >Điểm</label>
            <input type="text" class="form-control" required name="status"  value="${projectStudentModel.point}">
        </div>
    </div>
</form>
</body>
</html>
