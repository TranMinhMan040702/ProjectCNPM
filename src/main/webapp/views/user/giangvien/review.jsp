<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div class="d-flex justify-content-between">
        <h5 style="font-weight: bold">Danh sách đề tài cần đánh giá</h5>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã số SV</th>
            <th scope="col">Tên đề tài</th>
            <th scope="col">Chuyên ngành</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach
                    var="proj"
                    items="${projectStudentModels}"
            ><input name="id" value="${proj.id}" hidden>
        <tr>
            <td>${proj.user.username}</td>
            <td>${proj.projectLecturers.topic}</td>
            <td>${proj.projectLecturers.department}</td>
            <td>
                <c:set var="topic" value="${proj.projectLecturers.topic}" />
                <button class="btn btn-primary" onclick="loadStudent('${proj.user.username}','${proj.projectLecturers.topic}', ${proj.id})"
                   data-toggle="modal" data-target="#danh-gia">
                    Đánh giá
                </button>
            </td>
        </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal đánh giá-->


<div class="modal fade" id="danh-gia" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="">Đánh giá đề tài</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="review/create" method="post">
                    <div class="row">
                        <div class="form-group col-6">
                            <input hidden id="idProjectStudent" name="idProject" value="">
                            <label>MSV</label>
                            <input id="username" type="text" class="form-control" required name="username" value="" readonly>
                        </div>
                        <div class="form-group col-6">
                            <label>Tên đề tài</label>
                            <input id="topic" type="text" class="form-control"  required name="topic" value="" readonly>
                        </div>
                        <div class="form-group col-12">
                            <label>Đánh giá</label>
                            <input type="tel" class="form-control" placeholder="Nhập đánh giá" required name="review"
                                   value="">
                        </div>
                        <div class="form-group col-6">
                            <label>Nhập điểm</label>
                            <input type="number" class="form-control" placeholder="Nhập điểm" required name="point"
                                   value="">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Gửi</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<c:url value="/giangvien/review?action=review" var="urlReview"/>
<script>
    function loadStudent(username, topic, id) {
        document.getElementById("username").value = username;
        document.getElementById("topic").value = topic;
        document.getElementById("idProjectStudent").value = id;
    }
</script>
</body>
</html>
